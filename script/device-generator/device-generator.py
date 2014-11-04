#!/usr/bin/env python
#coding:utf-8

import csv
import string
import argparse
import os
import re
import copy
from string import Template

def is_ascii(c):
    return ord(c) < 128

OPTIONAL = "optional"
MANDATORY = "mandatory"
UNDEFINED = "-"

DOCUMENTS_PREFIX_FORMAT = \
"""{indent}/**
{indent} * Property name : {p.name_en}<br>
{indent} * <br>
{indent} * EPC : {p.epc}<br>
{indent} * <br>
{indent} * Contents :<br>
{indent} * {contents_en} <br>
{indent} * <br>
{indent} * Value range (decimal notation) :<br>
{indent} * {value_range_en}<br>
{indent} * <br>
{indent} * Data type : {p.data_type}<br>
{indent} * Data size : {p.data_size}<br>
{indent} * Unit : {p.unit_en}<br>
{indent} * <br>
{indent} * Access rule :<br>
{indent} * Announce - {p.access_rule_anno}<br>
{indent} * Set      - {p.access_rule_set}<br>
{indent} * Get      - {p.access_rule_get}<br>
"""

DOCUMENTS_ANNOUNCEMENT_AT_CHANGE = \
"""{indent} * <br>
{indent} * <b>Announcement at status change</b><br>
"""
DOCUMENTS_SUFFIX_FORMAT = "{indent} */\n"

ADD_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_FORMAT = "\t\taddStatusChangeAnnouncementProperty({p.field_name});\n";
REMOVE_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_FORMAT = "\t\tremoveStatusChangeAnnouncementProperty({p.field_name});\n";
ADD_SET_PROPERTY_FORMAT = "\t\taddSetProperty({p.field_name});\n";
REMOVE_SET_PROPERTY_FORMAT = "\t\tremoveSetProperty({p.field_name});\n";
ADD_GET_PROPERTY_FORMAT = "\t\taddGetProperty({p.field_name});\n";
REMOVE_GET_PROPERTY_FORMAT = "\t\tremoveGetProperty({p.field_name});\n";

EPC_DEFINITION_FORMAT = "\tpublic static final byte {p.field_name} = (byte){p.epc};\n"

OPTIONAL_SET_METHOD_FORMAT = "\tprotected boolean set{p.method_name}(byte[] edt) {{return false;}}\n"

MANDATORY_SET_METHOD_FORMAT = "\tprotected abstract boolean set{p.method_name}(byte[] edt);\n"

OPTIONAL_GET_METHOD_FORMAT = "\tprotected byte[] get{p.method_name}() {{return null;}}\n"

MANDATORY_GET_METHOD_FORMAT= "\tprotected abstract byte[] get{p.method_name}();\n"

VALID_METHOD_FORMAT = \
"""\tprotected boolean isValid{p.method_name}(byte[] edt) {{
\t\tif(edt == null || !(edt.length {limit})) {{return false;}};
\t\treturn true;
\t}}
"""

CASE_SET_PROPERTY_FORMAT = "\t\tcase {p.field_name} : return set{p.method_name}(property.edt);\n"

CASE_GET_PROPERTY_FORMAT = "\t\tcase {p.field_name} : return get{p.method_name}();\n"

CASE_VALID_PROPERTY_FORMAT = "\t\tcase {p.field_name} : return isValid{p.method_name}(property.edt);\n"

CASE_ON_SET_DEFINITION_FORMAT = \
"""\t\t\tcase {p.field_name} : 
\t\t\t\tonSet{p.method_name}(eoj, tid, esv, property, success);
\t\t\t\treturn true;
"""

CASE_ON_GET_DEFINITION_FORMAT = \
"""\t\t\tcase {p.field_name} : 
\t\t\t\tonGet{p.method_name}(eoj, tid, esv, property, success);
\t\t\t\treturn true;
"""

ON_SET_DEFINITION_FORMAT = "\t\tprotected void onSet{p.method_name}(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {{}}\n"

ON_GET_DEFINITION_FORMAT = "\t\tprotected void onGet{p.method_name}(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {{}}\n"

SETTER_CODE_FORMAT = \
"""\t\tpublic Setter reqSet{p.method_name}(byte[] edt) {{
\t\t\treqSetProperty({p.field_name}, edt);
\t\t\treturn this;
\t\t}}
"""

GETTER_CODE_FORMAT = \
"""\t\tpublic Getter reqGet{p.method_name}() {{
\t\t\treqGetProperty({p.field_name});
\t\t\treturn this;
\t\t}}
"""

INFORMER_CODE_FORMAT = \
"""\t\tpublic Informer reqInform{p.method_name}() {{
\t\t\treqInformProperty({p.field_name});
\t\t\treturn this;
\t\t}}
"""

PROXY_SET_PROPERTY_DEFINITION_FORMAT = \
"""\t\t@Override
\t\tprotected boolean set{p.method_name}(byte[] edt){{return false;}}
"""

PROXY_GET_PROPERTY_DEFINITION_FORMAT = \
"""\t\t@Override
\t\tprotected byte[] get{p.method_name}(){{return null;}}
"""



class Device:
    def __init__(self, row_en, row_ja):
        self.class_name_en = row_en[0]
        self.class_name_ja = row_ja[0]
        self.remarks_en = row_en[1]
        self.remarks_ja = row_ja[1]
        self.group_code = row_en[2]
        self.class_code = row_en[3]
        self.property_dict = {}
        self.class_name = ""


    def show(self):
        print "class_name_en : " + self.class_name_en
        print "class_name_ja : " + self.class_name_ja
        print "remarks_en    : " + self.remarks_en
        print "remarks_ja    : " + self.remarks_ja
        print "group_code    : " + self.group_code
        print "class_code    : " + self.class_code
        print "class_name    : " + self.class_name
        for v in self.property_dict.values():
            v.show()

class DeviceProperty:
    def __init__(self, row_en, row_ja):
        self.epc                     = row_en[0]
        self.name_en                 = row_en[1]
        self.name_ja                 = row_ja[1]
        self.contents_en             = row_en[2]
        self.contents_ja             = row_ja[2]
        self.value_range_en          = row_en[3]
        self.value_range_ja          = row_ja[3]
        self.unit_en                 = row_en[4]
        self.unit_ja                 = row_en[4] # TODO: use Japanese database
        # self.unit_ja                 = row_ja[4]
        self.data_type               = row_en[5]
        self.data_size               = row_en[6]
        self.access_rule_anno        = row_en[7]
        self.access_rule_set         = row_en[8]
        self.access_rule_get         = row_en[9]
        self.announcement_at_change  = row_en[10]
        self.remark                  = row_en[11]

        self.field_name              = self.create_field_name()
        self.method_name             = self.create_method_name()

        self.is_device_object_definition = False
        self.is_redefined = False

    def split_property_name(self):
        return re.split('[^a-zA-Z0-9]+', self.name_en)

    def create_field_name(self):
        ss = self.split_property_name()
        field_name = "EPC"
        for s in ss:
            field_name += "_" + s.upper()
        return field_name 

    def create_method_name(self):
        ss = self.split_property_name()
        method_name = ""
        for s in ss:
            method_name += s.title()
        return method_name



    def show(self):
        print "--------------------------"
        print "epc                     : " + self.epc
        print "name_en                 : " + self.name_en
        print "name_ja                 : " + self.name_ja
        print "contents_en             : " + self.contents_en
        print "contents_ja             : " + self.contents_ja
        print "value_range_en          : " + self.value_range_en
        print "value_range_ja          : " + self.value_range_ja
        print "unit_en                 : " + self.unit_en
        print "unit_ja                 : " + self.unit_ja
        print "data_type               : " + self.data_type
        print "data_size               : " + self.data_size
        print "access_rule_anno        : " + self.access_rule_anno
        print "access_rule_set         : " + self.access_rule_set
        print "access_rule_get         : " + self.access_rule_get
        print "announcement_at_change  : " + self.announcement_at_change
        print "remark                  : " + self.remark
        print "field_name              : " + self.field_name
        print "method_name             : " + self.method_name
        print "--------------------------"


class Parser:

    @classmethod
    def parse(self, data_en, data_ja):
        device = Device(data_en[1], data_ja[1])
        property_dict_ja = {}

        for i in range(6, len(data_ja)):
            row_ja = data_ja[i]
            property_dict_ja[row_ja[0]] = row_ja

        for i in range(6, len(data_en)):
            row_en = data_en[i]
            row_ja = ["","","","",""]
            if property_dict_ja.has_key(row_en[0]):
                row_ja = property_dict_ja[row_en[0]]
            devProperty = DeviceProperty(row_en, row_ja)
            #devProperty.show()
            device.property_dict[devProperty.epc] = devProperty
        #device.show()
        #print device.class_name_en
        #print device.class_name_ja
        #print str(len(device.properties.keys()))
        return device

def generate_package_name(device):
    if(device.group_code == "0x00"):
        return "sensor"
    elif(device.group_code == "0x01"):
        return "airconditioner"
    elif(device.group_code == "0x02"):
        return "housingfacilities"
    elif(device.group_code == "0x03"):
        return "cookinghousehold"
    elif(device.group_code == "0x04"):
        return "health"
    elif(device.group_code == "0x05"):
        return "managementoperation"
    elif(device.group_code == "0x06"):
        return "audiovisual"

class JavaCodeGenerator:
    def __init__(self, device):
        self.device = device

    def generate(self):
        template_path = "template.java"
        f = open(template_path)
        t = f.read()
        f.close()
        d = {
            "package_name": generate_package_name(self.device),
            "class_name": self.device.class_name,
            "echo_class_code": self.generate_echo_class_code(),
            "epc_definition": self.generate_epc_definition_code(),
            "setup_property" : self.generate_setup_property_code(),
            "set_get_valid_method_definition": self.generate_set_get_valid_method_definition_code(),
            "set_property": self.generate_set_property_code(),
            "get_property": self.generate_get_property_code(),
            "valid_property": self.generate_valid_property_code(),
            "on_set_property": self.generate_on_set_property_code(),
            "on_get_property": self.generate_on_get_property_code(),
            "on_set_on_get_definition": self.generate_on_set_on_get_definition_code(),
            "setter": self.generate_setter_code(),
            "getter": self.generate_getter_code(),
            "informer": self.generate_informer_code(),
            "proxy": self.generate_proxy_code(),
        }
        code = Template(t).safe_substitute(d)
        return code

    def generate_echo_class_code(self):
        return self.device.group_code + self.device.class_code[2:4]

    def generate_epc_definition_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.is_device_object_definition):
                continue
            code += EPC_DEFINITION_FORMAT.format(p=p)
        return code

    def generate_setup_property_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.is_device_object_definition and (not p.is_redefined)):
                continue
            elif p.is_redefined:
                if(p.announcement_at_change == MANDATORY):
                    code += ADD_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_FORMAT.format(p=p)
                else:
                    code += REMOVE_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_FORMAT.format(p=p)
                if(p.access_rule_set == MANDATORY):
                    code += ADD_SET_PROPERTY_FORMAT.format(p=p)
                else:
                    code += REMOVE_SET_PROPERTY_FORMAT.format(p=p)
                if(p.access_rule_get == MANDATORY):
                    code += ADD_GET_PROPERTY_FORMAT.format(p=p)
                else:
                    code += REMOVE_GET_PROPERTY_FORMAT.format(p=p)
            else:
                if(p.announcement_at_change == MANDATORY):
                    code += ADD_STATUS_CHANGE_ANNOUNCEMENT_PROPERTY_FORMAT.format(p=p)
                if(p.access_rule_set == MANDATORY):
                    code += ADD_SET_PROPERTY_FORMAT.format(p=p)
                if(p.access_rule_get == MANDATORY):
                    code += ADD_GET_PROPERTY_FORMAT.format(p=p)

        return code

    def generate_documents(self, p, indent):
        docs = DOCUMENTS_PREFIX_FORMAT.format(indent=indent, p=p, \
                                              contents_en=p.contents_en.replace("\n", "<br>\n"+indent+" * "), \
                                              value_range_en=p.value_range_en.replace("\n", "<br>\n"+indent+" * "))
        if p.announcement_at_change:
            docs += DOCUMENTS_ANNOUNCEMENT_AT_CHANGE.format(indent=indent)
        docs += DOCUMENTS_SUFFIX_FORMAT.format(indent=indent)
        return docs


    def generate_set_get_valid_method_definition_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.is_device_object_definition and (not p.is_redefined)):
                continue
            property_code = ""
            if(p.access_rule_set == OPTIONAL):
                property_code += self.generate_documents(p, "\t")
                property_code += OPTIONAL_SET_METHOD_FORMAT.format(p=p)
            elif(p.access_rule_set == MANDATORY):
                property_code += self.generate_documents(p, "\t")
                property_code += MANDATORY_SET_METHOD_FORMAT.format(p=p)
            if(p.access_rule_get == OPTIONAL):
                property_code += self.generate_documents(p, "\t")
                property_code += OPTIONAL_GET_METHOD_FORMAT.format(p=p)
            elif(p.access_rule_get == MANDATORY):
                property_code += self.generate_documents(p, "\t")
                property_code += MANDATORY_GET_METHOD_FORMAT.format(p=p)
            property_code += self.generate_documents(p, "\t")
            limit = p.data_size
            if(p.data_size.isdigit()):
                limit = "== " + p.data_size
            property_code += VALID_METHOD_FORMAT.format(p=p, limit=limit)
            code += property_code
        return code

    def generate_set_property_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_set == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += CASE_SET_PROPERTY_FORMAT.format(p=p)
        return code

    def generate_get_property_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_get == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += CASE_GET_PROPERTY_FORMAT.format(p=p)
        return code

    def generate_valid_property_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.is_device_object_definition):
                continue
            code += CASE_VALID_PROPERTY_FORMAT.format(p=p)
        return code

    def generate_on_set_property_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_set == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += CASE_ON_SET_DEFINITION_FORMAT.format(p=p)
        return code

    def generate_on_get_property_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_get == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += CASE_ON_GET_DEFINITION_FORMAT.format(p=p)
        return code

    def generate_on_set_on_get_definition_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_set != UNDEFINED and ((not p.is_device_object_definition) or p.is_redefined)):
                code += self.generate_documents(p, "\t\t")
                code += ON_SET_DEFINITION_FORMAT.format(p=p)
            if(p.access_rule_get != UNDEFINED and ((not p.is_device_object_definition) or p.is_redefined)):
                code += self.generate_documents(p, "\t\t")
                code += ON_GET_DEFINITION_FORMAT.format(p=p)
        return code

    def generate_setter_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_set == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += self.generate_documents(p, "\t\t")
            code += SETTER_CODE_FORMAT.format(p=p)
        return code

    def generate_getter_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_get == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += self.generate_documents(p, "\t\t")
            code += GETTER_CODE_FORMAT.format(p=p)
        return code

    def generate_informer_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_get == UNDEFINED):
                continue
            if(p.is_device_object_definition):
                continue
            code += self.generate_documents(p, "\t\t")
            code += INFORMER_CODE_FORMAT.format(p=p)
        return code

    def generate_proxy_code(self):
        property_dict = self.device.property_dict
        code = ""
        for p in property_dict.values():
            if(p.access_rule_set == MANDATORY):
                code += PROXY_SET_PROPERTY_DEFINITION_FORMAT.format(p=p)
            if(p.access_rule_get == MANDATORY):
                code += PROXY_GET_PROPERTY_DEFINITION_FORMAT.format(p=p)
        return code


def listdir_dironly(dir):
    return [os.path.join(dir,f) for f in os.listdir(dir)
            if os.path.isdir(os.path.join(dir,f))]

def list_csv_files(dir):
    return [os.path.join(dir,f) for f in os.listdir(dir)
            if not os.path.isdir(os.path.join(dir,f))
               and os.path.splitext(f)[1] == ".csv"]

def load_echo_device_class_name_dict():
    echo_device_class_name_path = "./echo-device-class-name.csv"
    echo_device_class_name_list = list(csv.reader(open(echo_device_class_name_path, 'r')))
    class_name_dict = {}
    for i in range(1, len(echo_device_class_name_list)):
        device = echo_device_class_name_list[i]
        class_name_dict[ (device[0], device[1]) ] = device[3]
    return class_name_dict


def scan_top(dir):

    #device_list_en_path = os.path.join(dir,"en","DeviceList.csv")
    device_object_en_path = os.path.join(dir,"en","DeviceObject.csv")
    device_object_en_reader = csv.reader(open(device_object_en_path, 'r'))
    #device_list_ja_path = os.path.join(dir,"ja","DeviceList.csv")
    device_object_ja_path = os.path.join(dir,"ja","DeviceObject.csv")
    device_object_ja_reader = csv.reader(open(device_object_ja_path, 'r'))

    class_name_dict = load_echo_device_class_name_dict();

    parser = Parser()
    device_object = parser.parse(list(device_object_en_reader), list(device_object_ja_reader))
    devices_dir_path_en = os.path.join(dir,"en")
    devices_dir_path_ja = os.path.join(dir,"ja")
    csv_files_en = list_csv_files(devices_dir_path_en)
    csv_files_ja = list_csv_files(devices_dir_path_ja)
    deivce_object_epc_list = device_object.property_dict.keys()
    for device_file_en in csv_files_en:
        file_name = os.path.basename(device_file_en)
        if file_name == "DeviceObject.csv":
            pass
        elif file_name == "DeviceList.csv":
            pass
        else:
            #print file_name
            device_file_ja = os.path.join(devices_dir_path_ja, file_name)
            device_en_reader = csv.reader(open(device_file_en, 'r'))
            device_ja_reader = csv.reader(open(device_file_ja, 'r'))
            device = parser.parse(list(device_en_reader), list(device_ja_reader))
            device.class_name = class_name_dict[(device.group_code, device.class_code)]
            #print device.class_name

            for epc in deivce_object_epc_list:
                if device.property_dict.has_key(epc):
                    device.property_dict[epc].is_redefined = True
                else:
                    device.property_dict[epc] = device_object.property_dict[epc]
                device.property_dict[epc].is_device_object_definition = True
            generate_java_code(device)
            #print str(len(device.properties.keys()))
            #device.show()
    controller = copy.deepcopy(device_object)
    controller.class_name_en = "Controller"
    controller.class_name_ja = "コントローラ"
    controller.remarks_en = ""
    controller.remarks_ja = ""
    controller.group_code = "0x05"
    controller.class_code = "0xFF"
    controller.class_name = "Controller"
    property_dict = controller.property_dict
    for p in property_dict.values():
        p.is_device_object_definition = True
    generate_java_code(controller)

def generate_java_code(device):
    generator = JavaCodeGenerator(device)
    code = generator.generate()
    package_name = generate_package_name(device)
    dst_dir_path = "dst/"+package_name
    if not os.path.exists(dst_dir_path):
        os.makedirs(dst_dir_path)
    dst_path = dst_dir_path + "/" + device.class_name+".java"
    f = open(dst_path, 'w')
    f.write(code)
    f.close()



def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("target_directory",
                        help="directory that contains csv directory(ja,en,..).")
    args = parser.parse_args()
    scan_top(args.target_directory)


if __name__ == "__main__":
    main()

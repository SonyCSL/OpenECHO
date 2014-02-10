/**
 * ControlP5 Color picker. a simple color picker, 
 * 4 horizontal sliders controlling the RGBA channels of a color.
 * to grab the current color value, use function getColorValue() of
 * the color picker.
 *
 * find a list of public methods available for the ColorPicker Controller 
 * at the bottom of this sketch's source code
 *
 * by Andreas Schlegel, 2012
 * www.sojamo.de/libraries/controlP5
 *
 */
import controlP5.*;

ControlP5 cp5;

ColorPicker cp;

void setup() {
  size(400, 600);
  noStroke();
  cp5 = new ControlP5(this);
  cp = cp5.addColorPicker("picker")
          .setPosition(60, 100)
          .setColorValue(color(255, 128, 0, 128))
          ;
}

void draw() {
  background(cp.getColorValue());
  fill(0, 80);
  rect(50, 90, 275, 80);
}

public void controlEvent(ControlEvent c) {
  // when a value change from a ColorPicker is received, extract the ARGB values
  // from the controller's array value
  if(c.isFrom(cp)) {
    int r = int(c.getArrayValue(0));
    int g = int(c.getArrayValue(1));
    int b = int(c.getArrayValue(2));
    int a = int(c.getArrayValue(3));
    color col = color(r,g,b,a);
    println("event\talpha:"+a+"\tred:"+r+"\tgreen:"+g+"\tblue:"+b+"\tcol"+col);
  }
}

// color information from ColorPicker 'picker' are forwarded to the picker(int) function
void picker(int col) {
  println("picker\talpha:"+alpha(col)+"\tred:"+red(col)+"\tgreen:"+green(col)+"\tblue:"+blue(col)+"\tcol"+col);
}


void keyPressed() {
  switch(key) {
    case('1'):
    // method A to change color
    cp.setArrayValue(new float[] {120, 0, 120, 255});
    break;
    case('2'):
    // method B to change color
    cp.setColorValue(color(255, 0, 0, 255));
    break;
  }
}




/*
 a list of all methods available for the ColorPicker Controller
 use ControlP5.printPublicMethodsFor(ColorPicker.class);
 to print the following list into the console.
 
 You can find further details about class ColorPicker in the javadoc.
 
 Format:
 ClassName : returnType methodName(parameter type)
 
 
 controlP5.ColorPicker : ColorPicker setArrayValue(float[]) 
 controlP5.ColorPicker : ColorPicker setColorValue(int)
 controlP5.ColorPicker : String getInfo() 
 controlP5.ColorPicker : int getColorValue() 
 controlP5.ControlGroup : ColorPicker activateEvent(boolean) 
 controlP5.ControlGroup : ColorPicker addListener(ControlListener) 
 controlP5.ControlGroup : ColorPicker hideBar() 
 controlP5.ControlGroup : ColorPicker removeListener(ControlListener) 
 controlP5.ControlGroup : ColorPicker setBackgroundColor(int) 
 controlP5.ControlGroup : ColorPicker setBackgroundHeight(int) 
 controlP5.ControlGroup : ColorPicker setBarHeight(int) 
 controlP5.ControlGroup : ColorPicker showBar() 
 controlP5.ControlGroup : ColorPicker updateInternalEvents(PApplet) 
 controlP5.ControlGroup : String getInfo() 
 controlP5.ControlGroup : String toString() 
 controlP5.ControlGroup : boolean isBarVisible() 
 controlP5.ControlGroup : int getBackgroundHeight() 
 controlP5.ControlGroup : int getBarHeight() 
 controlP5.ControlGroup : int listenerSize() 
 controlP5.ControllerGroup : CColor getColor() 
 controlP5.ControllerGroup : ColorPicker add(ControllerInterface) 
 controlP5.ControllerGroup : ColorPicker bringToFront() 
 controlP5.ControllerGroup : ColorPicker bringToFront(ControllerInterface) 
 controlP5.ControllerGroup : ColorPicker close() 
 controlP5.ControllerGroup : ColorPicker disableCollapse() 
 controlP5.ControllerGroup : ColorPicker enableCollapse() 
 controlP5.ControllerGroup : ColorPicker hide() 
 controlP5.ControllerGroup : ColorPicker moveTo(ControlWindow) 
 controlP5.ControllerGroup : ColorPicker moveTo(PApplet) 
 controlP5.ControllerGroup : ColorPicker open() 
 controlP5.ControllerGroup : ColorPicker registerProperty(String) 
 controlP5.ControllerGroup : ColorPicker registerProperty(String, String) 
 controlP5.ControllerGroup : ColorPicker remove(CDrawable) 
 controlP5.ControllerGroup : ColorPicker remove(ControllerInterface) 
 controlP5.ControllerGroup : ColorPicker removeCanvas(ControlWindowCanvas) 
 controlP5.ControllerGroup : ColorPicker removeProperty(String) 
 controlP5.ControllerGroup : ColorPicker removeProperty(String, String) 
 controlP5.ControllerGroup : ColorPicker setAddress(String) 
 controlP5.ControllerGroup : ColorPicker setArrayValue(float[]) 
 controlP5.ControllerGroup : ColorPicker setColor(CColor) 
 controlP5.ControllerGroup : ColorPicker setColorActive(int) 
 controlP5.ControllerGroup : ColorPicker setColorBackground(int) 
 controlP5.ControllerGroup : ColorPicker setColorForeground(int) 
 controlP5.ControllerGroup : ColorPicker setColorLabel(int) 
 controlP5.ControllerGroup : ColorPicker setColorValue(int) 
 controlP5.ControllerGroup : ColorPicker setHeight(int) 
 controlP5.ControllerGroup : ColorPicker setId(int) 
 controlP5.ControllerGroup : ColorPicker setLabel(String) 
 controlP5.ControllerGroup : ColorPicker setMouseOver(boolean) 
 controlP5.ControllerGroup : ColorPicker setMoveable(boolean) 
 controlP5.ControllerGroup : ColorPicker setOpen(boolean) 
 controlP5.ControllerGroup : ColorPicker setPosition(PVector) 
 controlP5.ControllerGroup : ColorPicker setPosition(float, float) 
 controlP5.ControllerGroup : ColorPicker setStringValue(String) 
 controlP5.ControllerGroup : ColorPicker setUpdate(boolean) 
 controlP5.ControllerGroup : ColorPicker setValue(float) 
 controlP5.ControllerGroup : ColorPicker setVisible(boolean) 
 controlP5.ControllerGroup : ColorPicker setWidth(int) 
 controlP5.ControllerGroup : ColorPicker show() 
 controlP5.ControllerGroup : ColorPicker update() 
 controlP5.ControllerGroup : ColorPicker updateAbsolutePosition() 
 controlP5.ControllerGroup : ControlWindow getWindow() 
 controlP5.ControllerGroup : ControlWindowCanvas addCanvas(ControlWindowCanvas) 
 controlP5.ControllerGroup : Controller getController(String) 
 controlP5.ControllerGroup : ControllerProperty getProperty(String) 
 controlP5.ControllerGroup : ControllerProperty getProperty(String, String) 
 controlP5.ControllerGroup : Label getCaptionLabel() 
 controlP5.ControllerGroup : Label getValueLabel() 
 controlP5.ControllerGroup : PVector getPosition() 
 controlP5.ControllerGroup : String getAddress() 
 controlP5.ControllerGroup : String getInfo() 
 controlP5.ControllerGroup : String getName() 
 controlP5.ControllerGroup : String getStringValue() 
 controlP5.ControllerGroup : String toString() 
 controlP5.ControllerGroup : Tab getTab() 
 controlP5.ControllerGroup : boolean isCollapse() 
 controlP5.ControllerGroup : boolean isMouseOver() 
 controlP5.ControllerGroup : boolean isMoveable() 
 controlP5.ControllerGroup : boolean isOpen() 
 controlP5.ControllerGroup : boolean isUpdate() 
 controlP5.ControllerGroup : boolean isVisible() 
 controlP5.ControllerGroup : boolean setMousePressed(boolean) 
 controlP5.ControllerGroup : float getValue() 
 controlP5.ControllerGroup : float[] getArrayValue() 
 controlP5.ControllerGroup : int getHeight() 
 controlP5.ControllerGroup : int getId() 
 controlP5.ControllerGroup : int getWidth() 
 controlP5.ControllerGroup : void remove() 
 java.lang.Object : String toString() 
 java.lang.Object : boolean equals(Object) 
 
 
 
 */

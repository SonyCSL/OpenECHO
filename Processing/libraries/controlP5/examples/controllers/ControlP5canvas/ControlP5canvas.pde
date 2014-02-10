/**
 * ControlP5 Canvas
 * The ControlWindowCanvas allow you to add custom graphics to 
 * the default controlP5 renderer or a controlWindow rednerer.
 *
 * find a list of public methods available for the Canvas Controller 
 * at the bottom of this sketch's source code
 *
 * by Andreas Schlegel, 2011
 * www.sojamo.de/libraries/controlp5
 * 
 */


import controlP5.*;

ControlP5 cp5;

ControlWindow controlWindow;

Canvas cc;

// MyCanvas, your Canvas render class
class MyCanvas extends Canvas {

  int y;

  public void setup(PApplet theApplet) {
    y = 200;
  }  

  public void draw(PApplet p) {
    // renders a square with randomly changing colors
    // make changes here.
    p.fill(100);
    p.rect(p.mouseX-20, y-20, 240, 30);
    p.fill(255);
    p.text("This text is drawn by MyCanvas", p.mouseX,y);
    p.text("This text is drawn by MyCanvas", p.mouseX,y);
  }
}


void setup() {
  size(400, 400);
  frameRate(30);
  cp5 = new ControlP5(this);

  // create a control window canvas and add it to
  // the previously created control window.  
  cc = new MyCanvas();
  cc.pre(); // use cc.post(); to draw on top of existing controllers.
  cp5.addCanvas(cc); // add the canvas to cp5
}

void draw() {
  background(0);
  fill(60);
  rect(100, 100, 200, 200);
}


/*
 a list of all methods available for the ControlWindowCanvas Controller
 use ControlP5.printPublicMethodsFor(Canvas.class);
 to print the following list into the console.
 
 You can find further details about class Canvas in the javadoc.
 
 Format:
 ClassName : returnType methodName(parameter type)
 
 controlP5.Canvas : void moveTo(ControlWindow) 
 controlP5.Canvas : void setup(PApplet) 
 controlP5.Canvas : void draw(PApplet) 
 java.lang.Object : String toString() 
 java.lang.Object : boolean equals(Object) 
 */
 
 

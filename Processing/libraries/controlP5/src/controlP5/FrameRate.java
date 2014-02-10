
package controlP5;

import processing.core.PApplet;

public class FrameRate extends Textlabel {

	private int _myInterval = 10;

	private float _myIntervalSum = 0;

	private int cnt = 0;


	protected FrameRate(final ControlP5 theControlP5, final Tab theParent, final String theValue, final int theX, final int theY) {
		super(theControlP5, theParent, "framerate", "-", theX, theY);
	}


	public FrameRate setInterval(int theValue) {
		_myInterval = theValue;
		return this;
	}


	@Override public void draw(PApplet theApplet) {
		if ((cnt++) % _myInterval == 0) {
			setText("" + PApplet.round(_myIntervalSum / _myInterval));
			_myIntervalSum = 0;
		}
		_myIntervalSum += theApplet.frameRate;
		super.draw(theApplet);
	}

}

package controlP5;

import processing.core.PApplet;

/**
 * The Slider2D allows to control a handle within a 2D area. This controller returns an arrayValue with the current xy position of its
 * handle.
 * 
 * @author andreas schlegel
 * 
 * @example controllers/ControlP5slider2D
 * 
 */
public class Slider2D extends Controller<Slider2D> {

	protected int cursorWidth = 10, cursorHeight = 10;

	protected float cursorX, cursorY;

	protected float _myMinX, _myMinY;

	protected float _myMaxX, _myMaxY;

	public boolean isCrosshairs = true;

	private String _myValueLabelSeparator = ",";

	/**
	 * Convenience constructor to extend Slider2D.
	 * 
	 * @example use/ControlP5extendController
	 * @param theControlP5
	 * @param theName
	 */
	public Slider2D(ControlP5 theControlP5, String theName) {
		this(theControlP5, theControlP5.getDefaultTab(), theName, 0, 0, 99, 9);
		theControlP5.register(theControlP5.papplet, theName, this);
	}

	protected Slider2D(ControlP5 theControlP5, ControllerGroup<?> theParent, String theName, int theX, int theY, int theWidth, int theHeight) {
		super(theControlP5, theParent, theName, theX, theY, theWidth, theHeight);
		_myArrayValue = new float[] { 0.0f, 0.0f };
		_myMinX = 0;
		_myMinY = 0;
		_myMaxX = theWidth;
		_myMaxY = theHeight;
		getCaptionLabel().setPadding(0, Label.paddingY).align(LEFT, BOTTOM_OUTSIDE);
		getValueLabel().setPadding(0, Label.paddingY).align(RIGHT, BOTTOM_OUTSIDE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controlP5.Controller#updateInternalEvents(processing.core.PApplet)
	 */
	@ControlP5.Invisible public Slider2D updateInternalEvents(PApplet theApplet) {
		if (isInside()) {
			if (!cp5.isAltDown()) {
				float tX = PApplet.constrain(_myControlWindow.mouseX - (_myParent.getAbsolutePosition().x + position.x), 0, width - cursorWidth);
				float tY = PApplet.constrain(_myControlWindow.mouseY - (_myParent.getAbsolutePosition().y + position.y), 0, height - cursorHeight);
				if (isMousePressed) {
					cursorX = tX;
					cursorY = tY;
					updateValue();
				}
			}
		}
		return this;
	}

	Slider2D updateValue() {
		return setValue(0);
	}

	/**
	 * sets the minimum value for the x-axis
	 * 
	 * @param theMinX
	 * @return Slider2D
	 */
	public Slider2D setMinX(float theMinX) {
		_myMinX = theMinX;
		return updateValue();
	}

	/**
	 * sets the minimum value for the y-axis
	 * 
	 * @param theMinY
	 * @return Slider2D
	 */
	public Slider2D setMinY(float theMinY) {
		_myMinY = theMinY;
		return updateValue();
	}

	/**
	 * sets the maximum value for the x-axis
	 * 
	 * @param theMaxX
	 * @return Slider2D
	 */
	public Slider2D setMaxX(float theMaxX) {
		_myMaxX = theMaxX;
		return updateValue();
	}

	/**
	 * sets the maximum value for the y-axis
	 * 
	 * @param theMaxY
	 * @return Slider2D
	 */
	public Slider2D setMaxY(float theMaxY) {
		_myMaxY = theMaxY;
		return updateValue();
	}

	public float getMinX() {
		return _myMinX;
	}

	public float getMinY() {
		return _myMinY;
	}

	public float getMaxX() {
		return _myMaxX;
	}

	public float getMaxY() {
		return _myMaxY;
	}

	public float getCursorX() {
		return cursorX;
	}

	public float getCursorY() {
		return cursorY;
	}

	public float getCursorWidth() {
		return cursorWidth;
	}

	public float getCursorHeight() {
		return cursorHeight;
	}

	public Slider2D disableCrosshair() {
		isCrosshairs = false;
		return this;
	}

	public Slider2D enableCrosshair() {
		isCrosshairs = false;
		return this;
	}

	/*
	 * (non-Javadoc) TODO see https://forum.processing.org/topic/controlp5-slider2d-questions
	 * 
	 * @see controlP5.Controller#setArrayValue(float[])
	 */
	@Override public Slider2D setArrayValue(float[] theArray) {
		_myArrayValue = theArray;
		float rX = (width - cursorWidth) / (float) (_myMaxX - _myMinX);
		float rY = (height - cursorHeight) / (float) (_myMaxY - _myMinY);
		cursorX = PApplet.constrain(theArray[0] * rX, 0, width - cursorWidth);
		cursorY = PApplet.constrain(theArray[1] * rY, 0, height - cursorHeight);
		return updateValue();
	}

	public float[] getArrayValue() {
		return _myArrayValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controlP5.Controller#setValue(float)
	 */
	public Slider2D setValue(float theValue) {
		_myArrayValue[0] = cursorX / ((float) (width - cursorWidth) / (float) width);
		_myArrayValue[1] = cursorY / ((float) (height - cursorHeight) / (float) height);
		_myArrayValue[0] = PApplet.map(_myArrayValue[0], 0, width, _myMinX, _myMaxX);
		_myArrayValue[1] = PApplet.map(_myArrayValue[1], 0, height, _myMinY, _myMaxY);
		_myValueLabel.set(adjustValue(_myArrayValue[0], 0) + _myValueLabelSeparator + adjustValue(_myArrayValue[1], 0));
		broadcast(FLOAT);
		return this;
	}

	/**
	 * assigns a random value to the controller.
	 */
	public Slider2D shuffle() {
		float rX = (float) Math.random();
		float rY = (float) Math.random();
		_myArrayValue[0] = rX * width;
		_myArrayValue[0] = rY * height;
		return setValue(0);
	}

	public void setValueLabelSeparator(String theSeparator) {
		_myValueLabelSeparator = theSeparator;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override @ControlP5.Invisible public Slider2D updateDisplayMode(int theMode) {
		_myDisplayMode = theMode;
		switch (theMode) {
		case (DEFAULT):
			_myControllerView = new Slider2DView();
			break;
		case (IMAGE):
		case (SPRITE):
		case (CUSTOM):
		default:
			break;
		}
		return this;
	}

	class Slider2DView implements ControllerView<Slider2D> {

		public void display(PApplet theApplet, Slider2D theController) {

			theApplet.noStroke();

			if (theController.isInside()) {
				theApplet.fill(theController.getColor().getForeground());
			} else {
				theApplet.fill(theController.getColor().getBackground());
			}

			theApplet.rect(0, 0, getWidth(), getHeight());

			if (isCrosshairs) {
				if (theController.isInside()) {
					theApplet.fill(theController.getColor().getBackground());
				} else {
					theApplet.fill(theController.getColor().getForeground());
				}
				theApplet.rect(0, (int) (getCursorY() + getCursorHeight() / 2), (int) getWidth(), 1);
				theApplet.rect((int) (getCursorX() + getCursorWidth() / 2), 0, 1, (int) getHeight());
			}

			theApplet.fill(theController.getColor().getActive());
			theApplet.rect((int) getCursorX(), (int) getCursorY(), (int) getCursorWidth(), (int) getCursorHeight());

			getCaptionLabel().draw(theApplet, 0, 0, theController);
			getValueLabel().draw(theApplet, 0, 0, theController);
		}

	}
}

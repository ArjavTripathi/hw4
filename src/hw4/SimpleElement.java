package hw4;

// TODO:
// Special documentation requirement: (see page 11 of documentation)
// you must add a comment to the top of the SimpleElement class
// with a couple of sentences explaining how you decided to organize
// the class hierarchy for the elements.

import api.AbstractElement;

import java.awt.*;

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
Star * @author Arjava Tripathi
 */
public class SimpleElement extends CommonMethods{
	private double x;
	private double y;
	private int width;
	private int height;
	private boolean isDelete;
	private int fps;

	/**
	 * Constructs a new SimpleElement.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public SimpleElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		super.IncrementFPS();
	}




}

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
 * @author YOUR NAME HERE
 */
// TODO: This class must directly or indirectly extend AbstractElement
public class SimpleElement extends AbstractElement {
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
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isDelete = false;
	}

	@Override
	public void setPosition(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	@Override
	public double getXReal() {
		return x;
	}

	@Override
	public double getYReal() {
		return y;
	}

	@Override
	public void update() {
		fps++;
	}

	@Override
	public int getFrameCount() {
		return fps;
	}

	@Override
	public boolean isMarked() {
		return isDelete;
	}

	@Override
	public void markForDeletion() {
		isDelete = true;
	}

	@Override
	public boolean collides(AbstractElement other) {
		double otherx = other.getXReal();
		double othery = other.getYReal();
		return otherx == getXReal() || othery == getYReal() ? true : false;
	}

	@Override
	public int getXInt() {
		return (int)x;
	}

	@Override
	public int getYInt() {
		return (int)y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public Rectangle getRect() {
		return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
	}

	// TODO: everything

}

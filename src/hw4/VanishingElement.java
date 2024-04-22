package hw4;

import api.AbstractElement;

import java.awt.*;

/**
 * An element that does not move. Instead, it is intended to appear on the
 * screen for a fixed number of frames.
 * 
 * @author Arjava Tripathi
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class VanishingElement extends AbstractElement {

	/**
	 * Constructs a new VanishingElement.
	 * 
	 * @param x           x-coordinate of upper left corner
	 * @param y           y-coordinate of upper left corner
	 * @param width       element's width
	 * @param height      element's height
	 * @param initialLife the number of frames until this element marks itself for
	 *                    deletion
	 */
	private double x;
	private double y;
	private int width;
	private int height;
	private int initialLife;

	public VanishingElement(double x, double y, int width, int height, int initialLife) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.initialLife = initialLife
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

	}

	@Override
	public int getFrameCount() {
		return 0;
	}

	@Override
	public boolean isMarked() {
		return false;
	}

	@Override
	public void markForDeletion() {

	}

	@Override
	public boolean collides(AbstractElement other) {
		return false;
	}

	@Override
	public int getXInt() {
		return 0;
	}

	@Override
	public int getYInt() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public Rectangle getRect() {
		return null;
	}

	// TODO: everything

}

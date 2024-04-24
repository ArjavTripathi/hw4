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
	private int fps;
	private boolean deletion;

	public VanishingElement(double x, double y, int width, int height, int initialLife) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.initialLife = initialLife;
		this.fps = 0;
		this.deletion = false;
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
		if(getInitialLife() == 0){
			markForDeletion();
		} else{
			decrementInitialLife();
		}
		incrementFPS();
	}

	@Override
	public int getFrameCount() {
		return fps;
	}

	@Override
	public boolean isMarked() {
		return deletion;
	}

	private void incrementFPS(){
		fps++;
	}

	@Override
	public void markForDeletion() {
		deletion = true;
	}

	@Override
	public boolean collides(AbstractElement other) {
		Rectangle rect = other.getRect();
		Rectangle curr = getRect();
		return curr.intersects(rect);
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

	private int getInitialLife(){
		return initialLife;
	}

	private void decrementInitialLife(){
		initialLife--;
	}

}

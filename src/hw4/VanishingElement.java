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
public class VanishingElement extends CommonMethods {

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
	private int Life;

	public VanishingElement(double x, double y, int width, int height, int Life) {
		super(x, y, width, height);
		this.Life = Life;
	}

	@Override
	public void update() {
		if(getLife() >0)
		{
			decrementLife();
		}
		if(getLife() <= 0){
			super.markForDeletion();
		}
		super.update();
	}
	public int getLife(){
		return Life;
	}

	private void decrementLife(){
		Life--;
	}

}

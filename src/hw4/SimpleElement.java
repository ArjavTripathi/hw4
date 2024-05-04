package hw4;

/**
 * Class hierarchy works the following way:
 * CommonMethods class extends AbstractElement class. This method also contains methods that is used in more than one
 * element. Every other element extends this, only overriding update method and whatever else is necessary from commonMethod
 */

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
Star * @author Arjava Tripathi
 */
public class SimpleElement extends CommonMethods{

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
		super.update();
	}

}

package hw4;

/**
 * An element in which the <code>update</code> method updates the position each
 * frame according to a <em>velocity</em> vector (deltaX, deltaY). The units are
 * assumed to be "pixels per frame".
 * 
 * @author Arjava Tripathi
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class MovingElement extends CommonMethods {

	/**
	 * Constructs a MovingElement with a default velocity of zero in both
	 * directions.
	 *
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */


	public MovingElement(double x, double y, int width, int height) {
		super(x, y, width, height);

	}

	@Override
	public void update() {
		double newX = getXReal() + getDeltaX();
		double newY = getYReal() + getDeltaY();
		setPosition(newX, newY);
		super.update();
	}
}



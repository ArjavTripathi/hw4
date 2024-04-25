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

	private double deltax;
	private double deltay;
	public MovingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.deltax = 0;
		this.deltay = 0;
	}
	@Override
	public void update() {
		double newX = super.getXReal() + getDeltaX();
		double newY = super.getYReal() + getDeltaY();
		super.setPosition(newX, newY);
		super.IncrementFPS();
	}

	public void setVelocity(double dx, double dy){
		deltax = dx;
		deltay = dy;
	}

	public double getDeltaX(){
		return deltax;
	}

	public double getDeltaY(){
		return deltay;
	}
}

package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Arjava Tripathi
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FlyingElement extends CommonMethods {

	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */

	private double deltaX;
	private double deltaY;
	private boolean grounded;

	private double gravity;


	public FlyingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.deltaY = 0;
		this.deltaX = 0;
		this.grounded = true;
		this.gravity = 0;
	}

	@Override
	public void update() {
		super.IncrementFPS();
		double newx = super.getXReal() + getDeltaX();
		double newy = super.getYReal() + getDeltaY();
		super.setPosition(newx, newy);

	}

	public void setVelocity(double deltaX, double deltaY){
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	public void setGravity(double gravity){
		this.gravity = gravity;
	}

	private boolean getGrounded(){
		return grounded;
	}

	public void setGrounded(boolean grounded){
		this.grounded = grounded;
	}

	public double getDeltaX(){
		return deltaX;
	}

	public double getDeltaY(){
		if(getGrounded()){
			return deltaY;
		} else {
			return deltaY + gravity;
		}

	}

}

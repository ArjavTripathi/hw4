package hw4;

import api.AbstractElement;

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * move up 10 pixels, the follower moves up 10 pixels. However, the follower may
 * not always be at a fixed location relative to the base. When the horizontal
 * velocity of the follower is set to a non-zero value, the follower will
 * oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Arjava Tripathi
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FollowerElement extends CommonMethods {

	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	private boolean flag;
	private AbstractElement base;
	private int initialOffset;

	private double previousX;
	private int count;

	public FollowerElement(int width, int height, int initialOffset) {
		super(0, 0, width, height);
		this.flag = true;
		this.initialOffset = initialOffset;
	}

	@Override
	public void update() {
		super.update();
		setBounds(base.getXReal(), base.getXReal() + base.getWidth());
		double newX = getXReal() + getDeltaX();
		if(newX + getWidth() >= getMax()){
			newX = getMax() - getWidth();
		}
		if(newX < getMin()){
			newX = getMin() + initialOffset;
		}
		setPosition(newX, base.getYReal() - getHeight());
	}

	@Override
	public double getDeltaX(){
		if(getXReal()  <= getMin()){
			flag = true;
		} else if(getXReal() + getWidth() >= getMax()){
			flag = false;
		}
		if(flag){
			return super.getDeltaX();
		} else{
			return super.getDeltaX() * -1;
		}
	}

	public void setBase(AbstractElement b){
		base = b;
		setPosition(base.getXReal() + initialOffset, base.getYReal() - getHeight());
		setBounds(base.getXReal(), base.getXReal() + base.getWidth());
		previousX = base.getXReal();
	}

}

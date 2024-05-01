package hw4;

import api.AbstractElement;

import java.util.ArrayList;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Arjava Tripathi
 */
public class PlatformElement extends CommonMethods{

	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	private double min;
	private double max;
	private double deltaX;
	private double deltaY;
	private ArrayList<AbstractElement> elements;
	private boolean flag;

	public PlatformElement(double x, double y, int width, int height) {
		super(x, y, width, height, 0, 0);
		this.min = 0;
		this.max = 0;
		this.deltaX = 0;
		this.deltaY = 0;
		this.elements = new ArrayList<>();
		this.flag = false;
	}

	@Override
	public void update() {
		super.update();
		double x = getXReal();
		double newX = getXReal() + getDeltaX();
		if(newX + getWidth() >= getMax()){
			newX = getMax() - getWidth();
		}
		if(newX < getMin()){
			newX = getMin();
		}
		super.setPosition(newX, getYReal());
		java.util.ArrayList<AbstractElement> e = getAssociated();
		for(AbstractElement ele: e){
			ele.update();
		}
	}
	public void setVelocity(double deltaX, double deltaY){
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	public double getDeltaY(){return deltaY;}

	public double getDeltaX(){
		if(getXReal() + getWidth() >= getMax()){
			flag = true;
		} else if (getXReal() <= getMin()){
			flag = false;
		}
		if(flag){
			return deltaX * -1;
		} else{
			return deltaX;
		}
	}

	public void setBounds(double min, double max){
		setMin(min);
		setMax(max);
	}

	public java.util.ArrayList<AbstractElement> getAssociated(){
		return elements;
	}

	public void deleteMarkedAssociated(){
		for(AbstractElement e : this.elements){
			if(e.isMarked()){
				elements.remove(e);
			}
		}
	}

	public void addAssociated(FollowerElement follower){
		elements.add(follower);
	}

	public void addAssociated(AttachedElement attached){
		attached.setBase(this);
		elements.add(attached);
	}
}

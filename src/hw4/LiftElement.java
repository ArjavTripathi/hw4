package hw4;

import api.AbstractElement;

import java.util.ArrayList;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author YOUR NAME HERE
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class LiftElement extends CommonMethods {

	private ArrayList<AbstractElement> elements;

	private double deltaX;
	private double deltaY;
	private boolean flag;


	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public LiftElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.elements = new ArrayList<>();
		this.flag = false;
		this.deltaX = 0;
		this.deltaY = 0;
	}

	@Override
	public void update(){
		super.update();
	}

	public void setVelocity(double deltaX, double deltaY){
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	public void setBounds(double min, double max){
		setMin(min);
		setMax(max);
	}

	public java.util.ArrayList<AbstractElement> getAssociated(){
		return elements;
	}

	public void addAssociated(FollowerElement follower){
		elements.add(follower);
	}

	public void addAssociated(AttachedElement attached){
		attached.setBase(this);
		elements.add(attached);
	}
	public void deleteMarkedAssociated(){
		for(AbstractElement e : this.elements){
			if(e.isMarked()){
				elements.remove(e);
			}
		}
	}

}
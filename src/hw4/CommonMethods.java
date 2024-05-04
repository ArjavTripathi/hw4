package hw4;

import api.AbstractElement;

import java.awt.*;


import api.AbstractElement;

import java.awt.*;

/**
 * Abstract class CommonMethods defines the common properties and behaviors
 * for elements in the game
 Star * @author Arjava Tripathi
 */

public abstract class CommonMethods extends AbstractElement {
    private double x;          // x-coordinate of the element
    private double y;          // y-coordinate of the element
    private int width;         // width of the element
    private int height;        // height of the element
    private int fps;           // frame counter to track updates
    private boolean isDeleted; // flag to mark the element for deletion
    private double max;        // maximum boundary for movement or size
    private double min;        // minimum boundary for movement or size
    private double deltaX;     // change in x-coordinate per update
    private double deltaY;     // change in y-coordinate per update

    /**
     * Constructs a new element with specified location, size, and movement boundaries.
     *
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     * @param width width of the element
     * @param height height of the element
     * @param max maximum boundary value
     * @param min minimum boundary value
     */
    public CommonMethods(double x, double y, int width, int height, double max, double min){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fps = 0;
        this.isDeleted = false;
        this.max = max;
        this.min = min;
        this.deltaX = 0;
        this.deltaY = 0;
    }

    /**
     * Constructs a new element with specified location and size, without explicit boundaries.
     *
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     * @param width width of the element
     * @param height height of the element
     */
    public CommonMethods(double x, double y, int width, int height){
        this(x, y, width, height, 0, 0);
    }

    /**
     * Sets the position of this element to the specified coordinates.
     *
     * @param newX new x-coordinate
     * @param newY new y-coordinate
     */
    @Override
    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Returns the real x-coordinate of this element.
     * @return the x-coordinate
     */
    @Override
    public double getXReal() {
        return x;
    }

    /**
     * Returns the real y-coordinate of this element.
     * @return the y-coordinate
     */
    @Override
    public double getYReal() {
        return y;
    }

    /**
     * Determines if this element is marked for deletion.
     * @return true if marked for deletion, false otherwise
     */
    @Override
    public boolean isMarked() {
        return isDeleted;
    }

    /**
     * Marks this element for deletion.
     */
    @Override
    public void markForDeletion() {
        isDeleted = true;
    }

    /**
     * Determines if this element collides with another element.
     * @param other the other element to check for collision
     * @return true if this element collides with the other element, false otherwise
     */
    @Override
    public boolean collides(AbstractElement other) {
        Rectangle rect = other.getRect();
        Rectangle curr = getRect();
        return curr.intersects(rect);
    }

    /**
     * Returns the x-coordinate rounded to the nearest integer.
     * @return rounded x-coordinate as integer
     */
    @Override
    public int getXInt() { return (int) Math.round(x); }

    /**
     * Returns the y-coordinate rounded to the nearest integer.
     * @return rounded y-coordinate as integer
     */
    @Override
    public int getYInt() {
        return (int) Math.round(y);
    }

    /**
     * Returns the width of this element.
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this element.
     * @return the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Gets the bounding rectangle of this element.
     * @return a rectangle representing this element's bounds
     */
    @Override
    public Rectangle getRect() {
        return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
    }

    /**
     * Returns the frame count, which tracks the number of updates made to this element.
     * @return the frame count
     */
    @Override
    public int getFrameCount() {
        return fps;
    }

    /**
     * Updates the frame count of this element.
     */
    @Override
    public void update() {
        fps++;
    }

    /**
     * Returns the minimum boundary for movement or size.
     * @return the minimum boundary value
     */
    public double getMin() {
        return min;
    }

    /**
     * Returns the maximum boundary for movement or size.
     * @return the maximum boundary value
     */
    public double getMax() {
        return max;
    }

    /**
     * Sets the maximum boundary for movement or size.
     * @param max the maximum boundary value to set
     */
    protected void setMax(double max) {
        this.max = max;
    }

    /**
     * Sets the minimum boundary for movement or size.
     * @param min the minimum boundary value to set
     */
    protected void setMin(double min) {
        this.min = min;
    }

    /**
     * Sets both the minimum and maximum boundaries for movement or size.
     * @param min the minimum boundary value to set
     * @param max the maximum boundary value to set
     */
    public void setBounds(double min, double max) {
        setMin(min);
        setMax(max);
    }

    /**
     * Sets the velocity of this element.
     * @param dx the change per update in the x-direction
     * @param dy the change per update in the y-direction
     */
    public void setVelocity(double dx, double dy) {
        deltaX = dx;
        deltaY = dy;
    }

    /**
     * Returns the change in x-coordinate per update.
     * @return the change per update in the x-direction
     */
    public double getDeltaX() {
        return deltaX;
    }

    /**
     * Returns the change in y-coordinate per update.
     * @return the change per update in the y-direction
     */
    public double getDeltaY() {
        return deltaY;
    }
}




package hw4;

import api.AbstractElement;

import java.awt.*;

public abstract class CommonMethods extends AbstractElement {
    private double x;
    private double y;
    private int width;
    private int height;
    private int fps;
    private boolean isDeleted;
    private double max;
    private double min;
    private double deltaX;
    private double deltaY;

    public CommonMethods(double x, double y, int width, int height, double max, double min){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fps = 0;
        this.isDeleted= false;
        this.max = max;
        this.min = min;
        this.deltaX = 0;
        this.deltaY = 0;
    }

    public CommonMethods(double x, double y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fps = 0;
        this.isDeleted= false;
        this.max = 0;
        this.min = 0;
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
    public boolean isMarked() {
        return isDeleted;
    }

    @Override
    public void markForDeletion() {
        isDeleted = true;
    }

    @Override
    public boolean collides(AbstractElement other) {
        Rectangle rect = other.getRect();
        Rectangle curr = getRect();
        return curr.intersects(rect);
    }

    @Override
    public int getXInt() { return (int) Math.round(x);}

    @Override
    public int getYInt() {
        return (int) Math.round(y);
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
    @Override
    public int getFrameCount() {
        return fps;
    }

    @Override
    public void update(){
        fps++;
    }

    public double getMin(){
        return min;
    }

    public double getMax(){
        return max;
    }

    protected void setMax(double max){
        this.max = max;
    }

    protected void setMin(double min){
        this.min = min;
    }

    public void setBounds(double min, double max){
        setMin(min);
        setMax(max);
    }

    public void setVelocity(double dx, double dy){
        deltaX = dx;
        deltaY = dy;
    }

    public double getDeltaX(){
        return deltaX;
    }

    public double getDeltaY(){
        return deltaY;
    }
}



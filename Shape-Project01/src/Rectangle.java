/*
 * File: Rectangle.java
 * Author: Elvis Ed
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public class Rectangle implements TwoDimensionalShape{

    double width, length;

    public double getArea() {
        return width * length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double numberOfDimentions() {
        return 2;
    }
}

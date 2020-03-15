/*
 * File: Cylinder.java
 * Author: Elvis Ed
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public class Cylinder implements ThreeDimensionalShape {

    double radius, height;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return 3.14 * radius * radius * height;
    }

    public double numberOfDimentions() {
        return 3;
    }
}
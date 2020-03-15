/*
 * File: Sphere.java
 * Author: Elvis Ed
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public class Sphere implements ThreeDimensionalShape {

    double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4/3) * 3.14 * radius*radius*radius;
    }

    @Override
    public double numberOfDimentions() {
        return 3;
    }
}

/*
 * File: Torus.java
 * Author: Elvis Ed
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public class Torus implements ThreeDimensionalShape {

    double majorRadius, minorRadius;

    public double getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }

    public Torus(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double getVolume() {
        return (3.14 * minorRadius * minorRadius) * (2 * 3.14 * majorRadius);
    }

    public double numberOfDimentions() {
        return 3;
    }
}
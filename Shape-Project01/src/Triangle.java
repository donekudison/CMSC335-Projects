/*
 * File: Triangle.java
 * Author: Elvis Edinge
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public class Triangle implements TwoDimensionalShape {
    double height, base;

    public double getArea() {
        return (height * base)/2;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

   public double numberOfDimentions() {
        return 2;
    }
}

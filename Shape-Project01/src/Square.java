/*
 * File: Square.java
 * Author: Elvis Edinge
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public  class Square implements TwoDimensionalShape {
    double side;

    public double getArea() {
        return side * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public double numberOfDimentions() {
        return 2;
    }
}

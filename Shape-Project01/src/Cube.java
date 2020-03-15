/*
 * File: Cube.java
 * Author: Elvis Ed
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
public class Cube  implements ThreeDimensionalShape{

    double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Cube(double area) {
        this.area = area;
    }

    public double getVolume() {
        return area * area * area;
    }

    public double numberOfDimentions() {
        return 3;
    }
}

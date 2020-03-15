/*
 * File: ShapeTheme.java
 * Author: Elvis Edinge
 * Date: 01/25/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */
import java.util.Scanner;
import java.util.Date;  
import java.text.DateFormat;

public class ShapeTheme {


@SuppressWarnings("resource")
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date today = new Date();
        String dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG ,DateFormat.SHORT).format(today);  
        char choice;

        System.out.println("*********Welcome to the Java OO Shapes Program **********");

        do {
            System.out.println("Select from the menu below: ");
            System.out.println("1. Construct a Circle ");
            System.out.println("2. Construct a Rectangle ");
            System.out.println("3. Construct a Square ");
            System.out.println("4. Construct a Triangle ");
            System.out.println("5. Construct a Sphere ");
            System.out.println("6. Construct a Cube ");
            System.out.println("7. Construct a Cone ");
            System.out.println("8. Construct a Cylinder ");
            System.out.println("9. Construct a Torus ");
            System.out.println("10. Exit the program ");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    System.out.println("You have selected a Circle");
                    System.out.println("Enter Radius");
                    double circleRadius = sc.nextDouble();
                    Circle circle = new Circle(circleRadius);
                    System.out.println("The area of the Circle is " + Math.round(circle.getArea()*10.0)/10.0);
                    break;

                case 2:
                    System.out.println("You have selected a Rectangle");

                    System.out.println("Enter Length");
                    double rectLength = sc.nextDouble();
                    System.out.println("Enter Width");
                    double rectWidth = sc.nextDouble();
                    Rectangle rectangle = new Rectangle(rectWidth, rectLength);
                    System.out.println("The area of the Rectangle is " + Math.round(rectangle.getArea()*10.0)/10.0);
                    break;

                case 3:
                    System.out.println("You have selected a Square");
                    System.out.println("Enter Side");
                    double squareSide = sc.nextDouble();
                    Square square = new Square(squareSide);
                    System.out.println("The area of the Square is " + Math.round(square.getArea()*10.0)/10.0);
                    break;

                case 4:
                    System.out.println("You have selected a Triangle");
                    System.out.println("Enter Height");
                    double triangleHeight = sc.nextDouble();
                    System.out.println("Enter Base");
                    double triangleBase = sc.nextDouble();
                    Triangle triangle = new Triangle(triangleHeight, triangleBase);
                    System.out.println("The area of the Triangle is " + Math.round(triangle.getArea()*10.0)/10.0);
                    break;
                case 5:
                    System.out.println("You have selected a Sphere");
                    System.out.println("Enter Radius");
                    double sphereRadius = sc.nextDouble();
                    Sphere sphere = new Sphere(sphereRadius);
                    System.out.println("The Volume of the Sphere is " + Math.round(sphere.getVolume()*10.0)/10.0);
                    break;

                case 6:
                    System.out.println("You have selected a Cube");
                    System.out.println("Enter area");
                    double cubeArea = sc.nextDouble();
                    Cube cube = new Cube(cubeArea);
                    System.out.println("The Volume of the Cube is " + Math.round(cube.getVolume()*10.0)/10.0);
                    break;

                case 7:
                    System.out.println("You have selected a Cone");
                    System.out.println("Enter Radius");
                   double coneRadius = sc.nextDouble();
                    System.out.println("Enter Height");
                    double coneHeight = sc.nextDouble();
                    Cone cone = new Cone(coneRadius, coneHeight);
                    System.out.println("The Volume of the Cone is " + Math.round( cone.getVolume()*10.0)/10.0);
                    break;

                case 8:
                    System.out.println("You have selected a Cylinder");
                    System.out.println("Enter Radius");
                    double cylinderRadius = sc.nextDouble();
                    System.out.println("Enter Height");
                    double cylinderHeight = sc.nextDouble();
                    Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
                    System.out.println("The Volume of the Cylinder is " + Math.round(cylinder.getVolume()*10.0)/10.0);
                    break;

                case 9:
                    System.out.println("You have selected a Torus");
                    System.out.println("Enter MinorRadius");
                    double minorRadius = sc.nextDouble();
                    System.out.println("Enter MajorRadius");
                    double majorRadius = sc.nextDouble();
                    Torus torus = new Torus(majorRadius, minorRadius);
                    System.out.println("The Volume of the Torus is " + Math.round(torus.getVolume()*10.0)/10.0);
                    break;
                    
                case 10:
       
                	 System.out.println("Thanks for using the program. Today is " + dateToStr);
                	return;
            }

            System.out.println("Would you like to continue? (Y or N)");
            choice = sc.next().charAt(0);
        }while (choice == 'Y');
        System.out.println("Thanks for using the program. Today is " + dateToStr);
        
    }
}

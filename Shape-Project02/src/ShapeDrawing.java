
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * File: Circle.java
 * Author: Elvis Edinge
 * Date: 2/8/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */


public class ShapeDrawing extends JPanel {

	//Serial constant given the JPanel
	 
	private static final long serialVersionUID = 1L;

	//Attributes of the class. 
	private String shape;
	private double[] dimensions;

	//Constructor of the Panel. Receives both shape and dimension's array
	public ShapeDrawing(String shape, double[] dim) {
		this.shape = shape;
		dimensions = dim;
	}

	//Method that paints the respective shape on the Panel
	@Override
	public void paintComponent(Graphics g) {
		try {
			
			if(shape.equals("Circle")) {
				//To draw a Circle, we use drawOval() with same radius for both axes
				double radius = dimensions[0];
				g.drawOval(0,0,(int)radius,(int)radius);
			}
			else if(shape.equals("Square")) {
				//To draw a Square, we use drawRect() with length and width
				double length = dimensions[0];
				g.drawRect(0,0,(int)length,(int)length);
			}
			else if(shape.equals("Triangle")) {
				//To draw a Triangle, we use drawPolygon() 
				double height = dimensions[0];
				double base = dimensions[1];
				//The x and y coordinates of the points are given by the next values
				int[] x = {0,(int)base,(int)(base/2)};
				int[] y = {150,150,150-(int)height};
				g.drawPolygon(x,y,3);
			}
			else if(shape.equals("Rectangle")) {
				//To draw a Rectangle, we use drawRect() with length and width
				double length = dimensions[0];
				double width = dimensions[1];
				g.drawRect(0,0,(int)width,(int)length);
			}
			else {
				//For the next shapes, 3D-shapes, we need to show images to represent them.
				//To do this, we can create Image objects and paint them using drawImage().
				Image image = null;
				if (shape.equals("Sphere")) {
					//To find the right image given for Sphere dimensions
					double radius = dimensions[0];
					// Using radius to fine image
					if(radius < 50) {
						image = ImageIO.read(new File("sphere100.jpg"));
					} else if(radius < 100) {
						image = ImageIO.read(new File("sphere150.jpg"));
					} else {
						image = ImageIO.read(new File("sphere500.jpg"));
					}
				}
				else if(shape.equals("Cube")) {
					// To find the right image given for Cube dimensions
					double edge = dimensions[0];
					// Using radius to fine image
					if(edge < 50) {
						image = ImageIO.read(new File("cube50.jpg"));
					} else if(edge < 100) {
						image = ImageIO.read(new File("cube100.jpg"));
					} else {
						image = ImageIO.read(new File("cube220.jpg"));
					}
				}
				else if(shape.equals("Cone")) {
					// To find the right image given for Cone dimensions
					double radius = dimensions[0];
					//Using radius to fine image
					if(radius < 50) {
						image = ImageIO.read(new File("cone50.jpg"));
					} else if(radius < 100) {
						image = ImageIO.read(new File("cone100.jpg"));
					} else {
						image = ImageIO.read(new File("cone150.jpg"));
					}
				}
				else if(shape.equals("Cylinder")) {
					//To find the right image given for Cylinder dimensions
					double radius = dimensions[0];
					//  Using radius to fine image
					if(radius < 50) {
						image = ImageIO.read(new File("cylinder50.jpg"));
					} else if(radius < 100) {
						image = ImageIO.read(new File("cylinder100.jpg"));
					} else {
						image = ImageIO.read(new File("cylinder150.jpg"));
					}
				}
				else {
					// To find the right image given for Torus dimensions 
					double minor_Radius = dimensions[0];
					//Here, in order to choose the image to use, we consider the radius
					if(minor_Radius < 50) {
						image = ImageIO.read(new File("torus100.jpg"));
					} else if(minor_Radius < 100) {
						image = ImageIO.read(new File("torus150.jpg"));
					} else {
						image = ImageIO.read(new File("torus200.jpg"));
					}
				}
				//Finally, once the image was selected correctly, we draw it
				g.drawImage(image,0,0,null);
			}
		} catch (Exception e) {
			//An Exception is thrown in case the images are not found. 
			JOptionPane.showMessageDialog(this, "The image for the selected shape wasn't found!","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
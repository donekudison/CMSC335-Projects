

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * File: Circle.java
 * Author: Elvis Edinge
 * Date: 2/8/2020
 * Description:  This shape program allows a user to construct either a TwoDimensional or ThreeDimensional Shape subclasses.
 */


public class ShapesGUI extends JFrame implements ActionListener {

	// Serial constant given the JFrame 
	private static final long serialVersionUID = 1L;


	//Attributes of the class.
	private JButton[] shapes;
	JPanel drawing;

	//Constructor of the main Frame
	public ShapesGUI() {

		//First, we can set the initial settings of the frame
		setTitle("Shape Theme Simulation Program");
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Initialize buttons,and helper panel 
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(9, 1));
		String[] strShapes = {"Circle","Square","Triangle","Rectangle","Sphere","Cube","Cone","Cylinder","Torus"};
		shapes = new JButton[strShapes.length];
		for(int i = 0; i < shapes.length; i++) {
			//adding Initialized button to the panel
			shapes[i] = new JButton(strShapes[i]);
			shapes[i].addActionListener(this); //This class is the one that listens (handles) the button
			btnPanel.add(shapes[i]);
		}
		add(btnPanel,BorderLayout.CENTER); //Adds the panel with buttons in the CENTER of main frame
	}

	//Method that handles the buttons to choose a shape and draw it
	public void actionPerformed(ActionEvent ae) {
		//First, the action command is the name of the button clicked.
		String clicked = ae.getActionCommand();
		if(clicked.equals("Circle")) {
			
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the radius: ");
				if(strRad == null) {
					break;
				}
				try {
					double radius = Double.parseDouble(strRad);
					//If no exceptions here, itcan create the panel for Circle and add it
					drawing = new ShapeDrawing(clicked, new double[]{radius});
					drawing.setPreferredSize(new Dimension((int)radius+100,(int)radius+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid, so it ask again
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Square")) {
	
			// The Square to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the side: ");
				if(strRad == null) {
					break;
				}
				try {
					double side = Double.parseDouble(strRad);
					//If no exceptions here, it can create the panel for square and add it
					drawing = new ShapeDrawing(clicked, new double[]{side});
					drawing.setPreferredSize(new Dimension((int)side+100,(int)side+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid, so it ask again
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Triangle")) {
			// To find right dimensions for the Triangle to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the base: ");
				String strRad1 = JOptionPane.showInputDialog("Enter the height: ");
				if(strRad == null) {
					break;
				}
				try {
					double base = Double.parseDouble(strRad);
					double height = Double.parseDouble(strRad1);
					//If no exceptions here, we can create the panel for Triangle and add it
					drawing = new ShapeDrawing(clicked, new double[]{base,height});
					drawing.setPreferredSize(new Dimension((int)base+100,(int)height+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid, so it ask again
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Rectangle")) {
			// To find right dimensions for the Rectangle to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the width: ");
				String strRad1 = JOptionPane.showInputDialog("Enter the length: ");
				if(strRad == null) {
					break;
				}
				try {
					double width = Double.parseDouble(strRad);
					double length = Double.parseDouble(strRad1);
					//If no exceptions here, we can create the panel for Rectangle and add it
					drawing = new ShapeDrawing(clicked, new double[]{width, length});
					drawing.setPreferredSize(new Dimension((int)width+100,(int)length+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid, so we ask again
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Sphere")) {
			// To find right dimensions for the Sphere to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the radius: ");
				if(strRad == null) {
					break;
				}
				try {
					double radius = Double.parseDouble(strRad);
					//If no exceptions here, we can create the panel for Sphere and add it
					drawing = new ShapeDrawing(clicked, new double[]{radius});
					drawing.setPreferredSize(new Dimension((int)radius+100,(int)radius+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid.
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Cube")) {
			//To find right dimensions for the Cube to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the edge: ");
				if(strRad == null) {
					break;
				}
				try {
					double edge = Double.parseDouble(strRad);
					//If no exceptions here, we can create the panel for Cube and add it
					drawing = new ShapeDrawing(clicked, new double[]{edge});
					drawing.setPreferredSize(new Dimension((int)edge+100,(int)edge+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid, so we ask again
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Cone")) {
			// To find right dimensions for the Cone to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the radius: ");
				String strRad1 = JOptionPane.showInputDialog("Enter the height: ");
				if(strRad == null) {
					break;
				}
				try {
					double radius = Double.parseDouble(strRad);
					double height = Double.parseDouble(strRad1);
					//If no exceptions here, we can create the panel for Cone and add it
					drawing = new ShapeDrawing(clicked, new double[]{radius, height});
					drawing.setPreferredSize(new Dimension((int)radius+100,(int)height+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid, so we ask again
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else if(clicked.equals("Cylinder")) {
			// To find right dimensions for the Cylinder to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the radius: ");
				String strRad1 = JOptionPane.showInputDialog("Enter the height: ");
				if(strRad == null) {
					break;
				}
				try {
					double radius = Double.parseDouble(strRad);
					double height = Double.parseDouble(strRad1);
					//If no exceptions here, we can create the panel for Cylinder and add it
					drawing = new ShapeDrawing(clicked, new double[]{radius, height});
					drawing.setPreferredSize(new Dimension((int)radius+100,(int)height+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid. 
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
		else {
			// To find right dimensions for the Torus to draw
			while(true) {
				String strRad = JOptionPane.showInputDialog("Enter the minor_Radius: ");
				String strRad1 = JOptionPane.showInputDialog("Enter the major_Radius: ");
				if(strRad == null) {
					break;
				}
				try {
					double minor_Radius = Double.parseDouble(strRad);
					double major_Radius = Double.parseDouble(strRad1);
					//If no exceptions here, we can create the panel for Torus and add it
					drawing = new ShapeDrawing(clicked, new double[]{minor_Radius,major_Radius});
					drawing.setPreferredSize(new Dimension((int)minor_Radius+100,(int)major_Radius+100));
					JOptionPane.showMessageDialog(this, drawing);
					break;
				} catch (Exception e) {
					//If any Exception, it means the input was not valid.
					JOptionPane.showMessageDialog(this, "Not valid input");
				}
			}
		}
	}
	
	//Main method that runs the ShapeGUI
	public static void main(String[] args) {
		ShapesGUI gui = new ShapesGUI();
		gui.setVisible(true);
	}
}

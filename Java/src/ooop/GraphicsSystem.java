package ooop;


import java.awt.AWTException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class GraphicsSystem  extends LBUGraphics{
	public ArrayList<String> list;
	public int size;
	public ArrayList<String> commandList=new ArrayList<String>();
	public ArrayList<String> arr=new ArrayList<String>(
			Arrays.asList("clock","shape","equilateral","penwidth","name","image","save","load","screenshot","triangle","square","pencolor","about","penup","pendown","turnleft","turnright","forward","backward","green","red","white","black","reset","clear"));
	

	public GraphicsSystem()
	{
		JFrame MainFrame = new JFrame();            //create a frame to display the turtle panel on
		MainFrame.setLayout(new FlowLayout());     //not strictly necessary
		MainFrame.add(this);                       //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
		MainFrame.setSize(850,450);                //set the frame to a size we can see
		MainFrame.setVisible(true);   
		//about();//now display it

		//call the LBUGraphics about method to display version information.
	}

	public void saveCommands(ArrayList<String>   commandList) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Command File");
		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				Files.write(fileToSave.toPath(), commandList);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "File could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
			}}
	}

	public void loadCommands() {		//this command loads the command 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load Command File");
		int userSelection = fileChooser.showOpenDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				Scanner scan = new Scanner(selectedFile);
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					processCommand(line);
				}
				scan.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File could not be loaded", "File load error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	public void saveImage() {		//this method saves the image with an picture.png file name inthe given location
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Image");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getAbsolutePath() + "/picture.jpg";
			try {
				Thread.sleep(120);
				Robot r = new Robot();
				Rectangle capture = new Rectangle(0, 0, 900, 900);
				BufferedImage Image = r.createScreenCapture(capture);
				ImageIO.write(Image, "png", new File(path));
				System.out.println("Screenshot saved");
			} catch (AWTException e) {
				System.err.println("Could not create Robot instance: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("Could not write image to file: " + e.getMessage());
			} catch (InterruptedException e) {
				System.err.println("Thread interrupted while sleeping: " + e.getMessage());
			}
		}
	}

	public void loadImage() throws IOException {		//this method loads the image
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open Image");
		int userSelection = fileChooser.showOpenDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			BufferedImage myPicture = ImageIO.read(selectedFile);
			this.setBufferedImage(myPicture);
		}
	}
	//          @override
	public void about() {		//this method is a overriden about method
		super.about();
		getGraphicsContext().drawString("Manoj Panta",200,100);


	}

	public void EquilateralTriangle(int side) {		//this method displays the equiletral triangle
		this.penDown();
		this.forward(side);
		this.turnLeft(120);
		this.forward(side);
		this.turnLeft(120);
		this.forward(side);
		this.turnLeft(120);
	

	}
	public void Triangle(int a,int b ,int c) {
		 double angleA = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2.0 * b * c)));
	     double angleB = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2.0 * a * c)));
	    double angleC = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2.0 * a * b)));
	   
	this.penDown();
	this.forward(a);
	this.turnLeft((int)(180.0- angleC));
	this.forward(b);
	this.turnLeft((int)(180.0-angleA));
	this.forward(c);
	this.turnLeft((int)(180.0-angleB));
	
	
	
	}
	public void myName() {
		//M
		this.setStroke(12);
		this.forward(50);
		this.turnRight(90);    	
		this.forward(250);
		this.turnRight(90);
		this.penDown();
		this.forward(150);
		this.turnRight(150);
		this.forward(70);
		this.turnLeft(120); 
		this.forward(70);
		this.turnRight(150);
		this.forward(150);
		//A
		this.turnLeft(90);
		this.penUp();
		this.forward(40);
		this.turnLeft(80); 
		this.penDown();
		this.setPenColour(Color.green);
		this.forward(150);
		this.turnRight(140);
		this.forward(150);
		this.turnRight(180);
		this.forward(80);
		this.turnLeft(60);
		this.forward(40);
		this.penUp();
		this.turnRight(180);
		this.forward(40);
		this.turnRight(60);
		this.forward(80);
		this.turnLeft(60);
		this.forward(40);
		//N
		this.turnLeft(90);
		this.penDown();
		this.setPenColour(Color.white);
		this.forward(140);
		this.turnRight(150); 
		this.forward(160);
		this.turnLeft(150);
		this.forward(150);
		this.turnRight(90);
		//U 
		this.penUp();
		this.forward(40);
		this.turnRight(90);
		this.penDown();
		this.setPenColour(Color.yellow);
		this.forward(150);
		this.turnLeft(90);
		this.forward(90);
		this.turnLeft(90);
		this.forward(150);
		this.penUp();
		this.turnRight(180);
		this.forward(250);
		this.turnRight(90);
		this.forward(330);
		//I
		this.penDown();
		this.forward(50);
		this.penUp();
		this.turnLeft(180);
		this.forward(25);
		this.turnRight(90);
		this.penDown();
		this.forward(60);
		this.turnRight(90);

		this.penUp();
		this.forward(20);
		
		this.turnRight(180);
		this.penDown();
		this.forward(50);
		this.penUp();
		this.forward(40);
		//L
		this.turnLeft(90);
		this.forward(60);
		this.turnRight(180);
		this.penDown();
		this.setPenColour(Color.red);
		this.forward(60);
		this.turnLeft(90);
		this.forward(40);
		//O
		this.penUp();
		this.forward(20);
		this.turnLeft(90);
		this.forward(30);
		this.penDown();
		this.circle(30);
		//V
		this.penUp();
		this.turnRight(90);
		this.forward(60);
		this.turnRight(90);
		this.turnLeft(180);
		this.turnLeft(40);
		this.forward(40);
		this.turnRight(180);
		this.penDown();
		this.forward(70);
		this.turnLeft(120);
		this.forward(70);
		//E
		this.turnRight(70);
		this.penUp();
		this.forward(30);
		this.penDown();
		this.forward(50);
		this.turnRight(180);
		this.penUp();

		this.forward(50);
		this.turnLeft(90);
		this.penDown();
		this.forward(60);
		this.turnLeft(90);
		this.forward(50);
		this.penDown();
		this.turnRight(180);
		this.forward(50);
		this.turnRight(90);
		this.forward(30);
		this.turnRight(90);
		this.forward(50);
		this.penUp();
		this.forward(70);
		//U
		this.setPenColour(Color.green);
		this.turnLeft(90);

		this.forward(30);
		this.turnRight(180);
		this.penDown();
		this.forward(60);
		this.turnLeft(90);
		this.forward(70);
		this.turnLeft(90);
		this.forward(60);
		this.penUp();
		this.forward(90);
}
	public void square(int side) {
		this.penDown();
		this.forward(side);
		this.turnLeft(90);
		this.forward(side);
		this.turnLeft(90);
		this.forward(side);
		this.turnLeft(90);
		
		this.forward(side);
		this.turnLeft(90);



	}
 public  void newShape() {
	 
	 this.square(100);
	 setPenColour(Color.RED);
	 this.EquilateralTriangle(100);
	 this.turnLeft();
	 this.turnRight(180);
	 setPenColour(Color.GREEN);
	 this.square(100);
	 setPenColour(Color.YELLOW);
	 this.EquilateralTriangle(100);
	 this.turnRight();
	 setPenColour(Color.WHITE);
	 this.square(100);
	 setPenColour(Color.BLUE);
	 this.EquilateralTriangle(100);
	 this.turnRight();
	 setPenColour(Color.CYAN);
	 this.square(100);
	 setPenColour(Color.YELLOW);
	 this.EquilateralTriangle(100);
	 setPenColour(Color.CYAN);
	 this.penwidth(7);
	 this.circle(150);
	 
	

}
 public void clock() {
	 this.penDown();
	 this.circle(150);
	 this.penwidth(5);
	 this.circle(5);
	 this.turnLeft(180);
	 this.penUp();
	 this.forward(160);
	 this.turnLeft(180);
	 this.penDown();
	 this.penwidth(3);
	 this.forward(20);
	 this.penUp();
	 this.forward(120);
	 this.turnLeft(90);
	 this.forward(160);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(90);
	 this.forward(170);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(90);
	 this.forward(150);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(60);
	 this.forward(150);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(150);	
	 this.turnLeft(160);
	 this.forward(165);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(120);
	 this.forward(165);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(140);
	 this.forward(160);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(110);
	 this.forward(160);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
	 this.turnLeft(150);
	 this.forward(160);
	 this.turnLeft(180);
	 this.penDown();
	 this.forward(20);
	 this.penUp();
	 this.forward(140);
     this.turnLeft(120);
this.penUp();
this.forward(150);
this.turnLeft(180);
this.penDown();
this.forward(20);
this.penUp();
this.forward(140);
this.turnLeft(160);
this.penUp();
this.forward(160);
this.turnLeft(180);
this.penDown();
this.forward(20);
this.penUp();
this.forward(140);
this.turnLeft(120);
this.penwidth(9);
this.penDown();
this.forward(70);
this.penUp();
this.turnRight(50);
this.forward(100);
this.turnRight(160);
this.forward(160);
this.turnLeft(60);
this.penDown();
this.forward(120);
this.penUp();
this.turnLeft(100);
this.forward(200);

 }
	
		
	
	public void	penwidth(int width) {
     this.setStroke(width);
	}

	
	public void pencolour(int red,int green,int blue) {		//this method gives the rgb color to the pen
		this.setPenColour(new Color(red,green,blue));
	}
	

	public void processCommand(String command)   
	//this method must be provided because LBUGraphics will call it when it's JTextField is used
	{


		list=new ArrayList<String>();
		String parts[]=command.split(" ");

		for (int i=0;i<parts.length;i++) 
		{
			list.add(parts[i]);
		}
		size=list.size();
		evaluate(command);
	}

	public void evaluate(String val) {		//this method evaluates the given command to run the command

		try {

			if(arr.contains(list.get(0)))
			{

				switch(list.get(0)) 
				{
				case "forward":
					if(size==1) {
						forward(90);
						commandList.add(val);
						break;	


					}
					else 
					{

						if(Integer.parseInt(list.get(1))>0) {
							forward(Integer.parseInt(list.get(1)));

							System.out.println("Turtle moved "+list.get(1) +" forward !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);


						}

						break;}

				case "turnright":
					if(size==1) {
						turnRight(90);
						commandList.add(val);
					}



					else
					{
						if(Integer.parseInt(list.get(1))>0) {
							turnRight(Integer.parseInt(list.get(1)));
							System.out.println("Turtle turned "+list.get(1)+" right !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);
						}
					}


					break;

				case "turnleft":
					if(size==1) 
					{
						turnLeft(90);	
						commandList.add(val);

					}
					else 
					{
						if(Integer.parseInt(list.get(1))>0) 
						{
							turnLeft(Integer.parseInt(list.get(1)));
							System.out.println("Turtle turned "+list.get(1)+" left !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);
						}
					}
					break;

				case "backward":
					if(size==1) 
					{
						forward(-90);
						commandList.add(val);

					}
					else 
					{
						if(Integer.parseInt(list.get(1))>0) {
							forward(-Integer.parseInt(list.get(1)));
							System.out.println("Turtle moved "+list.get(1)+" backward !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);

						}

					}
					break;

				case "penup":
					penUp();
					commandList.add(val);
					System.out.println("Pen is up now!!....");
					break;

				case "pendown":
					penDown();
					commandList.add(val);
					System.out.println("Pen is down now!!....");
					break;

				case "black":
					setPenColour(Color.black);
					commandList.add(val);
					System.out.println("Turtle trail is now set to black!....");
					break;

				case "green":
					setPenColour(Color.green);
					commandList.add(val);
					System.out.println("Turtle trail is now set to green!....");
					break;

				case "red":
					setPenColour(Color.red);
					commandList.add(val);
					System.out.println("Turtle trail is now set to red!....");
					break;

				case "white":
					setPenColour(Color.white);
					commandList.add(val);
					System.out.println("Turtle trail is now set to white!....");
					break;
				case "clear":
					clear();
					System.out.println("Trails has been cleared!....");
					commandList.add(val);
					break;
				case "reset":
					reset();
					System.out.println("Turtle in orginal position");
					break;
				case "about":
					about();
					commandList.add(val);
					break;
				case "equilateral":
					if(size==1) {
						JOptionPane.showMessageDialog(null, "Please entered  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0) {
						EquilateralTriangle(Integer.parseInt(list.get(1)));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	
					break;

				case "pencolor":
					if(size==1 || list.size()==2 || list.size()==3) {
						JOptionPane.showMessageDialog(null, "Please entered  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if(Integer.parseInt(list.get(1))>0) {
						pencolour(Integer.parseInt(list.get(1)),Integer.parseInt(list.get(2)),Integer.parseInt(list.get(3)));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	
					break;

				case "square":
					if(size==1) {
						JOptionPane.showMessageDialog(null, "Please enter  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0) {
						square(Integer.parseInt(list.get(1)));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	

					break;
				case "penwidth":
					if(size==1) {
						JOptionPane.showMessageDialog(null, "Please enter  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0) {
						setStroke(Integer.parseInt(list.get(1)));
						System.out.println("Turtle penwidth incresed by "+list.get(1));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	

					break;
					
				case "triangle":
					if(size==1 || list.size()==3||list.size()==2) {
						JOptionPane.showMessageDialog(null, "Please entered  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0){
						int SideA=Integer.parseInt(list.get(1));
						int SideB=Integer.parseInt(list.get(2));
						int SideC=Integer.parseInt(list.get(3));
						Triangle(SideA,SideB,SideC);
					}
					
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	
					break;

				case "save":
					saveCommands(commandList);
					
					JOptionPane.showMessageDialog(null, "Command saved successfully","Image saved",JOptionPane.PLAIN_MESSAGE);
					break;

				case "load":
					
					
					loadCommands();
					JOptionPane.showMessageDialog(null, "Command saved successfully","Image saved",JOptionPane.PLAIN_MESSAGE);
					commandList.add(val);
					

					break;
				case "screenshot":
				
					saveImage();
					commandList.add(val);
					

					break;
				case "image":
					try
					{
						loadImage();
						commandList.add(val);
						
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				

					break;
				case "name":
					
					myName();
					commandList.add(val);
				break;
				case "shape":
					newShape();
				commandList.add(val);
				break;
				case "clock":
					clock();
				commandList.add(val);
				break;
				}}
			



			else{
				JOptionPane.showMessageDialog(null, "You entered invalid command","Invalid Command try again",JOptionPane.ERROR_MESSAGE);
			}
		}







		catch(NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "You entered string value in parameter","parameter error",JOptionPane.ERROR_MESSAGE);

		}
	}





public static void main(String[] args) {
	new GraphicsSystem();
}}



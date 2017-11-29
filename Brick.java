//Colleen Stock 

/*
 * This class sets up the bricks for pong
 */

import java.awt.*;
import javax.swing.JPanel;


public class Brick extends JPanel
{
	int x;
	int y;
	int width;
	int height;
	Color color; 
	boolean collide;
	
	//constructor
	public Brick()
	{
		x = 50;
		y = 50;
		width = 100;
		height = 50;
		color = new Color (0, 0, 0);
		collide = false;
	}
	
	//overloaded constructor
	public Brick (int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	
	//mutator methods
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	
	//sets a color for each of the bricks
	public void setColor()
	{
		color = new Color( (int) (256 * Math.random() ), (int) (256 * Math.random() ),(int) (256 * Math.random() ));
	}
	
	//changes the color of the brick to white
	public void disappear()
	{
		color = new Color(255, 255, 255);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setCollision(boolean b)
	{
		collide = b;
	}
	
	public boolean getCollision ()
	{
		return collide;
	}
}

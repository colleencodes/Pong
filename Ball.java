//Colleen Stock

import java.awt.*;

/*
 * This class creates the ball for the pong game
 */

public class Ball 
{
	int x;
	int y;
	int dx; 
	int dy;
	int radius;
	
	//constructor
	public Ball(int i)
	{	
		if (i % 2 == 0)
		{
			x = (int) (Math.random() * 100 + 10);
			y = (int) (Math.random() * 100 + 10);
		}
		
		else if (i % 2 != 0)
		{
			x = (int) (Math.random() * 250 + 50);
			y = (int) (Math.random() * 250 + 50);
		}
		
		dx = (int) (Math.random() * 11 + 2);
		dy = (int) (Math.random() * 11 + 2);
		radius = 10;
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
	
	public void setDX(int dx)
	{
		this.dx = dx;
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public void setY(int y)
	{
		this.y = y; 
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setDY(int dy)
	{
		this.dy = dy;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public void setRadius(int r)
	{
		radius = r; 
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	//draws the ball
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		

		g.drawOval(x, y, 2 * radius, 2 * radius);
		g.fillOval(x, y, 2 * radius, 2 * radius);
	}
	
	//allows for the ball to move
	public void move()
	{
		x = x + dx;
		y = y + dy;
	}

}

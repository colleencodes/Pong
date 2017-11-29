//Colleen Stock

/*
 * This class sets up the paddles for pong
 */

public class Paddle
{
	int x;
	int y;
	int height;
	int width;
	
	//constructor
	public Paddle()
	{
		x = 0;
		y = 0;
		height = 0;
		width = 0;
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
}

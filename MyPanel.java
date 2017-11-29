//Colleen Stock 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MyPanel extends JPanel{
	
   private Ball [] ball = new Ball[(int)(Math.random() * 5 + 1)];
 
   private Paddle paddleL = new Paddle();
   private Paddle paddleR = new Paddle();
   private Paddle paddleT = new Paddle();
   private Paddle paddleB = new Paddle();
   private Color colorPaddleL, colorPaddleR, colorPaddleT, colorPaddleB;
   
   private Brick [] brick = new Brick [(int)(Math.random() * 5 + 4)];

   private Color colorBackground;
   private int time;
   private int score;
   private int delay = 60;

   private JLabel timeLabel = new JLabel();
   private JLabel scoreLabel = new JLabel();
   private JLabel speedLabel = new JLabel();

   private Timer timer = new Timer(delay, new TimerListener( ));


   //--------------------------------------
   //A constructor
   //--------------------------------------
   public MyPanel(){

      //create an object so that mouse movements are processed (it listens for mouse events)
      PaddleMotion movePaddle = new PaddleMotion();
      MouseRelatedStuff miceActivities = new MouseRelatedStuff();
      addMouseMotionListener(movePaddle); 
      addMouseListener(miceActivities);

      //add a labels to the panel
      add(timeLabel);
      add(scoreLabel);
      add(speedLabel);

      //set the size of the panel
      setPreferredSize(new Dimension(700, 450));
      time = 0;
      score = 0;
      
      //specify the original position of the paddles
      paddleR.setX(690);
      paddleR.setY(0);
      
      paddleL.setX(0);
      paddleL.setY(0);
      
      paddleB.setX(0);
      paddleB.setY(440);
      
      paddleT.setX(0);
      paddleT.setY(0);
      
      //creates each of the balls
      for (int i = 0; i < ball.length; i++)
    	  ball[i] = new Ball(i);
      
      //creates each of the bricks 
      for (int i = 0; i < brick.length; i++)
      {
    	  if (i == 0)
    	  {
        	  brick[i] = new Brick(70, 188, 50, 25);
    	  }
    	  else
    		 brick[i] = new Brick(brick[i - 1].getX() + brick[i - 1].getWidth() + 5, 188, 60, 25);
      }
      
      //specifies height and width of the paddles
      paddleL.setHeight((int) (Math.random() * 50 + 10));
      paddleL.setWidth((int) (10));
      
      paddleR.setHeight((int) (Math.random() * 50 + 10));
      paddleR.setWidth((int) (10));
      
      paddleT.setHeight((int) (10));
      paddleT.setWidth((int) (Math.random() * 50 + 10));
      
      paddleB.setHeight((int) (10));
      paddleB.setWidth((int) (Math.random() * 50 + 10));

      //gets color for each of the paddles and background
      colorPaddleB = new Color(150, 100, 0);
      colorPaddleT = new Color(0, 100, 150);
      colorPaddleL = new Color(100, 0, 150);
      colorPaddleR = new Color(150, 0, 100);
      colorBackground = new Color(255, 255, 255);
      
      //sets a random color of each of the bricks
      for (int i = 0; i < brick.length; i++)
      {
    	  brick[i].setColor();
      }
       

      //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      //the next two lines set the color of the background and start the timer
      //don't modify these two lines
      //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
      setBackground(colorBackground);  
      timer.start( ); 

   }//MyPanel constructor

   //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
   //paintComponent is called every time MyPanel object needs to be drawn
   //essentially, this will occur every time the clock ticks
   //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
   public void paintComponent(Graphics page){
	   
      super.paintComponent(page);

      //displays the bricks
      for (int i = 0; i < brick.length; i++)
      {
    	  if (brick[i] == null)
    	  {
    		  
    	  }
    	  else
    	  {
    		  page.setColor(brick[i].getColor());
        	  page.fillRect(brick[i].getX(), brick[i].getY(), brick[i].getWidth(), brick[i].getHeight());
    	  }
      }
      
      //puts the balls on the panel
      for (int i = 0; i < ball.length; i++)
      {
    	  ball[i].draw(page);
      }
    
      //draw the 4 paddles (X, Y) are the locations of the upper left corner of the paddle
      page.setColor(colorPaddleL);
      page.fillRect(paddleL.getX(), paddleL.getY(), paddleL.getWidth(), paddleL.getHeight());
      
      page.setColor(colorPaddleR);
      page.fillRect(paddleR.getX(), paddleR.getY(), paddleR.getWidth(), paddleR.getHeight());

      page.setColor(colorPaddleT);
      page.fillRect(paddleT.getX(), paddleT.getY(), paddleT.getWidth(), paddleT.getHeight());
      
      page.setColor(colorPaddleB);
      page.fillRect(paddleB.getX(), paddleB.getY(), paddleB.getWidth(), paddleB.getHeight());
   }//paintComponent


   //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
   //This specifies what happens every time the clock clicks
   //Don't change anything between the x's
   //
   private class TimerListener implements ActionListener{

      public void actionPerformed(ActionEvent event){

         //increment time and display change your JLabel to reflect it
         time++;
         timeLabel.setText("Elapsed Time = " + ((time * delay) / 1000) + "s");


         //change the position of the ball 
        for (int i = 0; i < ball.length ; i ++)
         {
        	 ball[i].move();
         }
         
         //redraw the scene
         repaint();
         
         //cccccccccccccccccccccccccccccccccccc
         //process the left paddle and wall
         //cccccccccccccccccccccccccccccccccccc

         //change ball if it hits left paddle
         for (int i = 0; i < ball.length; i++)
         {
        	 if (ball[i].getX() <= paddleL.getX() + paddleL.getWidth())
            	 if (ball[i].getY() + ball[i].getRadius() >= paddleL.getY())
            		 if (ball[i].getY() <= paddleL.getY() + paddleL.getHeight())
            			 if (ball[i].getX() - ball[i].getDX() >= paddleL.getX() + paddleL.getWidth())
            				 if (ball[i].getDX() < 0)
            				 {
            					 ball[i].setDX(ball[i].getDX() * -1);
            					 ball[i].setX(paddleL.getX() + paddleL.getWidth() + 1);
            					 score = score + 1;
            					 scoreLabel.setText(" Current Score = " + score);
            				 }
             
             if (ball[i].getX() <= 0)
             {
            	 timer.stop();
            	 scoreLabel.setText(" Game Over . . . Total Score = " + score);
             }
             //ccccccccccccccccccccccccccccccccccc
             //process the bottom paddle and wall
             //cccccccccccccccccccccccccccccccccc

             //bottom paddle
             if (ball[i].getY() + ball[i].getRadius() >= paddleB.getY())
            	 if (ball[i].getX() + ball[i].getRadius() >= paddleB.getX())
            		 if (ball[i].getX() <= paddleB.getX() + paddleB.getWidth())
            			 if (ball[i].getY() + ball[i].getRadius() - ball[i].getDY() <= paddleB.getY())
            				 if (ball[i].getDY() > 0)
            				 {
            					 ball[i].setDY(ball[i].getDY() * -1);
            					 ball[i].setY(paddleB.getY() - ball[i].getRadius());
            					 score = score + 1;
            					 scoreLabel.setText(" Current Score = " + score);
            				 }
             
             if (ball[i].getY() + ball[i].getRadius() >= 700)
             {
            	 timer.stop();
            	 scoreLabel.setText("     Game Over . . . Total Score = " + score);
             }
            
           //top paddle
             if (ball[i].getY() <= 10)
             	if (ball[i].getX() + ball[i].getRadius() >= paddleT.getX())
             		if (ball[i].getX() <= paddleT.getX() + paddleT.getWidth())
             			if (ball[i].getY() - ball[i].getDY() > 10)
             				if (ball[i].getDY() < 0)
             				{
             					ball[i].setDY(ball[i].getDY() * -1);
             					ball[i].setY(11);
             					score = score + 1;
             					scoreLabel.setText(" Current Score = " + score);
             				}
            
            if (ball[i].getY() <= 0)
            {
            	timer.stop();
            	scoreLabel.setText(" Game Over . . . Total Score = " + score);
            }
           
            //right paddle
           if (ball[i].getX() + ball[i].getRadius() >= paddleR.getX())
        	   if (ball[i].getY() + ball[i].getRadius() >= paddleR.getY())
        		   if (ball[i].getY() <= paddleR.getY() + paddleR.getHeight())
        			  if (ball[i].getX() + ball[i].getRadius() - ball[i].getDX() <= paddleR.getX())
        			   if (ball[i].getDX() > 0)
        			   {
        				   ball[i].setX(paddleR.getX() - ball[i].getRadius() - 1);
        				   ball[i].setDX(-ball[i].getDX());
        				   score = score + 1;
        				   scoreLabel.setText(" Current Score = " + score);
        			   }
           
           if (ball[i].getX() + ball[i].getRadius() >= 700)
           {
        	   timer.stop();
        	   scoreLabel.setText(" Game Over . . . Total Score = " + score);
           }
         }
         
         
       
       //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

         //collision detection
         for (int i = 0; i < brick.length; i++)
         {
        	 for (int j = 0; j < ball.length; j++)
        	 {
     			if (brick[i].getCollision() == true)
     			{
     				
     			}
        		
     			else if ((ball[j].getX() + 2 * ball[j].getRadius()) >= brick[i].getX() && ball[j].getX() <= (brick[i].getX() + brick[i].getWidth()) && (ball[j].getY() + 2 * ball[j].getRadius()) >= brick[i].getY() && ball[j].getY() <= (brick[i].getY() + brick[i].getHeight()))
        		{
     				//if the ball hits, changes direction and the brick disappears
        			ball[j].setDX(ball[j].getDX() * -1);
        			ball[j].setDY(ball[j].getDY() * -1);
        			brick[i].disappear();
        			brick[i].setCollision(true);	
        		}
        	 }
         }

        
        
         
      }//actionPerformed
   }//TimerListener


   //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
   //This specifies that the paddle follows the mouse
   //
   private class PaddleMotion implements MouseMotionListener{
      public void mouseMoved(MouseEvent e){
         paddleL.setY(e.getY());
         paddleR.setY(e.getY());
         
         paddleT.setX(e.getX());
         paddleB.setX(e.getX());
         repaint();
      }//mouseMoved

      public void mouseDragged(MouseEvent e){} 
      
   }//end class PaddleMotion

   private class MouseRelatedStuff implements MouseListener{
      public void mouseClicked(MouseEvent e) 
      {
    	  time = 0;  
    	  System.out.println("hey");
      }
      public void mouseExited(MouseEvent e){}
      public void mouseEntered(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
      public void mousePressed(MouseEvent e){}
   }//MouseRelatedStuff
   
}//MyPanel

 




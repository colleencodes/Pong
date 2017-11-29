/*
 * Colleen Stock 
 * Dr. Wetklow
 * Advanced Programming
 * 17 Feburary 2010
 * Pong
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class PongDriver 
{
	public static void main(String[] args) throws Exception{

	      //create a frame and a panel
	      JFrame frame = new JFrame("Simple Pong");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      MyPanel mp = new MyPanel();

	      //add the panel to the frame
	      frame.getContentPane().add(mp);
	      frame.pack();
	      frame.setVisible(true);

	   }//main
}

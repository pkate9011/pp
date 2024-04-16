import java.awt.Color;

import java.awt.Dimension;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.Toolkit;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Slip24_a extends JPanel implements Runnable 
{

private String text;

private int x;

private int y;

private Thread thread;

public Slip24_a(String text) 
{

this.text = text;

x = -100; 
y = 50; 
setPreferredSize(new Dimension(800,100));
setBackground(Color.BLACK);
setForeground(Color.WHITE);
setFont(new Font("Arial",Font.BOLD,24));
thread=new  Thread(this);
thread.start();


}

public void paintComponent(Graphics g) 
{ 
	super.paintComponent(g);
	g.drawString(text, x, y); 	
}


public void run() 
{

while (true) 
{

x += 5;

if (x > getWidth())
{

x = -100; 

}

repaint();

try 
{

Thread.sleep(50);

}
catch (InterruptedException e) 
{

e.printStackTrace();

}

}

}

public static void main(String[] args) 
{

if (args.length < 1) 
{

System.out.println("Usage: java Scrolling Text <text>");

System.exit(1);
}


JFrame frame = new JFrame("Scrolling Text");


frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.getContentPane().add(new Slip24_a(args[0]));
frame.pack();

frame.setLocationRelativeTo(null); 

frame.setVisible(true);

}
}


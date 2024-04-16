

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JLabel; import javax.swing.JPanel;

import javax.swing. Timer;

public class Slip4_a implements Runnable 
{ 
	private JLabel label;

public Slip4_a(JLabel label) 
{
	this.label=label;

}



public void run() 
{

boolean on = true;

while (true) {

try {

Thread.sleep(500);

} catch (InterruptedException e) {
	e.printStackTrace();
}



if (on) {

label.setForeground(Color.RED);

} else {

label.setForeground(Color.BLACK);

}
on=!on;
}
}

public static void main(String[] args) {

JFrame frame = new JFrame("Blinking Text");

JPanel panel = new JPanel();

JLabel label = new JLabel("Hello World");

label.setFont(new Font("Arial", Font.BOLD, 30));

panel.add(label);

frame.add(panel);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.setSize(300, 200);

frame.setVisible(true);

Slip4_a slip4_a = new Slip4_a(label);

Thread thread = new Thread(slip4_a);

thread.start();

}
}
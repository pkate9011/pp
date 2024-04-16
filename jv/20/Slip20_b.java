import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Slip20_b extends JPanel implements ActionListener 
{

private Image image;

private Timer timer;

private boolean visible;

public  Slip20_b()
{

try 
{



BufferedImage img = ImageIO.read(new File("/home/mansi/Desktop/a.jpg"));


image = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);

}
catch (IOException e) 
{

e.printStackTrace();
}

timer = new Timer(500, this); 

timer.start(); // Start timer

visible = true; // Image is initially visible

}

public void paintComponent(Graphics g) {

super.paintComponent(g);

if (visible) {

g.drawImage(image, 0, 0, null); // Draw image if it's visible

}

}

public void actionPerformed(ActionEvent e) {

visible = !visible; // Toggle visibility of image

repaint(); // Redraw panel

}

public static void main(String[] args) 
{


JFrame frame = new JFrame("Blinking Image");

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Slip20_b panel = new Slip20_b();

panel.setPreferredSize(new Dimension(300, 300));

panel.setBackground(Color.WHITE);

frame.getContentPane().add(panel);

frame.pack();

frame.setVisible(true);

}

}

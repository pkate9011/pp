package slip;


import java.applet.*;
import java.awt.*;
import java.awt.event.*;import javax.swing.*;
class slip9A extends JFrame implements Runnable
{
Thread t;
int x,y;
slip9A()
{
super();
t= new Thread(this);
x=10;
y=10;
t.start();
setSize(1000,200);
setVisible(true);
setTitle("BOUNCEING BOLL WINDOW");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void run()
{
try
{
while(true)
{
x+=10;
y+=10;
repaint();
Thread.sleep(1000);
}
}catch(Exception e)
{
}
}
public void paint(Graphics g)
{
g.drawOval(x,y,7,7);}
public static void main(String a[])throws Exception
{
	slip9A t=new slip9A();
Thread.sleep(1000);
}
}















import java.awt.FlowLayout;

import java.awt.TextField;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;

public class Slip17_b implements Runnable 
{

private TextField textField;

public Slip17_b(TextField textField) 
{

this.textField =textField;
}
public void run() {

for (int i = 1; i <= 100; i++) 
{

textField.setText(String.valueOf(i));

try 
{
Thread.sleep(100); 
} 
catch (InterruptedException e) 
{

e.printStackTrace();

}

}
}

public static void main(String[] args) 
{

JFrame frame = new JFrame("Number Display");

frame.setLayout(new FlowLayout());

frame.setSize(300, 100);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
TextField textField = new TextField(10);

JButton button = new JButton("Display Numbers");

button.addActionListener(new ActionListener() 
{

@Override

public void actionPerformed(ActionEvent e) {

Slip17_b slip17_b = new Slip17_b(textField);

Thread thread = new Thread(slip17_b);

thread.start();

}

});
frame.add(textField);

frame.add(button);

frame.setVisible(true);
}

}
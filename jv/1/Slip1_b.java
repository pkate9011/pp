import java.awt.*;
        import javax.swing.*;
        import java.awt.event.*;
        import java.sql.*;
public class Slip111_b extends Frame implements ActionListener
{
    Label l1,l2,l3,l4;
    TextField t1,t2,t3,t4;
    Button b;
    //Connection cn;
    Statement st;
    ResultSet rs;
    public Slip111_b()
    {
        setLayout(null);
        l1=new Label("Eno");
        l2=new Label("Ename");
        l3=new Label("Salary");
        l4=new Label("Edesignation");
        t1=new TextField();
        t2=new TextField();
        t3=new TextField();
        t4=new TextField();

        b=new Button("Save");
        l1.setBounds(50,50,100,30);
        t1.setBounds(160,50,100,30);
        l2.setBounds(50,90,100,30);
        t2.setBounds(160,90,100,30);
        l3.setBounds(50,130,100,30);
        t3.setBounds(160,130,100,30);
        l4.setBounds(50,170,100,30);
        t4.setBounds(160,170,100,30);

        b.setBounds(50,210,100,30);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b);

        b.addActionListener(this);
        setSize(500,500);
        setVisible(true);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent oe)
    {
        String str=oe.getActionCommand();
        if(str.equals("Save"))
        {
            try
            {
            	Class.forName("org.postgresql.Driver");
                System.out.println("Driver is loaded");
                
            	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/java","mansi","mansi123");
            	System.out.println("Con ok****");
                st =con.createStatement();

                int eno = Integer.parseInt(t1.getText());
                String ename = t2.getText();
                int esalary = Integer.parseInt(t3.getText());
                String edes = t4.getText();

                String strr= "insert into emp values(" + eno + " ,'" + ename + "'," + esalary + ",'" + edes +"')";
                int k=st.executeUpdate(strr);
                if(k>0)
                {

                    JOptionPane.showMessageDialog(null,"Record Is Added");
                }
            }
            catch(Exception er)
            {
                System.out.println(er);
            }
        }
    }
    public static void main(String args[])
    {
    	Slip111_b sb = new Slip111_b();

    }
}

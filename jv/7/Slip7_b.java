
import java.util.*;
import java.sql.*;

public class Slip7_b {

	public static void main(String[] args) 
	{
		int n;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
		    System.out.println("Driver is loaded");
		    
	do
	{
		System.out.println("1.Insert");
		
		System.out.println("2.View All");
		System.out.println("3.Exit");
		
		System.out.println("enter your choice");
		n=sc.nextInt();
		switch(n)
		{
		case 1:
			Connection cn=DriverManager.getConnection("jdbc:postgresql://localhost/java","mansi","mansi123");
			System.out.println("Con ok****");
			     if(cn==null)
			     {
			    	 System.out.println("connection is failed");
			     }
			    	 else
			    	 {
			     
			    System.out.println("enter how many records you want to insert");
			    int n1=sc.nextInt();
			    for(int i=0;i<n1;i++) {
			    	
			        PreparedStatement st=cn.prepareStatement("insert into producttable values(?,?,?)");
			    System.out.println("enter values you want to insert into producttable table");
			    int pid=sc.nextInt();
			    String pn=sc.next();
			    String price=sc.next();
			    
			    st.setInt(1,pid);
			    st.setString(2,pn);
			    st.setString(3,price);
			    
			    		int d1=st.executeUpdate();
			    		System.out.println("Record inserted"+d1);
			    }
			    	 }
			    break;
		
			    case 2:
			    	Connection cn4=DriverManager.getConnection("jdbc:postgresql://localhost/java","mansi","mansi123");
			    	System.out.println("Con ok****");
			    	  	Statement st4=cn4.createStatement();
			    ResultSet s=st4.executeQuery("Select * from producttable"
			    		+ ""
			    		+ "");
			    System.out.println("Product_id"+"    "+"Product_Name"+"   "+"product_price");
			    while(s.next())
			    
			    {
			    	System.out.println(s.getString(1)+"        "+s.getString(2)+"     "+s.getString(3));
			    	
			    }
			    	break;
			    	
		}
	}while(n<6);
	
		}catch(Exception e) {
			System.out.println("SQL ERROR===>"+e);
		}
	}

}
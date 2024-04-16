

import java.lang.*;
import java.util.*;
 class MyThread1 extends Thread
{
	public MyThread1(String s1)
	{
         super(s1);
    }
    public void run()
   {
      System.out.println(getName()+"thread created.");
        Random r=new Random();
       int s=r.nextInt(5000);
        System.out.println(getName()+"is sleeping for :"+s+"msec");
    try{
         Thread.sleep(s);
        }
     catch(Exception e)
     {}
   }
}

public class Slip13_b
{
public static void main(String args[]) throws InterruptedException
{
MyThread1 t1=new MyThread1("tybcsA");
MyThread1 t2=new MyThread1("tybcsB");
t1.start();
t2.start();
t1.join();
t2.join();
System.out.println(t1.getName()+ "thread dead.");
System.out.println(t2.getName()+"thread dead.");
}
} 
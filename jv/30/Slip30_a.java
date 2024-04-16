class SharedResource 
{

private int count = 0;

synchronized void increment() {

count++;

System.out.println("Count is now: " + count);

}

}

class MyThread extends Thread 
{

SharedResource resource;
MyThread(SharedResource resource)
{
	this.resource=resource;
}


public void run() 
{

for (int i = 0; i < 5; i++) 
{

resource.increment();

}


}

}

public class Slip30_a 
{

public static void main(String[] args)
{

SharedResource resource = new SharedResource();

MyThread thread1 = new MyThread(resource);

MyThread thread2 = new MyThread(resource);

thread1.start();

thread2.start();
}
}


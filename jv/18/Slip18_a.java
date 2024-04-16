
public class Slip18_a
{


public static void main(String[] args)
{
	Thread thread = new Thread();
	thread.setName("My Thread");
    thread.setPriority(Thread.MAX_PRIORITY);
    String threadName = thread.getName();
    int threadPriority = thread.getPriority();
    System.out.println("Thread Name: " + threadName); 
    System.out.println("Thread Priority:" + threadPriority);


}
}

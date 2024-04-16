

public class Slip1_a
{
	

public static void main(String[] args) throws InterruptedException 
{
	

char c = 'A';

while (c <= 'Z') {

System.out.print(c + "");

Thread.sleep(2000); // sleep for 2 seconds

c++;
}
}
}
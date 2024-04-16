import java.util.Scanner;

public class Slip23_a 
{

public static void main(String[] args) throws InterruptedException 
{

Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");

String str = sc.nextLine();

sc.close();

str = str.toLowerCase();


int len = str.length();
for(int i=0; i<len; i++) 
{

char ch = str.charAt(i);

if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') 
{

System.out.print(ch + " ");

Thread.sleep(3000); // sleep for 3 seconds

}
}
}
}



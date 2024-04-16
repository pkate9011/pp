import java.util.LinkedList;

import java.util. Iterator;

import java.util.Scanner;

public class Slip21_a 
{

public static void main(String[] args) 
{ 
	LinkedList<String> subjectList = new LinkedList<String>();


Scanner scanner = new Scanner(System.in);

System.out.print("Enter the number of subjects");


 int n = scanner.nextInt();

for(int i=1; i<=n; i++) 
{

System.out.print("Enter subject "+i+": ");

String subject = scanner.next();

subjectList.add(subject);

}

Iterator<String> itr = subjectList.iterator();

System.out.println("Subjects:");

while(itr.hasNext()) {

System.out.println(itr.next());

}

}
}



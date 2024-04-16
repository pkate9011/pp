import java.util.Scanner;

import java.util. TreeSet;

public class Slip17_a
{

public static void main(String[] args) 
{

Scanner scanner = new Scanner(System.in);

System.out.print("Enter the number of integers: ");

int n = scanner.nextInt();

TreeSet<Integer> integers = new TreeSet<>();

for (int i = 0; i<n; i++) 
{

System.out.print("Enter an integer"); 
integers.add(scanner.nextInt());
}

System.out.println("The integers in sorted order are:");

for (int integer : integers)
{
 System.out.println(integer);	
}
}
}






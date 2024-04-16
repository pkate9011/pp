import java.util.*;

public class Slip19_a 
{

	public static void main(String[] args) 
	{

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of integers: ");

		int n = scanner.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) 
		{

			System.out.print("Enter an integer: ");

			int num = scanner.nextInt();

			list.add(num);

		}

		System.out.println("Negative integers in the list:");

		for (int num: list)
		{

			if (num < 0) 
			{

				System.out.println(num);

			}

			

		}
	}
}


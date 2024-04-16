
import java.util.Scanner;
import java.util.TreeSet;

public class Slip6_a {

    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of integers:");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");
        for(int i=0; i<n; i++)
        {
            t.add(sc.nextInt());
        }

        System.out.println(" numbers are sorting order:"+t);
    }
}

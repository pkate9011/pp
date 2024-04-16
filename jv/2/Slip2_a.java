
import java.util.*;

public class Slip2_a
{

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter the number of friends: "); 
int n = sc.nextInt();

Set<String> friends = new HashSet<>();

// read 'N' names of friends

for (int i = 1; i <= n; i++) 
{

System.out.print("Enter the name of friend" + i + ": ");
String name = sc.next(); 
friends.add(name); 
}
System.out.print("friend names in ascending order:");
List<String> friendList = new ArrayList<>(friends);
Collections.sort(friendList);
for (String name: friendList) 
{
System.out.println(name);	

}
}
}
import java.util.*;

class Slip29_b

{

public static void main(String[]args)

{

LinkedList<Integer> LI =new LinkedList<Integer>();

LI.add(12);

LI.add(24);

LI.add(5);

LI.add(9);

Iterator itr=LI.iterator();

System.out.println("Original List:");

while(itr.hasNext())

{
	System.out.println(itr.next());

}


LI.addFirst(8);

System.out.println("Modified list is:"+LI);

LI.removeLast();
System.out.println("Modified list is:"+LI);

System.out.println("Size="+LI.size());

}

}
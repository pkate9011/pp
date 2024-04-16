import java.util.*;

public class Slip3_b
{
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add("swapnil");
        l.add("omu");
        l.add("avi");
        l.addLast("suraj");
        System.out.println("After adding Last element :"+l);
        l.removeFirst();
        System.out.println("After removing first element : "+l);
        Collections.reverse(l);
        System.out.println("After reversing linkedlist : "+l);
    }
}
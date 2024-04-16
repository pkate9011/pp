import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import java.util.ListIterator;

public class Slip23_b 
{


public static void main(String[] args) 
{

List<String> studentList = new ArrayList<>();



for (int i = 0; i < args.length; i++) {

studentList.add(args[i]);
System.out.println("Printing student names using Iterator interface:");

Iterator<String> it = studentList.iterator();

while (it.hasNext()) {

System.out.println(it.next());

}

System.out.println("\nPrinting student names using ListIteratorinterface:");

ListIterator<String> listit = studentList.listIterator();

while (listit.hasNext()) 
{

System.out.println(listit.next());

}
}
}
}

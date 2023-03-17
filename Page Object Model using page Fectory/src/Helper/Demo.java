package Helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class Demo {

		public static void main(String[] args)
		{
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(1.1);
			list.add(2.2);

			 int index1 = 0;
			 Object elem1 = list.get(index1);
			 
			 int index2 = 1;
			 Object elem2 = list.get(index2);
			 
			 list.set(index1, elem2);
			 
			 list.set(index2, elem1);

			 System.out.println("After swapping: " + list.get(0)+" and second is = "+list.get(1));
		}
		
}

/*int x = 100, y = 200;

System.out.println("Before Swap");
System.out.println("x = " + x);
System.out.println("y = " + y);

int temp = x;
x = y;
y = temp;

System.out.println("After swap");
System.out.println("x = " + x);
System.out.println("y = " + y);*/

//======================================================================
/*	ArrayList<Object> list = new ArrayList<Object>();
list.add(1.1);
list.add(2.2);

 int index1 = 0;
 Object elem1 = list.get(index1);
 
 int index2 = 1;
 Object elem2 = list.get(index2);
 
 list.set(index1, elem2);
 
 list.set(index2, elem1);

 System.out.println("After swapping: " + list);*/


	


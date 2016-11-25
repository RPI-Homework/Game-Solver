package checkerssolitaire; 

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Provides several preset Checker Solitaire Setups
 */

public class Configurations
{
	
	public static ArrayList theConfigs = new ArrayList();
		
	public static void addAll()
	{
	
	   //Cross
	   LinkedList set1 = new LinkedList();
	   set1.add(new CheckerNode(2,2));
	   set1.add(new CheckerNode(3,1));
	   set1.add(new CheckerNode(3,2));
	   set1.add(new CheckerNode(3,3));
	   set1.add(new CheckerNode(3,4));
	   set1.add(new CheckerNode(4,2));
	   theConfigs.add(set1);
	   
	   //Up Arrow
	   LinkedList set2 = new LinkedList();
	   set2.add(new CheckerNode(1,2));
	   set2.add(new CheckerNode(2,1));
	   set2.add(new CheckerNode(2,2));
	   set2.add(new CheckerNode(2,5));
	   set2.add(new CheckerNode(2,6));
	   set2.add(new CheckerNode(3,0));
	   set2.add(new CheckerNode(3,1));
	   set2.add(new CheckerNode(3,2));
	   set2.add(new CheckerNode(3,3));
	   set2.add(new CheckerNode(3,4));
	   set2.add(new CheckerNode(3,5));
	   set2.add(new CheckerNode(3,6));
	   set2.add(new CheckerNode(4,1));
	   set2.add(new CheckerNode(4,2));
	   set2.add(new CheckerNode(4,5));
	   set2.add(new CheckerNode(4,6));
	   set2.add(new CheckerNode(5,2));
	   theConfigs.add(set2);
	   
	   //Solitaire
	   LinkedList set3 = new LinkedList();
	   set3.add(new CheckerNode(0,2));
	   set3.add(new CheckerNode(0,3));
	   set3.add(new CheckerNode(0,4));
	   set3.add(new CheckerNode(1,2));
	   set3.add(new CheckerNode(1,3));
	   set3.add(new CheckerNode(1,4));
	   set3.add(new CheckerNode(2,0));
	   set3.add(new CheckerNode(2,1));
	   set3.add(new CheckerNode(2,2));
	   set3.add(new CheckerNode(2,3));
	   set3.add(new CheckerNode(2,4));
	   set3.add(new CheckerNode(2,5));
	   set3.add(new CheckerNode(2,6));
	   set3.add(new CheckerNode(3,0));
	   set3.add(new CheckerNode(3,1));
	   set3.add(new CheckerNode(3,2));
	   set3.add(new CheckerNode(3,4));
	   set3.add(new CheckerNode(3,5));
	   set3.add(new CheckerNode(3,6));
	   set3.add(new CheckerNode(4,0));
	   set3.add(new CheckerNode(4,1));
	   set3.add(new CheckerNode(4,2));
	   set3.add(new CheckerNode(4,3));
	   set3.add(new CheckerNode(4,4));
	   set3.add(new CheckerNode(4,5));
	   set3.add(new CheckerNode(4,6));
	   set3.add(new CheckerNode(5,2));
	   set3.add(new CheckerNode(5,3));
	   set3.add(new CheckerNode(5,4));
	   set3.add(new CheckerNode(6,2));
	   set3.add(new CheckerNode(6,3));
	   set3.add(new CheckerNode(6,4));
	   theConfigs.add(set3);
	}
}
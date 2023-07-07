import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Project 04 - FinalProject GPS
//Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
//Date: 05/06/2022
//Purpose: Implement Tester Class

public class Tester {

	public static void main(String[] args) {
		Graph test = new Graph("MapInformation.txt");
		Scanner in = new Scanner(System.in);
		
		System.out.println("Shortest Path Calculator");
	
				
		System.out.println("Insert two nodes to test between (i.e. A C):");
		
		String first = in.next();
		String last= in.next();
		
		System.out.println("Paths to find shortest distance: " + first + " -> " + last);
		System.out.println("Use distance or time cost? (Distance or Time)");
		
		String type = in.next();
		test.useDistanceCost = type.equals("Distance");
		
		Path shortest = Dijkstra.shortestPath(test, test.getVertices(first), test.getVertices(last));
		
		System.out.println(shortest.toString());
		System.out.println();
		System.out.println(shortest.addressToString(test));
	}
}


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Final Lab
 * 
 * Lab-12_GraphOperations
 * 60 points 10 for each of the 6 unwritten methods. 
 * 
 * @author Andrew Boothe
 * @author Vimal Vimod
 * 
 * @apiNote Complete the uncoded methods below
 *  		DO NOT HARD CODE AN ANSWER. If you don't
 *  		solve a method just leave the throw command
 */

public class GraphOperations {

	
	//========================================================================= isSymetric
	public static boolean isSymmetric(boolean[][] data) {
		int n = data.length;
		for(int r = 0; r < n; r++)
			for(int c = 0; c < n; c++)
				if(data[r][c] != data[c][r]) return false;		
		return true;
	}
	
	public static boolean isSymmetric(Map<String, Set<String>> data) {
		for (String key : data.keySet()) {
			for (String val : data.get(key)) {
				if (!data.get(val).contains(key)) return false;
			}
		}
		return true;
	}
	
	//========================================================================= isRegular
	public static boolean isRegular(Map<String, Set<String>> data) {	
		int size = -1;
		
		for(Set<String> vals : data.values()) {
			if(size == -1) size = vals.size();
			else if(vals.size() != size) return false;
		}
		return true;
	}
	
	public static boolean isRegular(boolean[][] data) {
		boolean check = true;
		int n = data.length;
		int r = numOutGoingEdges(data, 0);
		for (int i = 0; i < n; i++) {
			if (!(numOutGoingEdges(data, i) == r)) {
				check = false;
			}
		}
		return check;
	}

	private static int numOutGoingEdges(boolean[][] data, int v) {
		int n = data.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(data[v][i])
				count++;
		}
		return count;
	}
	
	//========================================================================= isComplete
	public static boolean isComplete(Map<String, Set<String>> data) {
		int n = data.size()-1;
		for(Set<String> vals : data.values())
			if(vals.size() != n) return false;
		return true;
	}
	
	public static boolean isComplete(boolean[][] data) {
//		throw new UnsupportedOperationException("isComplete(boolean[][] data)");
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (!data[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	//========================================================================= getPredecessors
	public static Set<Integer> getPredecessors(boolean[][] data, int vertex) {
		Set<Integer> ret = new TreeSet<Integer>();
		int n = data.length;
		
		for(int r = 0; r < n; r++)
			if(data[r][vertex]) ret.add(r);
		
		return ret;
	}
	
	public static Set<String> getPredecessors(Map<String, Set<String>> data, String vertex) {
//		throw new UnsupportedOperationException("getPredecessors(Map<String, Set<String>> data, String vertex");
		Set<String> ret = new TreeSet<String>();
		int n = data.size();
		for(String vals : data.keySet()) {
			Set<String> getter = data.get(vals);
			if (getter.contains(vertex)) {
				ret.add(vals);
			}
		}
		return ret;
	}

	//========================================================================= isValidPath
	public static boolean isValidPath(Map<String, Set<String>> data, String[] path) {
//		throw new UnsupportedOperationException("isValidPath(Map<String, Set<String>> data, String[] path)");
		boolean checker = false;
		for (String vals : data.keySet()) {
			Set<String> getter = data.get(vals);
			for (int i = 0; i < path.length; i++) {
				if (!(getter.contains(path[i]))) {
					checker = false;
				} else {
					checker = true;
					break;
				}
			}
		}
		return checker;
	}
	
	public static boolean isValidPath(boolean[][] data, int[] path) {
//		throw new UnsupportedOperationException("boolean[][] data, String[] path)");
		int n = data.length;
		int k = 0;
		for (int i = 0; i < path.length-1; i++) { // ?
			if (!(data[path[i]][path[i+1]])) {
				return false;
			}
		}
		return true;
	}
	
	//************************************************************************************** main() for testing
	public static void main(String[] args) {
		
		//=============================================================================== adjMatrix
		
		System.out.println("Adjacency Matrix Operations");
		System.out.println("========================================");
		boolean[][] adjMatrix = {
				{false,	true,	false,	true,	true},		// [0,0]=f, [0,1]=t, [0,2]=f, [0,3]=t, [0,4]=t
				{true,	false,	true,	false,	false},		// [1,0]=t, [1,1]=f, [1,2]=t, [1,3]=f, [1,4]=f
				{false,	true,	false,	true,	false},		// [2,0]=f, [2,1]=t, [2,2]=f, [2,3]=t, [2,4]=f
				{true,	false,	true,	false,	false},		// [3,0]=t, [3,1]=f, [3,2]=t, [3,3]=f, [3,4]=f
				{true,	false,	false,	false,	false}		// [4,0]=t, [4,1]=f, [4,2]=f, [4,3]=f, [4,4]=f
		};
		try {System.out.println("Symmetric   : " + isSymmetric(adjMatrix));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Regular     : " + isRegular(adjMatrix));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Complete    : " + isComplete(adjMatrix));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Predecessors: " + getPredecessors(adjMatrix, 0));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Valid Path  : " + isValidPath(adjMatrix, new int[]{0, 3, 2, 1}));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		
		System.out.println();
		System.out.println("Adjacency List Operations");
		System.out.println("========================================");	
		Map<String, Set<String>> adjList = new HashMap<String, Set<String>>();
		adjList.put("A", new TreeSet<String>(Arrays.asList("B","D","E")));
		adjList.put("B", new TreeSet<String>(Arrays.asList("A","C")));
		adjList.put("C", new TreeSet<String>(Arrays.asList("B","D")));
		adjList.put("D", new TreeSet<String>(Arrays.asList("A","C")));
		adjList.put("E", new TreeSet<String>(Arrays.asList("A")));
		

		try {System.out.println("Symmetric   : " + isSymmetric(adjList));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Regular     : " + isRegular(adjList));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Complete    : " + isComplete(adjList));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Predecessors: " + getPredecessors(adjList, "A"));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		try {System.out.println("Valid Path  : " + isValidPath(adjList, new String[]{"A", "D", "C", "B"}));} 
		catch (Exception e) {System.err.println(e.getMessage());}
		
		
		
		
		
	}

}

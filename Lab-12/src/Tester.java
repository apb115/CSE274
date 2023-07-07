import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Tester {

	public static void main(String[] args) {
		
		// adjMatrix
		boolean[][] adjMatrix = {
								{false, true, false},
								{true, false, true}, 
								{false, true, false}
		};
		
		System.out.println(getPredecessors(adjMatrix, 2));
		
		// adjList
		Map<String, Set<String>> adjList = new HashMap<String, Set<String>>();
		adjList.put("A", new TreeSet<String>(Arrays.asList("B", "C", "D")));
		adjList.put("B", new TreeSet<String>(Arrays.asList("A", "C", "D")));
		adjList.put("C", new TreeSet<String>(Arrays.asList("A", "B", "D")));
		adjList.put("D", new TreeSet<String>(Arrays.asList("A", "B", "C")));
		
		System.out.println("Regular?: " + isRegular(adjList));
	}

	private static boolean isRegular(Map<String, Set<String>> adjList) {
		if (adjList.isEmpty()) return true;
		int degree = -1;
		for (String vert : adjList.keySet())
			if (degree == -1) degree = adjList.get(vert).size();
			else if (degree != adjList.get(vert).size()) return false;
		
		return true;
	}

	private static Set<Integer> getPredecessors(boolean[][] adjMatrix, int vertex) {
		Set<Integer> ret = new TreeSet<Integer>();
		
		int n = adjMatrix.length;
		for (int r = 0; r<n; r++)
			if (adjMatrix[r][vertex])
				ret.add(r);
		return ret;
	}

}

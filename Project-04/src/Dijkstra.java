import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//Project 04 - FinalProject GPS
//Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
//Date: 05/06/2022
//Purpose: Implement Dijkstra's Algorihtm


public class Dijkstra {

	//==============================================================Properties
	public static int totalCost;

	//==============================================================Methods
	
	// Method to output shortest path between two vertices
	public static Path shortestPath(Graph graph, Vertex startVertex, Vertex endVertex) {
		HeapPriorityQueue<Path> pq = new HeapPriorityQueue<Path>(); // HeapPriorityQueue from Lab11 
		Map<Vertex, Integer> visited = new HashMap<Vertex, Integer>(); // visited Map for visited vertices with cost
		
		pq.add(new Path(startVertex.getSymbol() + " -> ", 0, startVertex)); // Add the starting Path from vertex to itself
		
		while (!pq.isEmpty()) { // while loop to loop through PriorityQueue
			Path nextEntry = pq.remove(); // each entry is the lowest cost removed from PriorityQueue
			if (nextEntry.getFrom().getSymbol().equals(endVertex.getSymbol())) {
				return nextEntry; // ends code once endVertex is found
			}
			for (Edge e : graph.adjList.get(nextEntry.getFrom())) { // loop through neighboring edges at a vertex
				
				if (!visited.containsKey(e.getDestination()))
					visited.put(e.getDestination(), e.getCost()); // add latest vertex from edge to visited
				else {
					if (nextEntry.getCost() + e.getCost() > visited.get(e.getDestination()))
						continue; // checks if combined cost is greater than edge destination vertex

					else
						visited.put(e.getDestination(), nextEntry.getCost() + e.getCost());
				}
				int nextCost = nextEntry.getCost() + e.getCost(); // new combined cost from edge
				String nextPath = nextEntry.getPath() + e.getDestination().getSymbol(); // new string symbol of passed through vertex

				pq.add(new Path(nextPath + " -> ", nextCost, e.getDestination())); // adds resulting path to PriorityQueue
				
			}
		}
		return null; // null if there is no viable path found
	}
}
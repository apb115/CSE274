import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Project 04 - FinalProject GPS
//Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
//Date: 05/06/2022
//Purpose: Implement Graph Class

public class Graph {

	//===================================================================Instance Properties
	public static boolean useDistanceCost;
	public static boolean returnAddress;
	
	public HashMap<Vertex, Set<Edge>> adjList = new HashMap<Vertex, Set<Edge>>(); // sets up adjacency matrix
	
	public Set<Vertex> vertices = new HashSet<Vertex>(); // used for finding correct vertices and edges to add into adjList
	
	//===========================================================================Constructor
	public Graph (String file) { // initializes graph
		readFile(file);
	}
	//===========================================================================Methods
	public void readFile(String fileName) { // method given to read File
        try {
            
            // Creates a scanner
            Scanner file = new Scanner(new File(fileName));
            String line = file.nextLine();
                        
            // Skips lines until the Nodes are reached
            while (!line.equals("<Nodes>")) { line = file.nextLine(); }
            
            // Skips two lines of header text in the file
            file.nextLine();
            line = file.nextLine();
            
            // Creates Vertex objects (each of which contains a symbol and an address property)
            while (!line.equals("</Nodes>")) {
                String[] s = line.split("\t");
                Vertex next = new Vertex(s[0], s[1]);
                vertices.add(next); // adds new vertex created from reading through file
                line = file.nextLine();
            }
            
            // Skips lines until Edges are reached
            while (!line.equals("<Edges>")) { line = file.nextLine(); }
            file.nextLine();
            
            // Creates Edge objects (each of which contains a source, destination, time cost, 
            // and distance cost property) and adds them to a set
            line = file.nextLine();
            String[] s = line.split("\t");
            while (!line.equals("</Edges>")) {
            	Vertex w = null;
            	for (Vertex v : vertices) { // loop that goes through and finds the correct source vertex
            		if (v.getSymbol().equals(s[0])) {
            			w = v;
            		}
            	}
                Set<Edge> edges = new HashSet<Edge>();

                do {
                    Vertex destination	= null;
                    for (Vertex v : vertices) { // loop that goes through and finds the correct destination vertex 
                		if (v.getSymbol().equals(s[1])) {
                			destination = v;
                		}
                	}
                    edges.add(new Edge(w, destination, Integer.parseInt(s[2]), Integer.parseInt(s[3])));
                    line = file.nextLine();
                    s = line.split("\t");
                } while (s[0].equals(w.getSymbol()));
                
                // When the next line contains a different source Vertex, the current set of Edges are
                // added to the graph Map as values of the corresponding Vertex key (the source Vertex)
                adjList.put(w, edges);
                
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        }
    }
	
	public Vertex getVertices(String input) { // takes user input and converts string into correct vertex
		Vertex ret = null;
		Set<Vertex> vertices2 = adjList.keySet();
		for (Vertex v : vertices2) {
			if (v.getSymbol().equals(input)) {
				ret = v;
				break;
			}
		}
		return ret;
	}
	
	public String findSymbol(String address) { // takes user input and returns symbol string from address
		for (Vertex temp: adjList.keySet()) {
			if (temp.getAddress().equals(address)) return temp.getSymbol();
		}
		return null;
	}
	
}
	


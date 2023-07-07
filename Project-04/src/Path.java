import java.util.List;

//Project 04 - FinalProject GPS
//Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
//Date: 05/06/2022
//Purpose: Implement Path Class

public class Path implements Comparable<Path> {

	//===================================================================Instance Properties
	private String path;
	private int cost;
	private Vertex from;
	
	//===================================================================Constructors
	public Path(String path, int cost, Vertex from) {
		this.path = path;
		this.cost = cost;
		this.from = from;
	}
	
	//===================================================================Methods
	// This is the to String for outputting the path
	 @Override
	 public String toString() {
		 return "[" + "Destination: " + from.getSymbol() + " Path: " + path + " Cost: " + cost + "]";
	 }
	 
	 // toString for outputting path with corresponding addresses
	 public String addressToString(Graph g) {
		 String ret;
		 String tmp = "";
		 int count = 0;
		 ret = "[" + "Destination: " + from.getAddress() + "]\n" + "Path: ";
		 for (int i = 0; i < path.length(); i++) {
			 if (Character.isLetter(path.charAt(i))) {
				 tmp = Character.toString(path.charAt(i));
			 } else {
				 continue;
			 }
			 
			 if (count == 0) {
				 ret += g.getVertices(Character.toString(path.charAt(i))).getAddress() + "\n";
				 count++;
			 } else {
				 ret += "      " + g.getVertices(Character.toString(path.charAt(i))).getAddress() + "\n";
			 }
		 }
		 ret += "[Cost: " + cost + "]";
		 return ret;
	 }
	 
	// This is the compare to Method for return the lower of 2 Costs
	public int compareTo(Path other) {
		return cost - other.cost;    // lower cost goes first
	}
	
	//===================================================================Getters / Setters
	
	// Get the path
	public String getPath() {
		return path;
	}
	// Get the cost
	public int getCost() {
		return cost;
	}
	// Get the From Vertex
	public Vertex getFrom() {
		return from;
	}
	// Set the Path
	public void setPath(String path) {
		this.path = path;
	}
	// Set the Cost
	public void setCost(int cost) {
		this.cost = cost;
	}
	// Set the From Vertex
	public void setFrom(Vertex from) {
		this.from = from;
	}
	
}

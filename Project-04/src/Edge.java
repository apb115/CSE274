
// Project 04 - FinalProject GPS
// Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
// Date: 05/06/2022
// Purpose: Implement Edge Class

public class Edge {

	
	//===================================================================Instance Properties
	private Vertex source;
	private Vertex destination;
	private int timeCost;
	private int distanceCost;
	
	
	//===================================================================Constructors
	public Edge(Vertex source, Vertex destination, int timeCost, int distanceCost) {
		this.source = source;
		this.destination = destination;
		this.timeCost = timeCost;
		this.distanceCost = distanceCost;
	}

	//=================================================================Methods
	// This is the toString for Time or Distance cost
	@Override
	public String toString() {
		if (Graph.useDistanceCost) 
		return String.format("%s -> %s, Distcost: %d",source, destination, distanceCost);
		else 
		return String.format("%s -> %s, Timecost: %d",source, destination, timeCost);
	}
	
	
	//=================================================================Getters/Setters
	// Get the Source
	public Vertex getSource() {
		return source;
	}

	// Set the Source
	public void setSource(Vertex source) {
		this.source = source;
	}

	// Get the Destination
	public Vertex getDestination() {
		return destination;
	}

	// Set the Destination
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	// Get the cost (Distance / Time)
	public int getCost() {
		return Graph.useDistanceCost ? distanceCost : timeCost;
	}

	// Set the time Cost
	public void setTimeCost(int timeCost) {
		this.timeCost = timeCost;
	}

	// Get the Distance Cost
	public int getDistanceCost() {
		return distanceCost;
	}

	// Set the Distance Cost
	public void setDistanceCost(int distanceCost) {
		this.distanceCost = distanceCost;
	}

}

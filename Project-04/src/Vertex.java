
// Project 04 - FinalProject GPS
// Names: Vimal Vinod (vinodv), Aaron Bryant (bryant53), Andrew Boothe (boothea)
// Date: 05/06/2022
// Purpose: Implement Vertex Class

public class Vertex {
	
	//===================================================================Instance Properties
	private String symbol;
	private String address;
	
	//==================================================================Constructors

	public Vertex(String symbol, String address) {
		this.symbol = symbol;
		this.address = address;
	}
	
	//=================================================================Methods
	//  This is the to String for outputting the Vertex Symbol and address
	
	@Override
	public String toString() {
		return "Vertex Symbol: " + symbol + "; Vertex Address: " + address;
	}
	
	
	//=================================================================Getters/Setters
	// Get the symbol
	public String getSymbol() {
		return this.symbol;
	}
	// Get the address
	public String getAddress() {
		return this.address;
	}
	// Set the Symbol
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	// Set the Address
	public void setAddress(String address) {
		this.address = address;
	}
	

}

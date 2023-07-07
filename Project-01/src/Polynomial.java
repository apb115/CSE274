import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 Name: Andrew Boothe
 Class: CSE-274 A
 Date: 2/21/2022
 Project: Project-01
 */

public class Polynomial {
	
	private ArrayList<Node> terms;

	/*
	 Node Inner Class (represents a single term)
	*/
	private class Node implements Comparable<Node> {
		double coefficient;
		int exponent;
		
		public Node(double c, int e) {
			coefficient = c;
			exponent = e;
		} 

		/* 
		 Changed the compareTo to account for 
		 	ordering terms with 0 for exponent
		*/
		@Override
		public int compareTo( Node node ) {
			if(node.exponent == 0) {
				if(exponent != 0)	return -1000;
				else				return (int)(node.coefficient-coefficient);
			}
			return node.exponent - exponent;	
		}

		// 2 helper methods I added for toString and comparing terms
		@Override
		public String toString() {
			if(Math.abs(coefficient) < 0.0000000001) return "";
			
			String ret = ((coefficient < 0 ? " - " : " + ") + Math.abs(coefficient));
			if(exponent == 0) 	return ret;
			return ret + "x" + (exponent != 1 ? "^" + exponent : "");  // accounts for -exponents
		}

		public boolean equals(Node n) {
			return compareTo(n) == 0;
		}
	}


	//==================================================================== Constructors
	public Polynomial() { 														// default constructor
		terms = new ArrayList<Node>();
	}

	public Polynomial(Polynomial poly) { 										// copy constructor
		this();
		ArrayList<Node> polyNodes = poly.terms;
		for (Node node : polyNodes) {
			addTerm(node);
		}
	}

	public Polynomial(ArrayList<Double> coef, ArrayList<Integer> expon) {		// workhorse
		if (coef.size() != expon.size()) {
			throw new InvalidParameterException();
		}
		terms = new ArrayList<Node>();
		for (int i = 0; i < coef.size(); i++) {
			addTerm(new Node(coef.get(i), expon.get(i)));
		}
		Collections.sort(terms);
	}
	
	private void addTerm(Node node) {
		for (Node term: terms) {
			if (term.exponent == node.exponent) {
				term.coefficient += node.coefficient;
				return;
			}
		}
		
		terms.add(new Node(node.coefficient, node.exponent));
	}
	
	private void subtractTerm(Node node) {
		for (Node term: terms) {
			if (term.exponent == node.exponent) {
				term.coefficient -= node.coefficient;
				return;
			}
		}
		terms.add(new Node(node.coefficient*-1, node.exponent));
	}

	//==================================================================== Methods
	// check all terms for equality
	public boolean equals(Polynomial poly) { 
		Polynomial ret = new Polynomial(this);
		
		for (int i = 0; i < terms.size(); i++) {
			if (((poly.terms.get(i).coefficient != (ret.terms.get(i).coefficient)) ||
					(poly.terms.get(i).exponent) != (ret.terms.get(i).exponent))) {
				return false;
			}
		}
		return true;
	}

	//====================================================== Add
	public Polynomial add(Polynomial poly) {
		Polynomial ret = new Polynomial(this);
		for (Node node : poly.terms) {
			ret.addTerm(node);
		}
		return ret;
	}

	//====================================================== Subtract
	public Polynomial subtract(Polynomial poly) {
		Polynomial ret = new Polynomial(this);
		for (Node node : poly.terms) {
			ret.subtractTerm(node);
		}
		return ret;		
	}

	//====================================================== Multiply
	public Polynomial multiply(Polynomial poly) {
		Polynomial ret = new Polynomial(this);
		Polynomial result = new Polynomial();
		
		for (Node node1 : ret.terms) {
			for (Node node2 : poly.terms) {
				result.addTerm(new Node(node1.coefficient * node2.coefficient, 
						node1.exponent + node2.exponent));
			}
		}
		return result;
	}

	
	//====================================================== Evaluate
	// Evaluates the polynomial with the parameter value for the variable
	public double evaluate(double value) { 
		double ret = 0.0;
		
		for (Node n : terms)
			ret += n.coefficient * Math.pow(value, n.exponent);
		
		return ret;
	}

	// finds the derivative of host polynomial: 
	//		Formula: (expo * coef) ^ (expo-1)
	public Polynomial derivative() { 
		
		ArrayList<Double> co = new ArrayList<Double>();
		ArrayList<Integer> ex = new ArrayList<Integer>();
		
		for (Node n : terms) {
			if (n.exponent > 0) {
				co.add(n.coefficient * n.exponent);
				ex.add(n.exponent-1);
				
			}
		}
		
		return new Polynomial(co, ex);
	}

	//====================================================== toString
	public String toString() {
		Collections.sort(terms);
		StringBuilder ret = new StringBuilder();
		for(Node n : terms)			
			ret.append( n.toString() );
		if(ret.length() == 0) return "0.0";
		ret.deleteCharAt(2);
		if(ret.charAt(1) == '+') 	ret.deleteCharAt(1);
		return ret.toString().trim();	
	}
}

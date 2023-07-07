import java.io.File;
import java.util.Scanner;

public class Tester {

	static LinkedListStack<Athlete> athletes = new LinkedListStack<Athlete>();
	
	public static void main(String[] args) {
		loadAthletes("Athletes.txt");
		
//		System.out.println(athletes.peek());	// should print Mabelle Spreadbury's record
//		System.out.println(athletes.pop());		// should print Mabelle Spreadbury's record
//		System.out.println(athletes.pop()); 	// should print Annabela Ferrini's record
//		System.out.println(athletes.get(10));	// should print Curr Mervyn's record

		System.out.println(athletes.get(1));
		System.out.println(athletes.get(2));

		System.out.println("\n=========================================================== Reverse Stack\n");
		athletes.reverseStack();
		
		System.out.println(athletes.get(1));
		System.out.println(athletes.get(2));
		
//		System.out.println(athletes.peek());	// should print Mabelle Spreadbury's record
//		System.out.println(athletes.pop());		// should print Mabelle Spreadbury's record
//		System.out.println(athletes.pop()); 	// should print Annabela Ferrini's record
//		System.out.println(athletes.get(10));	// should print Curr Mervyn's record
//		
//		System.out.println(athletes.peek());	// should print Jaquenetta Finlayson's record
//		System.out.println(athletes.pop());		// should print Jaquenetta Finlayson's record
//		System.out.println(athletes.pop()); 	// should print Madonna Edgler's record
//		System.out.println(athletes.get(10));	// should print Christen Rylstone's record
	}
	
	// This method is complete - you do not need to modify
	public static void loadAthletes(String fileName) {
		// open file and read in all records
		try(Scanner fin = new Scanner(new File(fileName))) {
			fin.nextLine();						// read off the header line
			while(fin.hasNextLine())
				athletes.push(new Athlete(fin)); 	// adds a new athlete to the stack
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

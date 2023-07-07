

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;



public class Tester {

	private static DoublyLinkedCollectionIteration<Student> students = new DoublyLinkedCollectionIteration<>();
	private static ArrayList<Student> alStudents = new ArrayList<>();

	
	public static void main(String[] args) {
		loadData();
		Collections.sort(alStudents);
		
		System.out.println("\n====================================== Class Average");
		System.out.println(getTotalAverage());
		
		System.out.println("\n====================================== Top10()");
		showTop10();

		System.out.println("\n====================================== BottomTop10()");
		showBottom10();
	}
	
	public static void loadData() {
		try (Scanner fin = new Scanner(new File("StudentData.txt"))){
			fin.nextLine();
			while(fin.hasNextLine()) {
				Student s = new Student(fin.nextLine());
				students.add(s);
				alStudents.add(s);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static double getTotalAverage() {
		double sum = 0;
		for(Student s : students)
			sum += s.average();
		return sum / students.size();
	}
	
	public static void showTop10() {
		
		Collections.sort(alStudents, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int)(o2.average()*100) - (int)(o1.average()*100);
			}		
		} );
		
		int i = 0;
		for(Student s : alStudents) {
			System.out.println(s);
			if(++i == 10) break;
		}
		
			
	}
	
	public static void showBottom10() {
		
		Collections.sort(alStudents, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int)(o1.average()*100) - (int)(o2.average()*100);
			}		
		} );
		
		int i = 0;
		for(Student s : alStudents) {
			System.out.println(s);
			if(++i == 10) break;
		}
		
	}

}

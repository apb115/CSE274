
public class Student implements Comparable<Student> {
	
	private String name;
	private int actScore;
	private boolean legacy;
	
	public Student(String name, int actScore, boolean legacy) {
		super();
		this.name = name;
		this.actScore = actScore;
		this.legacy = legacy;
	}
	
	private int rankScore() {
		return actScore + (legacy ? 1 : 0);
	}

	@Override
	public int compareTo(Student o) {
		if (rankScore() != o.rankScore())
			return o.rankScore() - rankScore();
	
		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		return String.format(name, null);
	}
	

}

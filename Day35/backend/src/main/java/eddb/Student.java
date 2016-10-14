package eddb;

public class Student {
	int id;
	String first_name;
	String last_name;
	/**
	 * 
	 */
	int SAT;
	public Student(String first_name, String last_name, int sAT, double gpa) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		SAT = sAT;
		this.gpa = gpa;
	}
	double gpa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}

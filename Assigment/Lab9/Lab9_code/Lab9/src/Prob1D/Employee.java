package Prob1D;

public class Employee {
	private String name;
	private int salary;
	private boolean visited = false;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public void setVisited(boolean b) {
		visited = b;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "(" + name + ", " + salary + ")";
	}

	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Employee)) return false;
		Employee emp = (Employee)ob;
		return emp.name.equals(name) && emp.salary == salary; // Bỏ emp.visited
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + salary;
		return result;
	}
}

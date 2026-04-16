package lab10_2b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	
	public void sort(List<Employee> emps, final SortMethod method) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				if (method == SortMethod.BYNAME) {
					// First compare by name
					int nameCompare = e1.name.compareTo(e2.name);
					if (nameCompare != 0) return nameCompare;

					// Tie-break with salary to ensure consistency with equals
					return Integer.compare(e1.salary, e2.salary);
				} else {
					// First compare by salary
					if (e1.salary < e2.salary) return -1;
					if (e1.salary > e2.salary) return 1;

					// Tie-break with name if salaries are identical
					return e1.name.compareTo(e2.name);
				}
			}
		}
		Collections.sort(emps, new EmployeeComparator());
	}
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfo ei = new EmployeeInfo();
		ei.sort(emps, SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, SortMethod.BYSALARY);
		System.out.println(emps);
	}
}

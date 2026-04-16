package lab10_2c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	public void sort(List<Employee> emps, SortMethod method) {
		Collections.sort(emps, (e1, e2) -> {
			if (method == SortMethod.BYNAME) {
				// Primary check: Name
				int nameCompare = e1.name.compareTo(e2.name);

				// If names are different, return the result
				if (nameCompare != 0) return nameCompare;

				// If names are the same, tie-break with salary to be consistent with equals
				return Integer.compare(e1.salary, e2.salary);
			} else {
				// Primary check: Salary
				if (e1.salary != e2.salary) {
					return e1.salary < e2.salary ? -1 : 1;
				}

				// If salaries are the same, tie-break with name
				return e1.name.compareTo(e2.name);
			}
		});
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

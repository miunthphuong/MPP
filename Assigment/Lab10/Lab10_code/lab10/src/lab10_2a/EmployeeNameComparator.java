package lab10_2a;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
//	@Override
//	public int compare(Employee e1, Employee e2) {
//		return e1.name.compareTo(e2.name);
//	}

	@Override
	public int compare(Employee e1, Employee e2) {
		// First, compare by name
		int nameCompare = e1.name.compareTo(e2.name);

		// If names are different, return the result
		if (nameCompare != 0) {
			return nameCompare;
		}

		// If names are the same, tie-break with salary to be consistent with equals
		if (e1.salary < e2.salary) return -1;
		if (e1.salary > e2.salary) return 1;
		return 0;
	}
}

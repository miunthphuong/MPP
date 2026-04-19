package prob2;
import java.util.*;

public class GroupUtil {

	// The public method that uses the wildcard
	public static Group<?> copy(Group<?> group) {
		return copyHelper(group);
	}

	// The private helper method that "captures" the wildcard type into T
	private static <T> Group<T> copyHelper(Group<T> group) {
		T special = group.getSpecialElement();
		List<T> elements = group.getElements();
		return new Group<T>(special, elements);
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);
		Group<Integer> group = new Group<>(0, list);
		System.out.println("Original: " + group);

		// Now this will compile and run successfully
		System.out.println("Copy: " + GroupUtil.copy(group));
	}
}
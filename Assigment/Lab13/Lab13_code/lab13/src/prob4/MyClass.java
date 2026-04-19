package prob4;

import java.util.List;

public class MyClass {

    public static <T extends Comparable<? super T>> T secondSmallest(List<? extends T> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements.");
        }

        T smallest = null;
        T secondSmallest = null;

        for (T element : list) {
            if (smallest == null || element.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = element;
            } else if (secondSmallest == null || element.compareTo(secondSmallest) < 0) {
                // Check to ensure we don't count the exact same 'smallest' value twice
                // if the list contains duplicates (optional depending on requirements)
                if (!element.equals(smallest)) {
                    secondSmallest = element;
                }
            }
        }

        if (secondSmallest == null) {
            throw new IllegalArgumentException("No second smallest element found (all elements might be equal).");
        }

        return secondSmallest;
    }
}
package prob4;

import java.util.*;

public class Main {

    /**
     * Finds the second smallest element in a list.
     * Uses <T extends Comparable<? super T>> to ensure the types can be compared.
     */
    public static <T extends Comparable<? super T>> T secondSmallest(List<? extends T> list) {
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two elements.");
        }

        T smallest = null;
        T secondSmallest = null;

        for (T element : list) {
            // Logic 1: If element is smaller than current smallest
            if (smallest == null || element.compareTo(smallest) < 0) {
                secondSmallest = smallest;
                smallest = element;
            }
            // Logic 2: If element is between smallest and secondSmallest
            else if (secondSmallest == null || element.compareTo(secondSmallest) < 0) {
                if (!element.equals(smallest)) {
                    secondSmallest = element;
                }
            }
        }

        if (secondSmallest == null) {
            throw new IllegalArgumentException("No second smallest element found.");
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        // --- Test Case 1: Integers ---
        List<Integer> ints = Arrays.asList(5, 1, 9, 3, 2);
        System.out.println("Second smallest Integer: " + secondSmallest(ints)); // Expected: 2

        // --- Test Case 2: Strings ---
        // Comparison is based on alphabetical order (Unicode values)
        List<String> strings = Arrays.asList("banana", "apple", "cherry", "date");
        System.out.println("Second smallest String: " + secondSmallest(strings)); // Expected: banana
    }
}
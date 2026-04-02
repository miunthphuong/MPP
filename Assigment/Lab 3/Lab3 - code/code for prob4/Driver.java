package prob1;

import java.util.*;

public class Driver {
	public static void main(String[] args) {

		List<Property> properties = new ArrayList<>();

		properties.add(new House(
				new Address("123 Main", "Fairfield", "IA", "52556"), 2000));

		properties.add(new Condo(
				new Address("456 Oak", "Fairfield", "IA", "52556"), 2));

		properties.add(new Trailer(
				new Address("789 Pine", "Chicago", "IL", "60601")));

		double totalRent = Admin.computeTotalRent(properties);
		System.out.println("Total Rent = " + totalRent);

		System.out.println("\nProperties in Fairfield:");
		Admin.listByCity(properties, "Fairfield");
	}
}
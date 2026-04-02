package prob1;

import java.util.List;

public class Admin {

	public static double computeTotalRent(List<Property> properties) {
		double total = 0;
		for (Property p : properties) {
			total += p.computeRent(); // ✅ polymorphism here
		}
		return total;
	}

	public static void listByCity(List<Property> properties, String city) {
		for (Property p : properties) {
			if (p.getAddress().getCity().equalsIgnoreCase(city)) {
				System.out.println(p.getAddress());
			}
		}
	}
}
package lesson5.labs.prob1.rulesets;

import java.awt.Component;

import lesson5.labs.prob1.gui.*;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	@Override
	public void applyRules(Component ob) throws RuleException {
		BookWindow res = (BookWindow) ob;
		String isbn = res.getIsbnValue().trim();
		String title = res.getTitleValue().trim();
		String price = res.getPriceValue().trim();

		// Rule 1: Non-empty
		if (isbn.isEmpty() || title.isEmpty() || price.isEmpty()) {
			throw new RuleException("All fields must be non-empty");
		}
		// Rule 2 & 3 & 4: ISBN checks
		if (!isbn.matches("\\d+")) throw new RuleException("ISBN must be numeric");
		if (isbn.length() == 10) {
			if (!isbn.startsWith("0") && !isbn.startsWith("1"))
				throw new RuleException("10-digit ISBN must start with 0 or 1");
		} else if (isbn.length() == 13) {
			if (!isbn.startsWith("978") && !isbn.startsWith("979"))
				throw new RuleException("13-digit ISBN must start with 978 or 979");
		} else {
			throw new RuleException("ISBN must be 10 or 13 characters");
		}
		// Rule 5 & 6: Price checks
		validatePrice(price);
	}

	private void validatePrice(String price) throws RuleException {
		try {
			double val = Double.parseDouble(price);
			if (val <= 0.49) throw new RuleException("Price must be > 0.49");
			if (!price.contains(".") || price.split("\\.")[1].length() != 2)
				throw new RuleException("Price must have exactly two decimal places");
		} catch (NumberFormatException e) {
			throw new RuleException("Price must be a valid number");
		}
	}
}

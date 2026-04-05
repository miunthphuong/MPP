package lesson5.labs.prob1.rulesets;

import java.awt.Component;

import lesson5.labs.prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {
	@Override
	public void applyRules(Component ob) throws RuleException {
		CDWindow res = (CDWindow) ob;
		String artist = res.getArtistValue().trim();
		String title = res.getTitleValue().trim();
		String price = res.getPriceValue().trim();

		if (artist.isEmpty() || title.isEmpty() || price.isEmpty()) {
			throw new RuleException("All fields must be non-empty");
		}

		// Reuse price logic or implement similarly:
		try {
			double val = Double.parseDouble(price);
			if (val <= 0.49) throw new RuleException("Price must be > 0.49");
			// Check for two decimal places
			int decimalPos = price.indexOf(".");
			if (decimalPos == -1 || price.length() - decimalPos - 1 != 2)
				throw new RuleException("Price must have two decimal places");
		} catch (NumberFormatException e) {
			throw new RuleException("Price must be a floating point number");
		}
	}
}

import java.awt.Component;

public class BookRuleSet implements RuleSet {
    @Override
    public void applyRules(Component ob) throws RuleException {
        BookWindow win = (BookWindow) ob;

        String isbn = win.getIsbnValue().trim();
        String title = win.getTitleValue().trim();
        String price = win.getPriceValue().trim();

        // Rule A: All fields must be nonempty
        if (isbn.isEmpty() || title.isEmpty() || price.isEmpty()) {
            throw new RuleException("All fields must be nonempty");
        }

        // Rule B, C, D: ISBN Validation
        validateIsbn(isbn);

        // Rule E, F: Price Validation
        validatePrice(price);
    }

    private void validateIsbn(String isbn) throws RuleException {
        // Rule B: Isbn must be numeric
        if (!isbn.matches("\\d+")) {
            throw new RuleException("Isbn must be numeric");
        }

        int len = isbn.length();
        if (len == 10) {
            // Rule C: If Isbn has length 10, the first digit must be 0 or 1
            if (!isbn.startsWith("0") && !isbn.startsWith("1")) {
                throw new RuleException("10-digit Isbn must start with 0 or 1");
            }
        } else if (len == 13) {
            // Rule D: If Isbn has length 13, the first 3 digits must be either 978 or 979
            if (!isbn.startsWith("978") && !isbn.startsWith("979")) {
                throw new RuleException("13-digit Isbn must start with 978 or 979");
            }
        } else {
            // Rule B (cont): consist of either 10 or 13 characters
            throw new RuleException("Isbn must consist of either 10 or 13 characters");
        }
    }

    private void validatePrice(String price) throws RuleException {
        try {
            double p = Double.parseDouble(price);

            // Rule E: Price must be a floating point number with two decimal places
            // Regex: one or more digits, a dot, and exactly two digits
            if (!price.matches("\\d+\\.\\d{2}")) {
                throw new RuleException("Price must be a floating point number with two decimal places");
            }

            // Rule F: Price must be a number greater than 0.49
            if (p <= 0.49) {
                throw new RuleException("Price must be a number greater than 0.49");
            }
        } catch (NumberFormatException e) {
            throw new RuleException("Price must be a valid numeric value");
        }
    }
}
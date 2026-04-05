import java.awt.*;

public class CDRuleSet implements RuleSet {
    @Override
    public void applyRules(Component ob) throws RuleException {
        CDWindow win = (CDWindow) ob;
        String price = win.getPriceValue().trim();

        validatePrice(price);
    }

    private void validatePrice(String price) throws RuleException {
        try {
            double p = Double.parseDouble(price);
            if (p <= 0.49) throw new RuleException("Price must be greater than 0.49");
            if (!price.matches("\\d+\\.\\d{2}"))
                throw new RuleException("Price must be a floating point number with two decimal places");
        } catch (NumberFormatException e) {
            throw new RuleException("Price must be a valid number");
        }
    }
}
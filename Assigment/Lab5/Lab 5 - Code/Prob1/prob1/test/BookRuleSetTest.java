package lesson5.labs.prob1.test;

import lesson5.labs.prob1.rulesets.BookRuleSet;
import lesson5.labs.prob1.rulesets.RuleException;
import org.junit.Before;
import org.junit.Test;
import lesson5.labs.prob1.gui.BookWindow;

public class BookRuleSetTest {
    private BookRuleSet ruleSet;
    private MockBookWindow mockWindow;

    @Before
    public void setUp() {
        ruleSet = new BookRuleSet();
        mockWindow = new MockBookWindow();
    }

    // --- HAPPY CASES ---
    @Test
    public void testValid10DigitIsbn() throws RuleException {
        mockWindow.setValues("0123456789", "Java Programming", "29.99");
        ruleSet.applyRules(mockWindow); // Should pass
    }

    @Test
    public void testValid13DigitIsbn() throws RuleException {
        mockWindow.setValues("9781234567890", "Software Design", "50.00");
        ruleSet.applyRules(mockWindow); // Should pass
    }

    // --- UNHAPPY CASES ---

    // Rule 1: Non-empty
    @Test(expected = RuleException.class)
    public void testEmptyFields() throws RuleException {
        mockWindow.setValues("", "", "");
        ruleSet.applyRules(mockWindow);
    }

    // Rule 2: Numeric and Length
    @Test(expected = RuleException.class)
    public void testNonNumericIsbn() throws RuleException {
        mockWindow.setValues("012345678X", "Title", "10.00");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testInvalidIsbnLength() throws RuleException {
        mockWindow.setValues("123456789", "Title", "10.00"); // 9 digits
        ruleSet.applyRules(mockWindow);
    }

    // Rule 3: 10-digit start
    @Test(expected = RuleException.class)
    public void testInvalid10DigitStart() throws RuleException {
        mockWindow.setValues("5123456789", "Title", "10.00");
        ruleSet.applyRules(mockWindow);
    }

    // Rule 4: 13-digit start
    @Test(expected = RuleException.class)
    public void testInvalid13DigitStart() throws RuleException {
        mockWindow.setValues("9771234567890", "Title", "10.00");
        ruleSet.applyRules(mockWindow);
    }

    // Rule 5: Two decimal places
    @Test(expected = RuleException.class)
    public void testInvalidPriceDecimal() throws RuleException {
        mockWindow.setValues("0123456789", "Title", "10.5");
        ruleSet.applyRules(mockWindow);
    }

    // Rule 6: Minimum price
    @Test(expected = RuleException.class)
    public void testPriceTooLow() throws RuleException {
        mockWindow.setValues("0123456789", "Title", "0.45");
        ruleSet.applyRules(mockWindow);
    }

    // Mock Class to simulate the GUI Window
    private static class MockBookWindow extends BookWindow {
        private String isbn, title, price;
        public void setValues(String i, String t, String p) {
            this.isbn = i; this.title = t; this.price = p;
        }
        @Override public String getIsbnValue() { return isbn; }
        @Override public String getTitleValue() { return title; }
        @Override public String getPriceValue() { return price; }
    }
}

import org.junit.Before;
import org.junit.Test;

public class BookRuleSetTest {
    private BookRuleSet ruleSet;
    private MockBookWindow mockWindow;

    @Before
    public void setUp() {
        ruleSet = new BookRuleSet();
        mockWindow = new MockBookWindow();
    }

    // ======================================================
    // RULE A: NON-EMPTY FIELDS
    // ======================================================
    @Test(expected = RuleException.class)
    public void testIsbnEmpty() throws RuleException {
        mockWindow.setValues("", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testTitleEmpty() throws RuleException {
        mockWindow.setValues("0123456789", "", "29.99");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testPriceEmpty() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "");
        ruleSet.applyRules(mockWindow);
    }

    // ======================================================
    // RULE B: ISBN NUMERIC & LENGTH (10 or 13)
    // ======================================================
    @Test(expected = RuleException.class)
    public void testIsbnContainsLetters() throws RuleException {
        mockWindow.setValues("012345678X", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testIsbnTooShort() throws RuleException {
        mockWindow.setValues("012345678", "Java Basics", "29.99"); // 9 chars
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testIsbnInBetweenLength() throws RuleException {
        mockWindow.setValues("012345678912", "Java Basics", "29.99"); // 12 chars
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testIsbnTooLong() throws RuleException {
        mockWindow.setValues("97801234567890", "Java Basics", "29.99"); // 14 chars
        ruleSet.applyRules(mockWindow);
    }

    // ======================================================
    // RULE C: 10-DIGIT ISBN (Starts with 0 or 1)
    // ======================================================
    @Test(expected = RuleException.class)
    public void test10DigitStartsByTwo() throws RuleException {
        mockWindow.setValues("2123456789", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow);
    }

    @Test
    public void test10DigitStartsByZero() throws RuleException {
        mockWindow.setValues("0987654321", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow); // Success
    }

    @Test
    public void test10DigitStartsByOne() throws RuleException {
        mockWindow.setValues("1987654321", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow); // Success
    }

    // ======================================================
    // RULE D: 13-DIGIT ISBN (Starts with 978 or 979)
    // ======================================================
    @Test(expected = RuleException.class)
    public void test13DigitStartsWrong() throws RuleException {
        mockWindow.setValues("9771234567890", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow);
    }

    @Test
    public void test13DigitValid978() throws RuleException {
        mockWindow.setValues("9781234567890", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow); // Success
    }

    @Test
    public void test13DigitValid979() throws RuleException {
        mockWindow.setValues("9791234567890", "Java Basics", "29.99");
        ruleSet.applyRules(mockWindow); // Success
    }

    // ======================================================
    // RULE E: PRICE DECIMAL PLACES (Exactly 2)
    // ======================================================
    @Test(expected = RuleException.class)
    public void testPriceOneDecimal() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "29.9");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testPriceThreeDecimals() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "29.999");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testPriceNoDecimalPoint() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "30");
        ruleSet.applyRules(mockWindow);
    }

    // ======================================================
    // RULE F: PRICE VALUE (> 0.49)
    // ======================================================
    @Test(expected = RuleException.class)
    public void testPriceExactlyZeroPointFortyNine() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "0.49");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testPriceNegative() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "-1.00");
        ruleSet.applyRules(mockWindow);
    }

    @Test
    public void testPriceMinimumValid() throws RuleException {
        mockWindow.setValues("0123456789", "Java Basics", "0.50");
        ruleSet.applyRules(mockWindow); // Success (0.50 > 0.49)
    }

    // ======================================================
    // HELPER MOCK CLASS
    // ======================================================
    private class MockBookWindow extends BookWindow {
        private String isbn, title, price;
        public void setValues(String i, String t, String p) {
            this.isbn = i; this.title = t; this.price = p;
        }
        @Override public String getIsbnValue() { return isbn; }
        @Override public String getTitleValue() { return title; }
        @Override public String getPriceValue() { return price; }
    }
}
package lesson5.labs.prob1.test;

import lesson5.labs.prob1.rulesets.CDRuleSet;
import lesson5.labs.prob1.rulesets.RuleException;
import lesson5.labs.prob1.gui.CDWindow;
import org.junit.Before;
import org.junit.Test;

public class CDRuleSetTest {
    private CDRuleSet ruleSet;
    private MockCDWindow mockWindow;

    @Before
    public void setUp() {
        ruleSet = new CDRuleSet();
        mockWindow = new MockCDWindow();
    }

    // --- HAPPY CASES ---
    @Test
    public void testValidCD() throws RuleException {
        mockWindow.setValues("The Beatles", "Abbey Road", "15.50");
        ruleSet.applyRules(mockWindow); // Should pass
    }

    // --- UNHAPPY CASES ---

    // Rule 1: Non-empty
    @Test(expected = RuleException.class)
    public void testArtistEmpty() throws RuleException {
        mockWindow.setValues("", "Greatest Hits", "10.00");
        ruleSet.applyRules(mockWindow);
    }

    // Rule 2: Floating point format
    @Test(expected = RuleException.class)
    public void testPriceNoDecimal() throws RuleException {
        mockWindow.setValues("Adele", "21", "20");
        ruleSet.applyRules(mockWindow);
    }

    @Test(expected = RuleException.class)
    public void testPriceInvalidChars() throws RuleException {
        mockWindow.setValues("Adele", "21", "12.ab");
        ruleSet.applyRules(mockWindow);
    }

    // Rule 3: Minimum value
    @Test(expected = RuleException.class)
    public void testPriceBelowThreshold() throws RuleException {
        mockWindow.setValues("Adele", "21", "0.49");
        ruleSet.applyRules(mockWindow);
    }

    // Mock Class to simulate the GUI Window
    private class MockCDWindow extends CDWindow {
        private String artist, title, price;
        public void setValues(String a, String t, String p) {
            this.artist = a; this.title = t; this.price = p;
        }
        @Override public String getArtistValue() { return artist; }
        @Override public String getTitleValue() { return title; }
        @Override public String getPriceValue() { return price; }
    }
}
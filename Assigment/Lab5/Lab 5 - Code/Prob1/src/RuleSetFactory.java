import java.awt.Component;
import java.util.HashMap;

public class RuleSetFactory {
    private static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();

    static {
        map.put(BookWindow.class, new BookRuleSet());
        map.put(CDWindow.class, new CDRuleSet());
    }

    public static RuleSet getRuleSet(Component c) {
        Class<? extends Component> cl = c.getClass();
        if (!map.containsKey(cl)) {
            throw new IllegalArgumentException("No RuleSet found for this Component.");
        }
        return map.get(cl);
    }
}
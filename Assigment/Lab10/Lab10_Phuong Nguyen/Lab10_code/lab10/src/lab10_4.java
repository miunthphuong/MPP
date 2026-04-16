import java.util.List;

public class lab10_4 {

    public int countWords(List<String> words, char c, char d, int len) {
        int count = 0;

        // Convert characters to Strings for easier comparison if needed,
        // or use String.indexOf() for efficiency.
        String charC = String.valueOf(c);
        String charD = String.valueOf(d);

        for (String word : words) {
            // Condition 1: Length is equal to len
            // Condition 2: Contains character c
            // Condition 3: Does NOT contain character d
            if (word.length() == len && word.contains(charC) && !word.contains(charD)) {
                count++;
            }
        }

        return count;
    }

    public int countWords_java8plus(List<String> words, char c, char d, int len) {
        String charC = String.valueOf(c);
        String charD = String.valueOf(d);

        return (int) words.stream()
                .filter(w -> w.length() == len)
                .filter(w -> w.contains(charC))
                .filter(w -> !w.contains(charD))
                .count();
    }
}
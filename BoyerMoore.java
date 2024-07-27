import java.util.HashMap;

public class BoyerMoore {
    
    private void badCharHeuristic(String pattern, HashMap<Character, Integer> badCharacter) {
        int patternLength = pattern.length();
        for (int i = 0; i < patternLength - 1; ++i) {
            badCharacter.put(pattern.charAt(i), patternLength - 1 - i);
        }
    }
    
    public void boyermoore(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        HashMap<Character, Integer> badCharacter = new HashMap<>();
        badCharHeuristic(pattern, badCharacter);
        
        int idx = 0; // idx defines how much pattern is shifted
        while (idx <= (n - m)) {
            int j = m - 1;
            
            // Reducing j of pattern until we get a mismatch character, at this shift idx
            while (j >= 0 && pattern.charAt(j) == text.charAt(idx + j)) {
                j--;
            }
            
            // If j is -1, it means the pattern is found at the current shift
            if (j < 0) {
                System.out.println("Pattern found at shift = " + idx);
                
                // Shift the pattern to align the next character in text with the last occurrence of it in the pattern
                idx += (idx + m < n) ? m - badCharacter.getOrDefault(text.charAt(idx + m), m) : 1;
            } else {
                // Shift the pattern to align the next character in text with the last occurrence of it in the pattern
                idx += Math.max(1, j - badCharacter.getOrDefault(text.charAt(idx + j), m));
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCGEFGHIJKFBCGH";
        String pattern = "FBCGH";
        BoyerMoore bm = new BoyerMoore();
        bm.boyermoore(text, pattern);
    }
}

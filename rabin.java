class Solution {
    private int primeNo = 37;

    public String longestDupSubstring(String s) {
        int start = 1; // Start from 1 to handle edge cases
        int end = s.length() - 1;
        String ans = "";

        while (start <= end) { // Change condition to <= to cover all lengths
            int mid = start + (end - start) / 2;
            String str = findSubstring(mid, s);
            if (str != null) {
                ans = str;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public String findSubstring(int length, String s) {
        HashSet<Long> hs = new HashSet<>();
        long hash = findHash(length, s);
        hs.add(hash);

        long pow = 1;
        for (int i = 1; i < length; i++) {
            pow = pow * primeNo;
        }

        for (int i = 1; i <= s.length() - length; i++) {
            hash = findNewHash(pow, hash, s.charAt(i - 1), s.charAt(i + length - 1));
            if (hs.contains(hash)) {
                return s.substring(i, i + length);
            }
            hs.add(hash);
        }
        return null;
    }

    public long findNewHash(long pow, long hash, char oldChar, char newChar) {
        hash = hash - oldChar * pow;
        hash = hash * primeNo;
        hash = hash + newChar;
        return hash;
    }

    public long findHash(int length, String s) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = hash * primeNo + s.charAt(i);
        }
        return hash;
    }
}
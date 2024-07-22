class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int val = (n + 1) / 2;
        int count = 0;
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < val; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                val1 = i;
                val2 = n - i - 1;
                count++;
                break;
            }
        }
        if (count == 0) {
            return true;
        }

        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(s);
        str1.deleteCharAt(val1);
        str2.deleteCharAt(val2);
        return isPalindrome(str1) || isPalindrome(str2);
    }

    public boolean isPalindrome(StringBuilder str) {
        int n = str.length();
        int val = (n + 1) / 2;
        for (int i = 0; i < val; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
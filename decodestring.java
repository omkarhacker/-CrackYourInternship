import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            int num = 0;

            // If current character is a digit, calculate the number
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(num);
            } 
            // If '[' is encountered, push the current string onto the stack
            else if (s.charAt(i) == '[') {
                strStack.push(str.toString());
                str = new StringBuilder();
                i++;
            } 
            // If ']' is encountered, decode the current segment
            else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(str);
                }
                str = temp;
                i++;
            } 
            // If a character is encountered, add it to the current string
            else {
                str.append(s.charAt(i));
                i++;
            }
        }

        return str.toString();
    }
}

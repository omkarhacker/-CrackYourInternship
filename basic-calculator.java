import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        s = s.replaceAll(" ", "");
        while (i < s.length()) {
            StringBuilder str = new StringBuilder();
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                str.append(s.charAt(i));
                i++;
            }
            String s1 = str.toString();
            while (!st.isEmpty() && (st.peek().equals("*") || st.peek().equals("/"))) {
                String operator = st.pop();
                String operand = st.pop();
                int val1 = findNumber(operand);
                int val2 = findNumber(s1);
                int val = 0;
                if (operator.equals("*")) {
                    val = val1 * val2;
                } else if (val2 != 0 && operator.equals("/")) {
                    val = val1 / val2;
                }
                System.out.println(val);
                s1 = val + "";
            }
            if(s1.length()>=1){
                st.push(s1);
            }
            
            if (i < s.length() && s.charAt(i) != ' ') {
                st.push(s.charAt(i) + "");
                i++;
            } else {
                i++;
            }
        }
        Stack<String> st2 = new Stack<>();
        while (!st.isEmpty()) {
            st2.push(st.pop());
        }

        int result = 0;
        while (!st2.isEmpty()) {
            String current = st2.pop();
            if (current.equals("+")) {
                result += findNumber(st2.pop());
            } else if (current.equals("-")) {
                result -= findNumber(st2.pop());
            } else {
                result = findNumber(current);
            }
        }

        return result;
    }

    public int findNumber(String str) {
        int val = 0;
        int fact = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            val = fact * (str.charAt(i) - '0') + val;
            fact = fact * 10;
        }
        return val;
    }

    
}

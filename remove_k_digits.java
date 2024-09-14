class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            while (!st.isEmpty() && k > 0 && st.peek() > val) {
                st.pop();
                k--;
            }
            st.push(val);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        System.out.println(str);
        boolean isTrue=true;
        int i=0;
        while(i<str.length()){
            if(isTrue && str.charAt(i)=='0'){
                str.deleteCharAt(i);
            }
            else{
                isTrue=false;
                i++;
            }
        }
        if(str.length()==0){
            str.append('0');
        }
        return str.toString();
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str=tokens[i];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int val1=st.pop();
                int val2=st.pop();
                System.out.println(val1);
                if(str.equals("+")){
                    st.push(val1+val2);
                }
                else if(str.equals("-")){
                    st.push(val2-val1);
                }
                else if(str.equals("*")){
                    st.push(val1*val2);
                }
                else{
                    st.push(val2/val1);
                }
            }
            else{
                int val=0;
                boolean isnegative=false;
                for(int j=0;j<str.length();j++){
                    if(str.charAt(j)=='-'){
                      isnegative=true;
                    }
                    else{
                        val=val*10+str.charAt(j)-'0';
                    }
                }
                if(isnegative){
                    val=val*-1;
                }
                st.push(val);
            }
        }
        return st.pop();
    }
}
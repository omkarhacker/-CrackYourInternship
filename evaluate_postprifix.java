class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch>='0' && ch<='9'){
                st.push(ch-'0');
            }
            else{
                int val1=st.pop();
                int val2=st.pop();
                int ans=0;
               
                if(ch=='+'){
                    ans=val1+val2;
                }
                if(ch=='-'){
                    ans=val2-val1;
                }
                if(ch=='*'){
                    ans=val2*val1;
                }
                if(ch=='/'){
                    ans=val2/val1;
                }
                 //System.out.println(ans);
                st.push((ans));
            }
        }
        return st.pop();
    }
}
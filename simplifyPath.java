class Solution {
    public String simplifyPath(String path) {

        String arr[]=path.split("/");
        for(String str:arr){
            System.out.println(str);
        }
        Stack<String>st=new Stack<>();
        st.push("/");
        for(int i=1;i<arr.length;i++){
            if(arr[i].length()==0){
               if(st.peek()!="/"){
                  //st.push("/");
               }
            }
            else if(arr[i].charAt(0)=='.'){
                if(arr[i].length()==2 && arr[i].charAt(1)=='.'){
                   if(st.peek()!="/"){
                       st.pop();
                       st.pop();
                   }
                }
                else if(arr[i].length()==1){
                    continue;
                }
                else{
                    st.push("/");
                    st.push(arr[i]);
                }
            }
            else{
                st.push("/");
                st.push(arr[i]);
            }
        }
        while(st.peek()=="/" && st.size()>1){
           st.pop();
        }
        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
        StringBuilder str=new StringBuilder(ans);
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)!='/'){
                break;
            }
            else{
                str.deleteCharAt(0);
            }
        }
        str.insert(0,'/');
        return str.toString();
    }
}
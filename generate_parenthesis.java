class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String>li=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        findParenthesis(li,n,0,0,str);
        return li;
    }
    public void findParenthesis(List<String>li,int n,int close,int open,StringBuilder str){
        if(close==n && open==n){
            li.add(str.toString());
            return;
        }
        if(close<n){
            str.append('(');
                findParenthesis(li,n,close+1,open,str);
            str.deleteCharAt(str.length()-1);
        }
        if(open<close){
            str.append(')');
                findParenthesis(li,n,close,open+1,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
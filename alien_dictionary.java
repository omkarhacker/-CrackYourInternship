class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String str1=dict[i];
            String str2=dict[i+1];
            int n1=str1.length();
            int n2=str2.length();
            for(int j=0;j<Math.min(n1,n2);j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }
        Stack<Integer>st=new Stack<>();
        boolean visited[]=new boolean[k];
        for(int i=0;i<k;i++){
            if(!visited[i]){
                findAns(adj,st,i,visited);
            }
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.append((char)(st.pop()+'a'));
        }
        return str.toString();
    }
    public void findAns(ArrayList<ArrayList<Integer>>adj,Stack<Integer>st,int i,boolean visited[]){
        visited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                findAns(adj,st,val,visited);
            }
        }
        st.push(i);
    }
}
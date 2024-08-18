class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
         int n=mat.length;
        ArrayList<String>ans=new ArrayList<>();
        if(mat[0][0]==0 || mat[n-1][n-1]==0){
            ans.add("-1");
            return ans;
        }
        boolean visited[][]=new boolean[n][n];
        StringBuilder str=new StringBuilder();
        visited[0][0]=true;
        findAns(str,mat,ans,0,0,visited);
        return ans;
    }
    public void findAns(StringBuilder str,int mat[][],ArrayList<String>arr,int i,int j,boolean visited[][]){
        if(i==mat.length-1 && j==mat.length-1){
            arr.add(str.toString());
            return;
        }
        if(i+1<mat.length && mat[i+1][j]==1 && !visited[i+1][j]){
            str.append('D');
            visited[i+1][j]=true;
            findAns(str,mat,arr,i+1,j,visited);
            str.deleteCharAt(str.length()-1);
            visited[i+1][j]=false;
        }
        if(j+1<mat.length && mat[i][j+1]==1 && !visited[i][j+1]){
            str.append('R');
            visited[i][j+1]=true;
            findAns(str,mat,arr,i,j+1,visited);
            str.deleteCharAt(str.length()-1);
            visited[i][j+1]=false;
        }
        if(j-1>=0 && mat[i][j-1]==1 && !visited[i][j-1]){
            str.append('L');
            visited[i][j-1]=true;
            findAns(str,mat,arr,i,j-1,visited);
            str.deleteCharAt(str.length()-1);
            visited[i][j-1]=false;
        }
        
        if(i-1>=0 && mat[i-1][j]==1 && !visited[i-1][j]){
            str.append('U');
            visited[i-1][j]=true;
            findAns(str,mat,arr,i-1,j,visited);
            str.deleteCharAt(str.length()-1);
            visited[i-1][j]=false;
        }
        
    }
}
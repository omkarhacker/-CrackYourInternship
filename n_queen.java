class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>>ans=new ArrayList<>();
       char matrix[][]=new char[n][n];
       List<String>li=new ArrayList<>();
       for(int i=0;i<n;i++){
        Arrays.fill(matrix[i],'.');
       }
       findAns(matrix,n,0,ans,li);
       return ans;
    }
    public void findAns(char matrix[][],int n,int i,List<List<String>>ans,List<String>li){
        if(i==n){
            li=new ArrayList<>();
            for(int k=0;k<n;k++){
                StringBuilder str=new StringBuilder();
                for(int l=0;l<n;l++){
                    str.append(matrix[k][l]);
                }
                li.add(str.toString());
            }
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int j=0;j<n;j++){
            if(isTrue(matrix,i,j)){
                matrix[i][j]='Q';
                findAns(matrix,n,i+1,ans,li);
                matrix[i][j]='.';
            }
        }
    }
    public boolean isTrue(char matrix[][],int i,int j){
           for(int k=0;k<i;k++){
              if(matrix[k][j]=='Q'){
                return false;
              }
           }
           int start=i;
           int end=j;
           while(start>=0 && end>=0){
               if(matrix[start][end]=='Q'){
                  return false;
               }
               start--;
               end--;
           }
           int start1=i;
           int end1=j;
           while(start1>=0 && end1<matrix.length){
               if(matrix[start1][end1]=='Q'){
                return false;
               }
               start1--;
               end1++;
           }
           return true;
    }
}
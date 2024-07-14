class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        Set<Integer>column=new HashSet<>();
        Set<Integer>row=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    column.add(j);
                    row.add(i);
                }
            }
        }
        for(Integer it:column){
            for(int i=0;i<n;i++){
                matrix[i][it]=0;
            }
        }
        for(Integer it:row){
            for(int i=0;i<m;i++){
                matrix[it][i]=0;
            }
        }
    }
}
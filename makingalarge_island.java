class Solution {
    // class Node {
    //     int first;
    //     int second;

    //     Node(int first, int second) {
    //         this.first = first;
    //         this.second = second;
    //     }
    // }

    public int largestIsland(int[][] grid) {
        int n=grid.length;
         int arr[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int max=0;
        int index=2;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int val=dfs(index,grid,i,j,arr);
                    max=Math.max(max,val);
                    hm.put(index,val);
                    index++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer>set=new HashSet<>();
                    int count=1;
                    for(int k=0;k<4;k++){
                        int val1=i+arr[k][0];
                        int val2=j+arr[k][1];
                        if(val1>=0 && val2>=0 && val1<n && val2<n && grid[val1][val2]>0){
                            int val=grid[val1][val2];
                            if(!set.contains(val)){
                                count=count+hm.get(val);
                                set.add(val);
                            }
                        }
                    }
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    public int dfs(int index,int grid[][],int i,int j,int arr[][]){
        int n=grid.length;
        if(i<0 || j<0 || i>=n || j>=n || grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=index;
        int val=1;
        for(int k=0;k<4;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            val=val+dfs(index,grid,x,y,arr);
        }
        return val;
    }
}
class Solution
{
    class Node{
        int first;
        int second;
        Node(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        //boolean visited[][]=new boolean[n][m];
        Queue<Node>qu=new LinkedList<>();
        int val=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qu.add(new Node(i,j));
                }
                if(grid[i][j]==1){
                    val++;
                }
            }
        }
        if(val==0 || qu.isEmpty()){
            return 0;
        }
        int arr[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int count=0;
        while(!qu.isEmpty()){
            int size=qu.size();
            count++;
            for(int i=0;i<size;i++){
                Node node=qu.remove();
                int val1=node.first;
                int val2=node.second;
                for(int j=0;j<4;j++){
                    int x=val1+arr[j][0];
                    int y=val2+arr[j][1];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                        grid[x][y]=2;
                        qu.add(new Node(x,y));
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count-1;
    }
}
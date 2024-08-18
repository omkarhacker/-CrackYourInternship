class Solution {
    class Node{
        int first;
        int second;
        Node(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int arr[][]={{-1,0},{1,0},{0,-1},{0,1}};
        boolean visited[][]=new boolean[n][m];
        if(image[sr][sc]==color){
            return image;
        }
        findAns(image,sr,sc,visited,color,arr,image[sr][sc]);
        return image;
    }
    public void findAns(int image[][],int i,int j,boolean visited[][],int color,int arr[][],int val){
        image[i][j]=color;
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            if(x>=0 && y>=0 && x<image.length && y<image[0].length && !visited[x][y] && image[x][y]==val){
                findAns(image,x,y,visited,color,arr,val);
            }
        }
    }
}
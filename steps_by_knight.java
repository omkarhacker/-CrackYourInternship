class Solution
{
    class Node{
        int val1;
        int val2;
        Node(int val1,int val2){
            this.val1=val1;
            this.val2=val2;
        }
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        int arr[][]={{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        boolean visited[][]=new boolean[N][N];
       // return findAns(arr,KnightPos[0]-1,KnightPos[1]-1,TargetPos[0]-1,TargetPos[1]-1,visited);
       int curr0=KnightPos[0]-1;
       int curr1=KnightPos[1]-1;
       int target0=TargetPos[0]-1;
       int target1=TargetPos[1]-1;
       int count=0;
       if(curr0==target0 && curr1==target1){
            return count;
        }
        Queue<Node>qu=new LinkedList<>();
        qu.add(new Node(curr0,curr1));
        while(!qu.isEmpty()){
            int size=qu.size();
             count++;
            for(int j=0;j<size;j++){
                Node node=qu.remove();
            int x=node.val1;
            int y=node.val2;
            for(int i=0;i<arr.length;i++){
            int val1=x+arr[i][0];
            int val2=y+arr[i][1];
            if(val1>=0 && val2>=0 && val1<visited.length && val2<visited.length && !visited[val1][val2]){
                visited[val1][val2]=true;
                if(val1==target0 && val2==target1){
                     return count;
                }
                qu.add(new Node(val1,val2));
            }
        }
            }
        }
        return count;
    }
}
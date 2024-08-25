class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int total=0;
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<n;i++){
            String str=stones[i][0]+" "+stones[i][1];
            if(!hs.contains(str)){
                int size[]=new int[1];
                findDfs(size,stones,hs,stones[i][0],stones[i][1]);
                if(size[0]>=1){
                    total=total+size[0]-1;
                }
            }
        }
        return total;
    }
    public void findDfs(int size[],int stones[][],HashSet<String>hs,int i,int j){
        hs.add(i+" "+j);
        size[0]++;
        for(int k=0;k<stones.length;k++){
            String str=stones[k][0]+" "+stones[k][1];
            if((i==stones[k][0] || j==stones[k][1]) && !hs.contains(str)){
                findDfs(size,stones,hs,stones[k][0],stones[k][1]);
            }
        }
    }
}
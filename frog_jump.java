class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]!=1){
            return false;
        }
        HashMap<String,Boolean>hs=new HashMap<>();
        return findAns(stones,1,1,hs);
    }
    public boolean findAns(int stones[],int i,int pre,HashMap<String,Boolean>hs){
        if(i==stones.length-1){
            return true;
        }
        String str=i+" "+pre;
        if(hs.containsKey(str)){
            return hs.get(str);
        }
        for(int j=i+1;j<stones.length;j++){
            int diff=stones[j]-stones[i];
            if(diff==pre+1 || diff==pre || diff==pre-1){
                if(findAns(stones,j,diff,hs)){
                    hs.put(str,true);
                    return true;
                }
            }
        }
        hs.put(str,false);
        return false;
    }
}
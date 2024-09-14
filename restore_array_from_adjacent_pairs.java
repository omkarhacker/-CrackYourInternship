class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int n = adjacentPairs.length;
        for (int i = 0; i < n; i++) {
            
            if(hm.containsKey(adjacentPairs[i][0])){
                ArrayList<Integer>arr=hm.get(adjacentPairs[i][0]);
                arr.add(adjacentPairs[i][1]);
                hm.put(adjacentPairs[i][0],arr);
            }
            else{
                ArrayList<Integer>arr=new ArrayList<>();
                arr.add(adjacentPairs[i][1]);
                hm.put(adjacentPairs[i][0],arr);
            }
            if(hm.containsKey(adjacentPairs[i][1])){
                ArrayList<Integer>arr=hm.get(adjacentPairs[i][1]);
                arr.add(adjacentPairs[i][0]);
                hm.put(adjacentPairs[i][1],arr);
            }
            else{
                ArrayList<Integer>arr=new ArrayList<>();
                arr.add(adjacentPairs[i][0]);
                hm.put(adjacentPairs[i][1],arr);
            }
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.put(adjacentPairs[i][0], count.getOrDefault(adjacentPairs[i][0], 0) + 1);
            count.put(adjacentPairs[i][1], count.getOrDefault(adjacentPairs[i][1], 0) + 1);
        }
        Set<Integer> hs = count.keySet();
        int val = 0;
        for (Integer it : hs) {
            if (count.get(it) == 1) {
                val = it;
                break;
            }
        }
        HashSet<Integer>visited=new HashSet<>();
        ArrayList<Integer>arr=new ArrayList<>();
        findVal(visited,hm,arr,val);
        int ans[]=new int[arr.size()];
        int i=0;
        for(Integer it:arr){
            ans[i]=it;
            i++;
        }
        return ans;
    }
    public void findVal(HashSet<Integer>hs,HashMap<Integer,ArrayList<Integer>>hm,ArrayList<Integer>arr,int val){
        hs.add(val);
        arr.add(val);
        ArrayList<Integer>arr1=hm.get(val);
        for(Integer it:arr1){
            if(!hs.contains(it)){
                findVal(hs,hm,arr,it);
            }
        }
    }
}
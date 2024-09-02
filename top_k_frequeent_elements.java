class Solution {
    class Node{
        int val;
        int count;
        Node(int val,int count){
            this.val=val;
            this.count=count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        PriorityQueue<Node>pq=new PriorityQueue<>((x,y)->y.count-x.count);
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        Set<Integer>set=hm.keySet();
        for(Integer it:set){
            pq.add(new Node(it,hm.get(it)));
        }
        int i=0;
        while(i<k){
            ans[i]=pq.remove().val;
            i++;
        }
        return ans;
    }
}
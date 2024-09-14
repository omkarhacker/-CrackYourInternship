class Solution {
    public int minDeletions(String s) {
        
        HashMap<Character,Integer>hm=new HashMap<>();
        int sum=0;
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        Set<Character>set=hm.keySet();
        ArrayList<Integer>arr=new ArrayList<>();
       for(Character ch:set){
           arr.add(hm.get(ch));
       }
       Collections.sort(arr,Collections.reverseOrder());
       HashSet<Integer>hs=new HashSet<>();
       for(int i=0;i<arr.size();i++){
            int val=arr.get(i);
            while(hs.contains(val)){
              val--;
            }
            if(val!=0){
                hs.add(val);
            }
       }
       for(Integer it:hs){
        sum=sum+it;
       }
       int  ans=s.length()-sum;
       return ans;
    }
}
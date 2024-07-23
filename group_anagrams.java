class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String st=strs[i];
            char arr[]=st.toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);
            if(hm.containsKey(str)){
                List<String>li=hm.get(str);
                li.add(strs[i]);
                hm.put(str,li);
            }
            else{
                List<String>li=new ArrayList<>();
                li.add(strs[i]);
                hm.put(str,li);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        Set<String>set=hm.keySet();
        for(String s:set){
            ans.add(hm.get(s));
        }
        return ans;
    }
}
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>>li=new ArrayList<>();
        HashMap<String,List<String>>hm=new HashMap<>();
        for(int i=0;i<string_list.length;i++){
            String str=string_list[i];
            char arr[]=str.toCharArray();
            Arrays.sort(arr);
            String newstr=new String(arr);
            if(hm.containsKey(newstr)){
                List<String>x=hm.get(newstr);
                x.add(str);
                hm.put(newstr,x);
            }
            else{
                List<String>x=new ArrayList<>();
                x.add(str);
                hm.put(newstr,x);
            }
        }
        Set<String>set=hm.keySet();
        for(String st:set){
            li.add(hm.get(st));
        }
       // Collections.sort(li);
        return li;
    }
}



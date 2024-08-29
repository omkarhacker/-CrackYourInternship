class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<List<Integer>>hs=new HashSet<>();
        if(n<2){
            return adj;
        }
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder(words[i]);
            str.reverse();
            hm.put(str.toString(), i);
        }
        for(int i=0;i<n;i++){
            String str=words[i];
            for(int j=0;j<=str.length();j++){
                String str1=str.substring(0,j);
                String str2=str.substring(j);
                if(hm.containsKey(str1) && hm.get(str1)!=i && isPalindrome(str2)){
                    List<Integer>li=new ArrayList<>();
                    li.add(i);
                    li.add(hm.get(str1));
                    hs.add(li);
                }
                if(hm.containsKey(str2) && hm.get(str2)!=i && isPalindrome(str1)){
                    List<Integer>li=new ArrayList<>();
                    li.add(hm.get(str2));
                    li.add(i);
                    hs.add(li);
                }
            }
        }
        for(List<Integer>li:hs){
            adj.add(li);
        }
        return adj;
    }
    public boolean isPalindrome(String str){
        int n=str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
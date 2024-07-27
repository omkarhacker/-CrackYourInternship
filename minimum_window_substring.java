class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n){
            return "";
        }
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int total=m;
        int i=0;
        int j=0;
        int ansindex=0;
        int min=Integer.MAX_VALUE;
        while(j<n){
            char ch=s.charAt(j);
            if(hm.containsKey(ch)){
                if(hm.get(ch)>0){
                    total--;
                }
                hm.put(ch,hm.get(ch)-1);
            }
            else{
                hm.put(ch,hm.getOrDefault(ch,-1)-1);
            }
            while(total==0){
                int currWindowSize=j-i+1;
                if(min>currWindowSize){
                    min=currWindowSize;
                    ansindex=i;
                }
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
                if(hm.get(s.charAt(i))>0){
                    total++;
               }
               i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE?"":s.substring(ansindex,ansindex+min);
    }
}
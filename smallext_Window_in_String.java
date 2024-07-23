class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if(p.length()>s.length()){
            return "-1";
        }
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<p.length();i++){
            hm.put(p.charAt(i),hm.getOrDefault(p.charAt(i),0)+1);
        }
        
        int total=p.length();
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int ansindex=0;
        while(j<s.length()){
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
        
        return min==Integer.MAX_VALUE?"-1":s.substring(ansindex,ansindex+min);
        
    }
}
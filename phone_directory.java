class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>>adj=new ArrayList<>();
        for(int i=1;i<=s.length();i++){
            String str=s.substring(0,i);
            HashSet<String> hs = new HashSet<>();
            ArrayList<String>ans=new ArrayList<>();
            for(int j=0;j<n;j++){
                String str1=contact[j];
                if(str1.length()<i){
                    continue;
                }
                    String str2=str1.substring(0,i);
                    if(str.equals(str2)){
                        hs.add(str1);
                    }
            }
            if(hs.size()==0){
                ans.add("0");
            }
            else{
                ans.addAll(hs);
                Collections.sort(ans);
            }
            adj.add(ans);
        }
        return adj;
    }
}
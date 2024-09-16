class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>li=new ArrayList<>();
        findAns(li,ans,s,0);
        return ans;
    }    
    public void findAns(List<String>li,List<List<String>>ans,String s,int i){
        if(i==s.length()){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int j=i;j<s.length();j++){
            String str=s.substring(i,j+1);
            if(isTrue(str)){
                li.add(str);
                findAns(li,ans,s,j+1);
                li.remove(li.size()-1);
            }
        }
    }
    public boolean isTrue(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
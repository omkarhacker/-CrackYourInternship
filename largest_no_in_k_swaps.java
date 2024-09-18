class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            StringBuilder ans=new StringBuilder(str);
            StringBuilder s=new StringBuilder(str);
            findAns(s,k,ans);
            return ans.toString();
        }
        public static void findAns(StringBuilder str,int k,StringBuilder ans){
            if(k==0){
                return;
            }
            for(int j=0;j<str.length()-1;j++){
                char max=str.charAt(j);
                for(int l=j+1;l<str.length();l++){
                    if(str.charAt(l)>max){
                        max=str.charAt(l);
                    }
                }
                 if(max!=str.charAt(j)){
                        for(int l=j+1;l<str.length();l++){
                   if(str.charAt(l)==max){
                        swap(j,l,str);
                    if (str.toString().compareTo(ans.toString()) > 0) {
                    ans.setLength(0);  
                    ans.append(str.toString());
                }
                    findAns(str,k-1,ans);
                    swap(l,j,str);
                   }
                    
                }
                }
                
            }
        }
        public static void swap(int i,int j,StringBuilder str){
            char temp=str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,temp);
        }
}
class Solution {
    public String reverseWords(String s) {
        
        String arr[]=s.split(" ");
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        StringBuilder str=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length()!=0){
              str.append(arr[i]+" ");
            }
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }
}
class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder str=new StringBuilder();
        convertNumber(columnNumber,str);
        str.reverse();
        return str.toString();
    }
    public void convertNumber(int val,StringBuilder str){
        val--;
        if(val/26==0){
            str.append((char)('A'+val));
            return;
        }
        str.append((char)('A'+val%26));
        convertNumber(val/26,str);
    }
}
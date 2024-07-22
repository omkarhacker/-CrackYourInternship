class Solution {
    public String intToRoman(int num) {
        StringBuilder str=new StringBuilder();
        HashMap<Integer,Character>hm=new HashMap<>();
        hm.put(1,'I');
        hm.put(5,'V');
        hm.put(10,'X');
        hm.put(50,'L');
        hm.put(100,'C');
        hm.put(500,'D');
        hm.put(1000,'M');
        
        String string =num+"";
        int n=string.length();
        for(int i=0;i<n;i++){
            int val=string.charAt(i)-'0';
            int newval=val*(int)Math.pow(10,n-i-1);
            int val1=5*(int)Math.pow(10,n-i-1);
            int val2=(int)Math.pow(10,n-i-1);
            if(val<4 && val>1){
                int valz=val;
                while(valz-->0){
                    str.append(hm.get(val2));
                }
            }
            else if(val==5){
                str.append(hm.get(val1));
            }
            else if(val==1){
                str.append(hm.get(val2));
            }
            else if(val>5 && val<9){
                str.append(hm.get(val1));
                int valz=val-5;
                while(valz-->0){
                    str.append(hm.get(val2));
                }
            }
            else if(val==4){
                if(i!=(n-1)){
                    int x=val1-newval;
                    str.append(hm.get(x));
                    str.append(hm.get(val1));
                }
                else{
                    str.append('I');
                    str.append('V');
                }
            }
            else if(val==9){
                if(i!=(n-1)){
                    int x=val2*10-newval;
                    str.append(hm.get(x));
                    str.append(hm.get(val2*10));
                }
                else{
                    str.append('I');
                    str.append('X');
                }
            }
        }
        return str.toString();
    }
}
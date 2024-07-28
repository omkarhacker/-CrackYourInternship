class Solution {
    public String addBinary(String a, String b) {
        
        int n1=a.length();
        int n2=b.length();
        StringBuilder str=new StringBuilder();
        int min=Math.min(n1,n2);
        int remain=0;
        for(int i=0;i<min;i++){
            char ch1=a.charAt(n1-1-i);
            char ch2=b.charAt(n2-1-i);
            if(ch1=='1' && ch2=='1' && remain==1){
                str.append('1');
                remain=1;
            }
            else if(ch1=='1' && ch2=='1' && remain==0){
                str.append('0');
                remain=1;
            }
            else if(ch1=='1' || ch2=='1'){
                if(remain==0){
                    str.append('1');
                    remain=0;
                }
                else{
                    str.append('0');
                    remain=1;
                }
            }
            else{
                if(remain==1){
                    str.append('1');
                    remain=0;
                }
                else{
                    str.append('0');
                    remain=0;
                }
            }
        }
        if(min==n1 && min!=n2){
            for(int i=min;i<n2;i++){
                char ch=b.charAt(n2-1-i);
                if(ch=='1' && remain==1){
                    str.append('0');
                    remain=1;
                }
                else if(ch=='1' && remain==0){
                    str.append('1');
                    remain=0;
                }
                else if(ch=='0'){
                    if(remain==0){
                        str.append('0');
                        remain=0;
                    }
                    else{
                        str.append('1');
                        remain=0;
                    }
                }
            }
        }

        if(min==n2 && n1!=min){
            for(int i=min;i<n1;i++){
                char ch=a.charAt(n1-1-i);
                if(ch=='1' && remain==1){
                    str.append('0');
                    remain=1;
                }
                else if(ch=='1' && remain==0){
                    str.append('1');
                    remain=0;
                }
                else if(ch=='0'){
                    if(remain==0){
                        str.append('0');
                        remain=0;
                    }
                    else{
                        str.append('1');
                        remain=0;
                    }
                }
            }
        }
        if(remain==1){
            str.append('1');
        }
        str.reverse();
        return str.toString();
    }
}
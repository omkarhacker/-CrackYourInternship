import java.util.*;
public class pring_duplicate {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<st.length();i++){
              hm.put(st.charAt(i), hm.getOrDefault(st.charAt(i), 0)+1);
        }
        Set<Character>set=hm.keySet();
        for(Character ch:set){
            if(hm.get(ch)>=2){
                System.out.print(ch+" ");
            }
        }
    }
}

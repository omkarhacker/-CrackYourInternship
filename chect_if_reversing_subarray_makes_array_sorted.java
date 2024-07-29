import java.util.*;
public class chect_if_reversing_subarray_makes_array_sorted {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int newarr[]=new int[n];
        for(int i=0;i<n;i++){
            newarr[i]=arr[i];
        }
        Arrays.sort(newarr);
        int first=0;
        int second=0;
        boolean isfirst=true;
        for(int i=0;i<n;i++){
            if(isfirst && arr[i]!=newarr[i]){
                isfirst=false;
                first=i;
            }
            else if(isfirst==false && arr[i]!=newarr[i]){
                second=i;
            }
        }
        int k=0;
        for(int i=first;i<=second;i++){
            if(arr[i]!=newarr[second-k]){
                System.out.println("NO");
                return;
            }
            k++;
        }
        System.out.println("YES");

    }
}

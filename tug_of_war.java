import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int tugOfWar(ArrayList<Integer> arr, int n) {
		// Write your code here.
		HashSet<Integer>hs=new HashSet<>();
		int sum=0;
		for(Integer it:arr){
			sum=sum+it;
		}
		int ans[]=new int[1];
		ans[0]=Integer.MAX_VALUE;
		if(arr.size()%2==0){
            findAns(ans,sum,arr,0,0,arr.size()/2,hs);
		}
		else{
			findAns(ans,sum,arr,0,0,(arr.size()+1)/2,hs);
		}
		return ans[0];
	}
	public static void findAns(int ans[],int total,ArrayList<Integer>arr,int i,int sum,int count,HashSet<Integer>hs){
		if(count==0){
			int sum2=total-sum;
			int diff=Math.abs(sum-sum2);
			if(diff<ans[0]){
				ans[0]=diff;
			}
			return;
		}
		for(int j=i;j<arr.size();j++){
			hs.add(j);
			findAns(ans,total,arr,j+1,sum+arr.get(j),count-1,hs);
			hs.remove(j);
		}
	}
}
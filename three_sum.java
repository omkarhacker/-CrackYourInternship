import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int val=-nums[i];
            int start=i+1;
            int end=n-1;
            while(start<end){
                int sum=nums[start]+nums[end];
                if(sum==val){
                    List<Integer>li=new ArrayList<>();
                    li.add(nums[start]);
                    li.add(nums[end]);
                    li.add(nums[i]);
                    ans.add(li);
                    while(start<end && nums[start]==nums[start+1]){
                        start++;
                    }
                    while(start<end && nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }
                else if(sum<val){
                    start++;
                }
                else{
                    end--;
                }

            }
        }
        return ans;
    }
}

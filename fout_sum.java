class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int start=j+1;
                int end=n-1;
                while(start<end){
                    long sum=(long)nums[i]+(long)nums[j];
                    long val1=target-sum;
                    long val2=(long)nums[start]+(long)nums[end];
                    if(val1==val2){
                        List<Integer>li=new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[start]);
                        li.add(nums[end]);
                        while(start<end && nums[start]==nums[start+1]){
                            start++;
                        }
                        while(start<end && nums[end]==nums[end-1]){
                            end--;
                        }
                        ans.add(li);
                        start++;
                        end--;
                    }
                    else if(val2<val1){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }
        
        return ans;

    }
}
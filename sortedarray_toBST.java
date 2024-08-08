/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       int n=nums.length;
       return findBST(nums,0,n-1);
    }
    public TreeNode findBST(int nums[],int start,int end){
        if(start>end || start<0 || end>=nums.length){
            return null;
        }
        if(start==end && start<nums.length && start>=0){
            return new TreeNode(nums[start]);
        }
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=findBST(nums,start,mid-1);
        node.right=findBST(nums,mid+1,end);
        return node;
    }
}
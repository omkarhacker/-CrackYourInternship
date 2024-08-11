/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> ans = new ArrayList<>();
        
        return findAns(1, n, ans);
    }

    public List<TreeNode> findAns(int start, int end, List<TreeNode>ans) {
        if (start > end) {
            List<TreeNode>li=new ArrayList<>();
            li.add(null);
            return li;
        }
        if (start == end) {
            List<TreeNode>li=new ArrayList<>();
            li.add(new TreeNode(start));
            return li;
        }
        List<TreeNode>result=new ArrayList<>();
        for(int i=start;i<=end;i++){
            List<TreeNode> left=findAns(start,i-1,ans);
            List<TreeNode> right=findAns(i+1,end,ans);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode node=new TreeNode(i);
                    node.left=left.get(j);
                    node.right=right.get(k);
                    result.add(node);
                }
            }
        }
        return result;
    }
}
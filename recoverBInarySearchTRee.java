class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        TreeNode[] first = new TreeNode[1];
        TreeNode[] second = new TreeNode[1];
        pre[0] = new TreeNode(Integer.MIN_VALUE); // Initialize pre to a node with a very small value
        
        // Find the nodes that are out of order
        findAns(root, pre, first, second);
        
        // Swap the values of the two out-of-order nodes
        if (first[0] != null && second[0] != null) {
            int temp = first[0].val;
            first[0].val = second[0].val;
            second[0].val = temp;
        }
    }

    public void findAns(TreeNode root, TreeNode[] pre, TreeNode[] first, TreeNode[] second) {
        if (root == null) {
            return;
        }
        
        findAns(root.left, pre, first, second);
        
        if (pre[0] != null && root.val < pre[0].val) {
            if (first[0] == null) {
                first[0] = pre[0];
            }
            second[0] = root;
        }
        
        pre[0] = root;
        
        findAns(root.right, pre, first, second);
    }
}

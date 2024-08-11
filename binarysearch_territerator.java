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
class BSTIterator {
    TreeNode root;
    int size;
    int i;
    ArrayList<Integer>adj;
    public BSTIterator(TreeNode root) {
        root=root;
        i=0;
        adj=new ArrayList<>();
        size=0;
        findInorder(adj,root);
        size=adj.size();
    }
    public void findInorder(ArrayList<Integer>adj,TreeNode root){
        if(root==null){
            return ;
        }
        findInorder(adj,root.left);
        adj.add(root.val);
        findInorder(adj,root.right);
    }
    
    public int next() {
        int val=adj.get(i);
        i++;
        return val;
    }
    
    public boolean hasNext() {
        if(i==adj.size()){
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
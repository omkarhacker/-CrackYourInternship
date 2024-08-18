/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        //findAns(root,str);
        Queue<TreeNode>qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode node=qu.remove();
            if(node!=null){
                str.append(node.val+" ");
                qu.add(node.left);
                qu.add(node.right);
            }
            else{
                str.append("null"+" ");
            }
        }
        return str.toString();
    }
    // public void findAns(TreeNode root,StringBuilder str){
    //     if(root==null){
    //         str.append("null"+" ");
    //         return;
    //     }
    //     str.append(root.val+" ");
    //     findAns(root.left,str);
    //     findAns(root.right,str);
    // }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[]=data.split(" ");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println(arr.length);
        if(arr[0].equals("null")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode>qu=new LinkedList<>();
        qu.add(node);
        int val=1;
        while(!qu.isEmpty()){
            TreeNode p=qu.remove();
            if(!arr[val].equals("null")){
                TreeNode x=new TreeNode(Integer.parseInt(arr[val]));
                p.left=x;
                qu.add(x);
            }
            val++;
            if(val<arr.length && !arr[val].equals("null")){
                TreeNode x=new TreeNode(Integer.parseInt(arr[val]));
                p.right=x;
                qu.add(x);
            }
            val++;
        }
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        ArrayList<Node>adj=new ArrayList<>();
        findInorder(root,adj);
        boolean ispre=true;
        boolean issuc=true;
        for(int i=0;i<adj.size();i++){
            if(adj.get(i).data<key && ispre){
                    pre[0]=adj.get(i);
            }
            
            if(adj.get(i).data>key && issuc){
                suc[0]=adj.get(i);
                issuc=false;
            }
        }
    }
    public static void findInorder(Node root,ArrayList<Node>adj){
         if(root==null){
             return ;
         }
         findInorder(root.left,adj);
         adj.add(root);
         findInorder(root.right,adj);
    }
}
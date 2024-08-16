class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca=findLCA(root,a,b);
        int val1[]=new int[1];
        int val2[]=new int[1];
        findVal(lca,a,val1);
        findVal(lca,b,val2);
        return val1[0]+val2[0];
    }
    Node findLCA(Node root,int a,int b){
        if(root==null){
            return null;
        }
        if(root.data==a || root.data==b){
            return root;
        }
        Node left=findLCA(root.left,a,b);
        Node right=findLCA(root.right,a,b);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null?left:right;
    }
    boolean findVal(Node node,int val,int arr[]){
        if(node==null){
            return false;
        }
        if(node.data==val){
            return true;
        }
        boolean left=findVal(node.left,val,arr);
        boolean right=findVal(node.right,val,arr);
        if(left){
            arr[0]++;
        }
        if(right){
            arr[0]++;
        }
        return left||right;
    }
}
static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        return findTree(pre,0,size-1);
    }
    public Node findTree(int pre[],int start,int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return new Node(pre[start]);
        }
        Node node=new Node(pre[start]);
        int val =findIndex(pre,start,end);
        node.left=findTree(pre,start+1,val-1);
        node.right=findTree(pre,val,end);
        return node;
    }
    public int findIndex(int pre[],int start,int end){
        for(int i=start;i<=end;i++){
             if(pre[i]>pre[start]){
                 return i;
             }
        }
        return end+1;
    }
}
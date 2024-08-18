class Solution{
    static class Info{
        int size;
        boolean isTrue;
        int min;
        int max;
        Info(int size,boolean isTrue,int min,int max){
            this.size=size;
            this.isTrue=isTrue;
            this.min=min;
            this.max=max;
        }
    }
    
    static int ans=0;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        ans=0;
        findAns(root);
        return ans;
        
    }
    static Info findAns(Node root){
        if(root==null){
            return new Info(0,true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info left=findAns(root.left);
        Info right=findAns(root.right);
        if(left.isTrue && right.isTrue && left.max<root.data && right.min>root.data){
            ans=Math.max(ans,left.size+right.size+1);
            int min=Math.min(left.min,root.data);
            int max=Math.max(root.data,right.max);
            return new Info(left.size+right.size+1,true,min,max);
        }
        return new Info(0,false,0,0);
    }
    
}
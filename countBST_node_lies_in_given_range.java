class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        int ans[]=new int[1];
        findAns(root,l,h,ans);
        return ans[0];
    }
    void findAns(Node root,int l,int h,int ans[]){
        if(root==null){
            return;
        }
        findAns(root.left,l,h,ans);
        if(root.data>=l && root.data<=h){
            ans[0]++;
        }
        findAns(root.right,l,h,ans);
    }
}

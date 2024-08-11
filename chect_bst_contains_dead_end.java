class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        HashSet<Integer>set=new HashSet<>();
        ArrayList<Integer>leaf=new ArrayList<>();
        findInorder(set,root,leaf);
        for(Integer it:leaf){
            if(it==1 && set.contains(it+1)){
                return true;
            }
            if(it==10001 && set.contains(10000)){
                return true;
            }
            if(set.contains(it-1) && set.contains(it+1)){
                return true;
            }
        }
        return false;
    }
    public static void findInorder(HashSet<Integer>adj,Node root,ArrayList<Integer>leaf){
        if(root==null){
            return;
        }
        findInorder(adj,root.left,leaf);
        adj.add(root.data);
        if(root.left==null && root.right==null){
            leaf.add(root.data);
        }
        findInorder(adj,root.right,leaf);
    }
}
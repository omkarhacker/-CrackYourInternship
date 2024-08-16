class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	    Node temp[]=new Node[1];
	    Node ans[]=new Node[1];
	    findLinkedList(temp,root,ans);
	   
	    return ans[0];
    }
    void findLinkedList(Node x[],Node root,Node ans[]){
        if(root==null){
            return;
        }
        findLinkedList(x,root.left,ans);
        Node val=new Node(root.data);
        if(x[0]==null){
            ans[0]=val;
        }
        else{
            x[0].right=val;
            val.left=x[0];
        }
        x[0]=val;
        findLinkedList(x,root.right,ans);
    }
}
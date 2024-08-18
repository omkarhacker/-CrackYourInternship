class Solution{
    int index=0;
    Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	    index=0;
	    return findAns(pre,preLN);
	    
    }
    Node findAns(int pre[],char preLN[]){
        if(index>=pre.length){
            return null;
        }
        Node node=new Node(pre[index]);
        if(preLN[index]=='L'){
            index++;
            return node;
        }
        
        index++;
        node.left=findAns(pre,preLN);
        node.right=findAns(pre,preLN);
        return node;
    }
}
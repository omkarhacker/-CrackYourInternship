class Solution {
    static class Node{
        int val;
        char ch;
        Node(int val,char ch){
            this.val=val;
            this.ch=ch;
        }
    }
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        // code here
        PriorityQueue<Node>pq=new PriorityQueue<>((x,y)->{
            if(x.val==y.val){
                return x.ch-y.ch;
            }
            else{
                return y.val-x.val;
            }
        });
        for(int i=0;i<X.length;i++){
            pq.add(new Node(X[i],'X'));
        }
        for(int i=0;i<Y.length;i++){
            pq.add(new Node(Y[i],'Y'));
        }
        int hor=1;
        int ver=1;
        int total=0;
        while(!pq.isEmpty()){
            Node node=pq.remove();
            int val=node.val;
            char ch=node.ch;
            if(ch=='X'){
                total=total+val*hor;
                ver++;
            }
            else{
                total=total+val*ver;
                hor++;
            }
        }
        return total;
    }
}
      
class Tree
{
    public static float findMedian(Node root)
    {
        // code here.
       ArrayList<Integer>arr=new ArrayList<>();
       findTotal(root,arr);
       if(arr.size()%2==0){
           int val=arr.size()/2;
           int val1=arr.get(val-1);
           int val2=arr.get(val);
           float x=(((float)val1+(float)val2)*(float)1.0/(float)2);
           return x;
       }
       else{
           return arr.get(arr.size()/2);
       }
    }
    public static void findTotal(Node root,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        findTotal(root.left,arr);
        arr.add(root.data);
        findTotal(root.right,arr);
    }
    
    
}
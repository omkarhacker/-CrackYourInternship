class Solution {
    public int sumK(Node root, int k) {
        // code here
        ArrayList<Integer>arr=new ArrayList<>();
        int count[]=new int[1];
        findPath(root,k,arr,count);
        return count[0];
    }
    public void findPath(Node root,int k,ArrayList<Integer>arr,int count[]){
        if(root==null){
            return;
        }
        arr.add(root.data);
        //System.out.println(arr);
        findPath(root.left,k,arr,count);
        findPath(root.right,k,arr,count);
        int sum=0;
        for(int i=arr.size()-1;i>=0;i--){
            sum=sum+arr.get(i);
            if(sum==k){
                count[0]++;
            }
        }
        
        arr.remove(arr.size()-1);
    }
}
class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        boolean visited[]=new boolean[n];
        ArrayList<Integer>adj=new ArrayList<>();
        //Set<ArrayList<Integer>>set=new TreeSet<>();
        findPermutation(ans,arr,visited,adj);
        //ans.addAll(set);
        return ans;
    }
    static void findPermutation(ArrayList<ArrayList<Integer>>set,ArrayList<Integer>arr,boolean visited[],ArrayList<Integer>adj){
        if(adj.size()==arr.size()){
            set.add(new ArrayList<>(adj));
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(visited[i] || (i>0 && arr.get(i)==arr.get(i-1) && !visited[i-1])){
                continue;
            }
                visited[i]=true;
                adj.add(arr.get(i));
                findPermutation(set,arr,visited,adj);
                adj.remove(adj.size()-1);
                visited[i]=false;
        }
    }
};
class Solution {
    class Node{
        String str;
        double val;
        Node(String str,double val){
            this.str=str;
            this.val=val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
          HashSet<String>hs=new HashSet<>();
          HashMap<String,ArrayList<Node>>hm=new HashMap<>();
          for(int i=0;i<equations.size();i++){
                    hs.add(equations.get(i).get(0));
                    hs.add(equations.get(i).get(1));
                    ArrayList<Node>arr1=new ArrayList<>();
                    arr1.add(new Node(equations.get(i).get(1),values[i]));
                    ArrayList<Node>arr2=new ArrayList<>();
                    arr2.add(new Node(equations.get(i).get(0),1.0/values[i]));
                    if(hm.containsKey(equations.get(i).get(0))){
                        ArrayList<Node>arr=hm.get(equations.get(i).get(0));
                        arr.add(new Node(equations.get(i).get(1),values[i]));
                        hm.put(equations.get(i).get(0),arr);
                    }
                    else{
                        hm.put(equations.get(i).get(0),arr1);
                    }
                    if(hm.containsKey(equations.get(i).get(1))){
                        ArrayList<Node>arr=hm.get(equations.get(i).get(1));
                        arr.add(new Node(equations.get(i).get(0),1.0/values[i]));
                        hm.put(equations.get(i).get(1),arr);
                    }
                    else{
                        hm.put(equations.get(i).get(1),arr2);
                    }
          }
          double ans[]=new double[queries.size()];
          for(int i=0;i<queries.size();i++){
              String str1=queries.get(i).get(0);
              String str2=queries.get(i).get(1);
              if(!hs.contains(str1) || !hs.contains(str2)){
                 ans[i]=-1.00000;
              }
              else{
                HashSet<String>set=new HashSet<>();
                double val=findAns(set,hm,str1,str2,1.0);
                if(val!=0.0){
                    ans[i]=val;
                }
                else{
                    ans[i]=-1.0;
                }
              }
          }
          return ans;
    }
    public double findAns(HashSet<String>hs,HashMap<String,ArrayList<Node>>hm,String curr,String dest,double ans){
        if(curr.equals(dest)){
            return ans;
        }
        hs.add(curr);
        ArrayList<Node>arr=hm.get(curr);
        for(int i=0;i<arr.size();i++){
            Node node=arr.get(i);
            String str=node.str;
            double val=node.val;
            if(!hs.contains(str)){
                double a=findAns(hs,hm,str,dest,ans*val);
                if(a!=0.0){
                    return a;
                }
            }
        }
        return 0.0;
    }
}
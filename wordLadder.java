class Solution {
    class Node{
        String str;
        int cost;
        Node(String str,int cost){
            this.str=str;
            this.cost=cost;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<Node>qu=new LinkedList<>();
        qu.add(new Node(beginWord,1));
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        while(!qu.isEmpty()){
            Node node=qu.remove();
            String str=node.str;
            int val=node.cost;
            if(str.equals(endWord)){
                return val;
            }
            for(int i=0;i<str.length();i++){
                char arr[]=str.toCharArray();
                 for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String newstr=new String(arr);
                    if(set.contains(newstr)){
                        qu.add(new Node(newstr,val+1));
                        set.remove(newstr);
                    }
                }
            }
        }
        return 0;
    }
}
class LRUCache {
    Queue<Integer>qu;
    HashMap<Integer,Integer>hm;
    int size;
    public LRUCache(int capacity) {
        qu=new LinkedList<>();
        hm=new HashMap<>();
        size=capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            qu.remove(key);
            qu.add(key);
            return hm.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.put(key,value);
            qu.remove(key);
            qu.add(key);
        }
        else{
            hm.put(key,value);
            qu.add(key);
            if(qu.size()>size){
                int val=qu.remove();
                hm.remove(val);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
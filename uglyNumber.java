class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long)1);
        HashSet<Long> hm = new HashSet<>();
        hm.add((long)1);
        long val=1;
        for(int i=0;i<n;i++) {
            val = pq.remove();
            if (!hm.contains(val * 2)) {
                pq.add(val * 2);
                hm.add(val * 2);
            }
            if (!hm.contains(val * 3)) {
                pq.add(val * 3);
                hm.add(val * 3);
            }
            if (!hm.contains(val * 5)) {
                pq.add(val * 5);
                hm.add(val * 5);
            }
        }
        return (int)val;
    }
}
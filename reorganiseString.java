class Solution {
    class Node {
        char ch;
        int freq;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {

        int n = s.length();
        int val = (n + 1) / 2;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        Set<Character> set = hm.keySet();
        for (Character ch : set) {
            if (hm.get(ch) > val) {
                return "";
            }
            pq.add(new Node(ch, hm.get(ch)));
        }
        StringBuilder str = new StringBuilder();
        while (pq.size()>=2) {
            // PriorityQueue<Node>newpq=new PriorityQueue<>((x,y)->y.freq-x.freq);
            Node node1 = pq.remove();
            Node node2 = pq.remove();
            char ch1 = node1.ch;
            int freq1 = node1.freq;
            char ch2 = node2.ch;
            int freq2 = node2.freq;
            str.append(ch1);
            str.append(ch2);
            if (freq1 - 1 > 0) {
                pq.add(new Node(ch1, freq1 - 1));
            }
            if (freq2 - 1 > 0) {
                pq.add(new Node(ch2, freq2 - 1));
            }
        }
        while(!pq.isEmpty()){
            str.append(pq.remove().ch);
        }
        return str.toString();

    }
}
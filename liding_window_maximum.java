class Solution {
    class Node {
        int val;
        int index;

        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        HashSet<String> hs = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.val - x.val);
        for (int i = 0; i < k; i++) {
            hs.add(nums[i] + " " + i);
            pq.add(new Node(nums[i], i));
        }
        int ans[] = new int[n - k + 1];
        int j = 0;
        for (int i = k; i < n; i++) {
            while (true) {
                Node node = pq.peek();
                String str = node.val + " " + node.index;
                if (hs.contains(str)) {
                    break;
                } else {
                    pq.remove();
                }
            }
            ans[j] = pq.peek().val;
            pq.add(new Node(nums[i], i));
            hs.add(nums[i] + " " + i);
            String str = nums[i - k] + " " + (i - k);
            hs.remove(str);
            j++;
        }
        while (true) {
            Node node = pq.peek();
            String str = node.val + " " + node.index;
            if (hs.contains(str)) {
                break;
            } else {
                pq.remove();
            }
        }
        ans[j] = pq.peek().val;

        return ans;
    }
}
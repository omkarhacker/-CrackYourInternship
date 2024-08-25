class Solution {
    class Node {
        int val;
        int dist;

        Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        boolean istrue = false;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (istrue == false) {
                for (int j = 0; j < n; j++) {
                    count++;
                    if (board[i][j] != -1) {
                        hm.put(count, board[i][j]);
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    count++;
                    if (board[i][j] != -1) {
                        hm.put(count, board[i][j]);
                    }
                }
            }
            istrue = !istrue;
        }
        System.out.println(hm);
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(1, 0));
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int j = 0; j < size; j++) {
                Node node = qu.remove();
                int val = node.val;
                int dist = node.dist;
                if (val == n * n) {
                    return dist;
                }
                for (int i = 1; i <= 6; i++) {
                    int x = val + i;
                    if (hm.containsKey(x)) {
                        x = hm.get(x);
                    }
                    if (x <= n * n && !hs.contains(x)) {
                        qu.add(new Node(x, dist + 1));
                        hs.add(x);
                    }
                }
            }
        }
        return -1;
    }
}

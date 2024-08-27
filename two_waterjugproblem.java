class Solution {
    public int minSteps(int m, int n, int d) {
        // Edge case: If the desired amount d is greater than both jug capacities
        if (d > m && d > n) return -1;

        // To handle cases where d is not reachable
        if (d % gcd(m, n) != 0) return -1;

        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();

        queue.add(new Pair(0, 0)); // start with both jugs empty
        visited.add(new Pair(0, 0));

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();

                int a = curr.x;
                int b = curr.y;

                if (a == d || b == d) {
                    return steps;
                }

                // Possible moves:
                List<Pair> nextMoves = Arrays.asList(
                    new Pair(0, b), // Empty jug 1
                    new Pair(a, 0), // Empty jug 2
                    new Pair(m, b), // Fill jug 1
                    new Pair(a, n), // Fill jug 2
                    new Pair(Math.min(a + b, m), a + b <= m ? 0 : b - (m - a)), // Pour jug 2 -> jug 1
                    new Pair(a + b <= n ? 0 : a - (n - b), Math.min(a + b, n)) // Pour jug 1 -> jug 2
                );

                for (Pair move : nextMoves) {
                    if (!visited.contains(move)) {
                        queue.add(move);
                        visited.add(move);
                    }
                }
            }

            steps++;
        }

        return -1; // If not possible
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

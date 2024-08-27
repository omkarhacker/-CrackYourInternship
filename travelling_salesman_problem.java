

// User function Template for Java

class Solution {
    public int total_cost(int[][] cost) {
        int n = cost.length;
        // Memoization table: dp[city][mask] stores the minimum cost to visit all cities starting from 'city' with 'mask' representing visited cities
        Integer[][] dp = new Integer[n][1 << n];
        return tsp(cost, 0, 1, dp); // Start from city 0 with only city 0 visited
    }

    private int tsp(int[][] cost, int currentCity, int visitedMask, Integer[][] dp) {
        // Base case: all cities have been visited, return cost to go back to the start city
        if (visitedMask == (1 << cost.length) - 1) {
            return cost[currentCity][0]; // Return to the starting city
        }

        if (dp[currentCity][visitedMask] != null) { // Return cached result
            return dp[currentCity][visitedMask];
        }

        int minCost = Integer.MAX_VALUE;

        // Try to visit all unvisited cities
        for (int nextCity = 0; nextCity < cost.length; nextCity++) {
            if ((visitedMask & (1 << nextCity)) == 0) { // If 'nextCity' has not been visited
                int newVisitedMask = visitedMask | (1 << nextCity);
                int newCost = cost[currentCity][nextCity] + tsp(cost, nextCity, newVisitedMask, dp);
                minCost = Math.min(minCost, newCost);
            }
        }

        dp[currentCity][visitedMask] = minCost; // Cache the result
        return minCost;
    }
}
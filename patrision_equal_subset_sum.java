class Solution {
    static int equalPartition(int N, int arr[]) {
        // Calculate total sum of the array
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            totalSum += arr[i];
        }
        
        // If the total sum is odd, return 0 (not possible to partition)
        if (totalSum % 2 != 0) {
            return 0;
        }
        
        // We need to check if a subset with sum totalSum/2 exists
        int target = totalSum / 2;
        
        // Create a 2D memoization table initialized to -1 (not calculated)
        int[][] memo = new int[N][target + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= target; j++) {
                memo[i][j] = -1;
            }
        }
        
        // Start the recursive function
        return findAns(arr, 0, 0, target, memo);
    }

    // Recursive function to check if we can form the target sum with the subset
    static int findAns(int arr[], int i, int currSum, int target, int[][] memo) {
        // Base case: if the current sum equals the target, we found a valid partition
        if (currSum == target) {
            return 1;
        }
        
        // If we've processed all elements or the current sum exceeds the target, return 0
        if (i >= arr.length || currSum > target) {
            return 0;
        }
        
        // If this state has already been calculated, return the memoized result
        if (memo[i][currSum] != -1) {
            return memo[i][currSum];
        }
        
        // Recursively explore two possibilities: include arr[i] or don't include it
        int include = findAns(arr, i + 1, currSum + arr[i], target, memo);
        int exclude = findAns(arr, i + 1, currSum, target, memo);
        
        // Memoize the result for this state
        memo[i][currSum] = include | exclude;
        
        // Return the result (1 if either option succeeds, otherwise 0)
        return memo[i][currSum];
    }
}

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        // Step 1: Count frequencies of all tasks
        for (int i = 0; i < tasks.length; i++) {
            hm.put(tasks[i], hm.getOrDefault(tasks[i], 0) + 1);
        }
        
        // Step 2: Use a max heap to always pick the task with the highest remaining frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int freq : hm.values()) {
            pq.add(freq);
        }
        
        int count = 0;
        
        // Step 3: Execute tasks until no tasks are left
        while (!pq.isEmpty()) {
            int cycle = 0;
            // List to store tasks after executing one cycle (n+1)
            java.util.List<Integer> temp = new java.util.ArrayList<>();
            
            // Step 4: Run the tasks in a cycle of length n+1
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1);
                    cycle++;
                }
            }
            
            // Step 5: Add back tasks with remaining frequency to the queue
            for (int remaining : temp) {
                if (remaining > 0) {
                    pq.add(remaining);
                }
            }
            
            // If there are more tasks to process, add idle time, else just the task length
            count += !pq.isEmpty() ? n + 1 : cycle;
        }
        
        return count;
    }
}

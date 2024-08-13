/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));  // Pair of node and its position index

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftmost = queue.peek().getValue();  // Get the index of the leftmost node at the current level

            int rightmost = 0;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue();

                // Update the rightmost index
                rightmost = index;

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2 * index + 1));
                }
            }
            // Update maxWidth with the current level's width
            maxWidth = Math.max(maxWidth, rightmost - leftmost + 1);
        }
        return maxWidth;
    }
}

// Helper class for Pair
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
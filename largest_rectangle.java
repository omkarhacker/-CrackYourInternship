class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftLarge[] = new int[n];
        int rightLarge[] = new int[n];
        findLeft(heights, leftLarge);
        findRight(heights, rightLarge);
        for(int i=0;i<n;i++){
            System.out.println(leftLarge[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println(rightLarge[i]);
        }
        int newarr[]=new int[n];
        for(int i=0;i<n;i++){
            newarr[i]=rightLarge[i]-leftLarge[i]-1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,newarr[i]*heights[i]);
        }
        return max;
    }

    public void findLeft(int heights[], int leftLarge[]) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftLarge[i] = -1;
            } else {
                leftLarge[i] = st.peek();
            }
            st.push(i);
        }
    }

    public void findRight(int heights[], int leftLarge[]) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftLarge[i] = n;
            } else {
                leftLarge[i] = st.peek();
            }
            st.push(i);
        }
    }
}
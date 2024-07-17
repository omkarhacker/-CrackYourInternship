import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int topx = 0;
        int topy = 0;
        int bottomx = n - 1;
        int bottomy = m - 1;
        List<Integer> li = new ArrayList<>();
        while (topx <= bottomx && topy <= bottomy) {
            for (int i = topy; i <= bottomy; i++) {
                li.add(matrix[topx][i]);
            }
            topx++;
            for (int i = topx; i <= bottomx; i++) {
                li.add(matrix[i][bottomy]);
            }
            bottomy--;
            if (bottomx >= topx) {
                for (int i = bottomy; i >= topy; i--) {
                    li.add(matrix[bottomx][i]);
                }
            }

            bottomx--;
            if ( bottomy >= topy) {
                for (int i = bottomx; i >= topx; i--) {
                    li.add(matrix[i][topy]);
                }
            }

            topy++;
        }
        return li;
    }
}

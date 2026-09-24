class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] max = new int[n];

        for (int i = 0; i < n; i++) {          // column
            for (int j = 0; j < m; j++) {      // row
                max[i] = Math.max(max[i], matrix[j][i]);
            }
        }

        for (int i = 0; i < m; i++) {          // row
            for (int j = 0; j < n; j++) {      // column
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max[j];
                }
            }
        }

        return matrix;
    }
}
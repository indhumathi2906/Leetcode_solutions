class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
         int m = grid.length;
         int n = grid[0].length;
         int total = m * n;
         k = k % total;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = i * n + j;
                int next = (current + k) % total;
                int newRow = next / n;
                int newCol = next % n;
                result.get(newRow).set(newCol, grid[i][j]);

            }
        }
       return result; 
    }
}
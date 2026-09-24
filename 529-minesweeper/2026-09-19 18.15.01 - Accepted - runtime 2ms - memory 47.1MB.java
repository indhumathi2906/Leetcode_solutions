class Solution {
    int m;
    int n;
    int[][] dir = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        m = board.length;
        n = board[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(click);

        boolean[][] visited = new boolean[m][n];
        visited[click[0]][click[1]] = true;


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            int mines = countMines(board, r, c);

            if (mines > 0) {
                board[r][c] = (char) (mines + '0');
            } else {
                board[r][c] = 'B';
                for (int[] d: dir) {
                    int nextR = r + d[0];
                    int nextC = c + d[1];

                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                        if (board[nextR][nextC] == 'E' && board[r][c] == 'B') {
                            visited[nextR][nextC] = true;
                            queue.offer(new int[]{nextR, nextC});
                        }
                    }
                }
            }
        }
        return board;
    }
    private int countMines(char[][] board, int r, int c) {
        int count = 0;
        for (int[] d: dir) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && board[nextR][nextC] == 'M') {
                count++;
            }
        }
        return count;
    }
}
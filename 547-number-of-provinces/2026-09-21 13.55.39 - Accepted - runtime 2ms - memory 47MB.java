class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        int i = 0;

        while (i < n) {
            if (visited[i]) {
                i++;
            } else {
                q.offer(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int k = q.poll();

                    for (int j = 0; j < n; j++) {
                        if (isConnected[k][j] == 1 && !visited[j]) {
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                ans++;
            }
        }

        return ans;
    }
}
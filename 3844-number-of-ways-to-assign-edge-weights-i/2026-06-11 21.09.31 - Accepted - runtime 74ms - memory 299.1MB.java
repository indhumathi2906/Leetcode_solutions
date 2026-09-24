import java.util.*;

class Solution {

    int maxDepth = 0;
    int MOD = 1000000007;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0, 0, graph);

        long ans = 1;

        for (int i = 1; i < maxDepth; i++) {
            ans = (ans * 2) % MOD;
        }

        return (int) ans;
    }

    private void dfs(int node, int parent, int depth,
                     ArrayList<Integer>[] graph) {

        maxDepth = Math.max(maxDepth, depth);

        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, depth + 1, graph);
            }
        }
    }
}
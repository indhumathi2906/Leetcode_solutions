import java.util.*;

class Solution {
    List<Integer>[] g;
        boolean[] vis;
            int nodes, edges;

                public int countCompleteComponents(int n, int[][] edgesArr) {
                        g = new ArrayList[n];
                                vis = new boolean[n];

                                        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

                                                for (int[] e : edgesArr) {
                                                            g[e[0]].add(e[1]);
                                                                        g[e[1]].add(e[0]);
                                                                                }

                                                                                        int ans = 0;

                                                                                                for (int i = 0; i < n; i++) {
                                                                                                            if (!vis[i]) {
                                                                                                                            nodes = 0;
                                                                                                                                            edges = 0;
                                                                                                                                                            dfs(i);
                                                                                                                                                                            if (edges == nodes * (nodes - 1))
                                                                                                                                                                                                ans++;
                                                                                                                                                                                                            }
                                                                                                                                                                                                                    }

                                                                                                                                                                                                                            return ans;
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                    void dfs(int u) {
                                                                                                                                                                                                                                            vis[u] = true;
                                                                                                                                                                                                                                                    nodes++;
                                                                                                                                                                                                                                                            edges += g[u].size();

                                                                                                                                                                                                                                                                    for (int v : g[u])
                                                                                                                                                                                                                                                                                if (!vis[v])
                                                                                                                                                                                                                                                                                                dfs(v);
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    }
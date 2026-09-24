class Solution {

    int[] parent;

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;

        parent[pa] = pb;
        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 1, right = 200000;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(can(n, edges, k, mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }

    boolean can(int n, int[][] edges, int k, int target){

        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        int used = 0;
        int upgrades = 0;

        // mandatory edges
        for(int[] e : edges){
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if(must == 1){
                if(s < target) return false;

                if(!union(u,v)) return false;

                used++;
            }
        }

        // normal edges
        for(int[] e : edges){
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if(must == 0 && s >= target){
                if(union(u,v)){
                    used++;
                }
            }
        }

        // upgraded edges
        for(int[] e : edges){
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if(must == 0 && s < target && s * 2 >= target){
                if(union(u,v)){
                    upgrades++;
                    used++;

                    if(upgrades > k) return false;
                }
            }
        }

        return used == n - 1;
    }
}
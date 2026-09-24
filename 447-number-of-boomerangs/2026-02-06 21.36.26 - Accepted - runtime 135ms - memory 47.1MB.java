class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dist = dx * dx + dy * dy;

                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            
            for (int k : map.values()) {
                count += k * (k - 1);
            }
        }

        return count;
        
    }
}
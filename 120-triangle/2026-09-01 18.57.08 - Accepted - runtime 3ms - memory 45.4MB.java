class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int next[] = new int[n+1];
        for(int i=n-1;i>=0;i--) {
            int[] curr = new int[n+1];
            for(int j=0;j<=i;j++) { 
                curr[j] = triangle.get(i).get(j) + Math.min(next[j], next[j+1]); 
            }
            next = curr;
        }
        return next[0];
    }
}

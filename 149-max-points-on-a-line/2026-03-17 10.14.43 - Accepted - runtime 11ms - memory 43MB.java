class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;

        int result = 2;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int counter = 2;

                for(int k = j+1; k < n; k++){

                    int t1 = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int t2 = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);

                    if(t1 == t2){
                        counter++;
                    }
                }

                result = Math.max(result, counter);
            }
        }

        return result;
    }
}
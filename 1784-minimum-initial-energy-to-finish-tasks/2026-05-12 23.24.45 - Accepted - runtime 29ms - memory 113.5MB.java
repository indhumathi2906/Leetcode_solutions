class Solution {
    public int minimumEffort(int[][] tasks) {
         Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int energy = 0;

        for (int[] t : tasks) {
            if (energy < t[1]) {
                energy = t[1];
            }
            energy -= t[0];
        }

        return energy + Arrays.stream(tasks).mapToInt(t -> t[0]).sum();
        
    }
}
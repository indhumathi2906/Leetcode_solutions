class Solution {
    private int[] original;
    private Random rand = new Random();

    public Solution(int[] nums) {
        original = nums.clone();
    }

    public int[] reset() {
        return original.clone();
    }

    public int[] shuffle() {
        int[] arr = original.clone();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int x = rand.nextInt(n);
            for(int j = 0; j < n; j++){
                if(i == j){
                    int temp = arr[x];
                    arr[x] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
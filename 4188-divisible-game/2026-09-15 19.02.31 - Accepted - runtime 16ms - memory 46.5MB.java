class Solution {
    private static final int[] primes = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
        101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
        211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
        307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
        401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
        503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
        601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
        701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797,
        809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887,
        907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
    };

    public int divisibleGame(int[] nums) {
        boolean[] used = new boolean[168];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            for(int i = 0; i < 168 && primes[i] <= num; i++) {
                if(num % primes[i] == 0) {
                    used[i] = true;
                    num /= primes[i];
                    while(num % primes[i] == 0) num /= primes[i];
                }
            }
            if(num > 1) freq.merge(num, 1, Integer::sum);
        }

        int ans = -1, k = 2;
        for(int i = 0; i < 168; i++) {
            if(!used[i]) continue;

            int max = kadane(nums, primes[i]);
            if(ans < max) {
                ans = max;
                k = primes[i];
            }
        }

        if(!freq.isEmpty()) {
            for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int val = entry.getKey(), count = entry.getValue();
                if(val * count <= ans) continue;

                int max = kadane(nums, val);
                if(ans < max) {
                    ans = max;
                    k = val;
                }
            }
        }


        return (int)(((long)ans * k + 1000000007) % 1000000007);
    }

    private static int kadane(int[] nums, int val) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int num : nums) {
            if(num % val == 0) sum += num;
            else sum -= num;
            
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}
class Solution {

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;  
            n /= 10;        
        }
        return sum;
    }

    public int countEven(int num) {

        int sum = digitSum(num);

  
        if (sum % 2 == 0) {
            return num / 2;
        } else {
            return (num - 1) / 2;
        }
    }
}
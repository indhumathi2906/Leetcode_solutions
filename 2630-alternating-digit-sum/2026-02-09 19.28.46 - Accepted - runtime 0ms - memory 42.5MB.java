class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int sign = 1;  
        
        String num = String.valueOf(n);
        
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            sum += sign * digit;
            sign = -sign; 
        }
        
        return sum;
        
    }
}
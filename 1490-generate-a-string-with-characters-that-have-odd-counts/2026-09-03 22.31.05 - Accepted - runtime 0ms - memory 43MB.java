class Solution {
    public String generateTheString(int n) {
        char[] r = new char[n];
        if(n % 2 == 0) {
            r[--n] = 'b'; 
        }
        while(n > 0) {
            r[--n] = 'a';
        }
        return String.valueOf(r);
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();

        java.util.Arrays.sort(sChars);
        java.util.Arrays.sort(tChars);
        return java.util.Arrays.equals(sChars,tChars);
        
    }
}
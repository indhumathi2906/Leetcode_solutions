class Solution {
    public boolean detectCapitalUse(String word) {
        
        int countUpper=0;
          for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                countUpper++;
            }
        }

        if (countUpper == word.length()) return true;
        if (countUpper == 0) return true;
        if (countUpper == 1 && Character.isUpperCase(word.charAt(0))) return true;

        return false;
    }
}
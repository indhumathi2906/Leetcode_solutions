class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        int base = 96;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)=='#') {
                String sub = s.substring(i-2, i);
                int value = Integer.parseInt(sub);
                char ch = (char)(base+value);
                sb.insert(0, ch);
                i=i-2;
            }
            else {
                int value = Character.getNumericValue(s.charAt(i));
                char ch = (char)(base+value);
                sb.insert(0, ch);
            }
        }

        return sb.toString();
    }
}
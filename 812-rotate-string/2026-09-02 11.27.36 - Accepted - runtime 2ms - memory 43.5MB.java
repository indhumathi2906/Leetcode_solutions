class Solution {
    public boolean rotateString(String s, String goal) {
        int l = s.length();
        s = s+s;

        if(goal.length()==l)
        {    
            return s.contains(goal);
        }
        return false;
    }
}
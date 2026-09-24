class Solution {
    public String truncateSentence(String s, int k) {
        int i=0;
        while(i<s.length()){
            if(s.charAt(i++)==' '){
                k--;
                if(k==0)
                break;
            }
        }
        if(i==s.length())
        return s.substring(0,i);
        return s.substring(0,i-1);
        
    }
}
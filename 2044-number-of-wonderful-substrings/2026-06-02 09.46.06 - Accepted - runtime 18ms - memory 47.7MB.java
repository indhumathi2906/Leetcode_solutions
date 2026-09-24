class Solution {
    public long wonderfulSubstrings(String word) {
        long freq[]=new long[1024];
        /* we have 10 characters
        so the total mask is 2^10=1024
        */
        /*
        "aba"
        "a"."ab","aba"
        */
        freq[0]=1;
        long result=0;
        int mask=0;
        for(char c:word.toCharArray()){
            int bit=c-'a';
            mask=mask^(1<<bit);
            /*
            case 1:
            */
            result+=freq[mask];
            for(int b=0;b<10;b++){
                int dummyMask =mask^(1<<b);
                 result+=freq[dummyMask];
            }
            freq[mask]++;
        }
        
        

     return result;   
    }
}
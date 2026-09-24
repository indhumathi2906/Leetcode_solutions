class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int freq[]=new int[26];
        for(char c:word.toCharArray()){
            int idx=c-'a';
            freq[idx]++;
        }
        Arrays.sort(freq);
        int index=0;
        int res=0;
        for(int i=25;i>=0;i--){
            res+=(index/8+1)*freq[i];
            index++;
        }
        return res;
        }
    
}
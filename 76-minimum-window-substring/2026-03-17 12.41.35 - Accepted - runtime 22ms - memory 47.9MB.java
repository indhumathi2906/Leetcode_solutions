class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m<n){
            return "";
        }
        HashMap<Character,Integer> tMap=new HashMap<>();
        HashMap<Character,Integer> window =new HashMap<>();
        for(char ch:t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);

        }
        int minLength=Integer.MAX_VALUE;
        int required=tMap.size();
        int formed=0;
        int left=0;
        int start=0;
        for(int right=0;right<m;right++){
            char ch=s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(tMap.containsKey(ch) && tMap.get(ch).intValue()==window.get(ch).intValue()){
                formed++;

            }
            while(left<=right && formed==required){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    start=left;
                }
                char leftChar=s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(tMap.containsKey(leftChar)&& tMap.get(leftChar).intValue()>window.get(leftChar).intValue()){
                    formed--;
                }
                
                left++;
            }
        }
        return (minLength==Integer.MAX_VALUE)?"":s.substring(start,start+minLength);
        
    }
}
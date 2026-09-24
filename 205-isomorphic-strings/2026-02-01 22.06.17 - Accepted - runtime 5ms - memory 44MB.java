class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] mapS=new int[256];
        int[] mapT=new int[256];
        for(int i=0;i<s.length();i++){
            char chS=s.charAt(i);
            char chT=t.charAt(i);
            if(mapS[chS]==0 && mapT[chT]==0){
                mapS[chS]=chT;
                mapT[chT]=chS;
            }
            else if(mapS[chS]!=chT || mapT[chT]!=chS){
                return false;
            }
        }
        return true;
        
    }
}
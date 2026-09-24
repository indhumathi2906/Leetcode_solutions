class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int ni=0, ti=0; 

        while(ni<name.length() || ti<typed.length()) {
        
            if(ni<name.length() && ti<typed.length() && name.charAt(ni)==typed.charAt(ti)) {
                ni++;
                ti++;
            }else if(ti<typed.length() && ti>0 && typed.charAt(ti-1)==typed.charAt(ti)){
                ti++; 
            }else {
                return false; 
            }
        }
        return ni==name.length(); 
    }
}
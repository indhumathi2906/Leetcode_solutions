class Solution {
    public int binaryGap(int n) {
        String s=Integer.toBinaryString(n);
        int i=0,j=0,x=s.length(),maxi=0;
        while(j<x && i<x){
            if(s.charAt(i)=='1'){
                j=i+1;
                while(j<x && s.charAt(j)!='1'){
                    j++;
                }
                if(j<x && s.charAt(j)=='1') maxi=Math.max(maxi,j-i);
            }
            i++;
        }
        return maxi;
    }
}
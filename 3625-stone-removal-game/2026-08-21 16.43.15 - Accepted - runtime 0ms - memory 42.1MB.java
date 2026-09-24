class Solution {
    public boolean canAliceWin(int n) {
        for(int x=10,k=0;;x--,k++)if(n<x)return(k&1)==1;else n-=x;
        
    }
}
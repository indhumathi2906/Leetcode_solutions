class Solution {
    public int[] constructRectangle(int area) {
        int W=(int) Math.sqrt(area);
        while(area % W!=0){
            W--;
        }
        return new int[]{area/W,W};
        
    }
}
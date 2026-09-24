class Solution {
    public int numberOfSteps(int num) {
        int step=0;
        while(num!=0){
            if(num%2!=0){
                num-=1;
                step++;
            }else{
                num/=2;
                step++;
            }
        }
        return step;
    }
}
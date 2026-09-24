class Solution {
    public int subtractProductAndSum(int n) {
        int r=0,prod=1,sum=0;
        while(n>0){
            r=n%10;
            prod*=r;
            sum+=r;
            n=n/10;
        }
        return prod-sum;
    }
}
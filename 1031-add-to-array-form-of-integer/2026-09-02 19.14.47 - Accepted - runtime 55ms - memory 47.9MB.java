class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        int carry=0;
        int i=0;
        for(i=num.length-1;i>=0 && k>0;i--){
            int temp=num[i];
            res.add(0,(temp+carry+(k%10))%10);
            carry=(temp+carry+(k%10))/10;
            k/=10;
        }
        while(k!=0){
            int compute=(k%10)+carry;
            res.add(0,compute%10);
            carry=compute/10;
            k/=10;
        }
        for(int r=i;r>=0;r--){
            int temp=num[r];
            res.add(0,(temp+carry)%10);
            carry=(temp+carry)/10;
        }
        if(carry!=0)
            res.add(0,carry);
        return res;
    }
}

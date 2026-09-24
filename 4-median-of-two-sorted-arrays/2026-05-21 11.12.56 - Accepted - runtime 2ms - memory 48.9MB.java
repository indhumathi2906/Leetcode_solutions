class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] num=new int[nums1.length+nums2.length];
        int index=0;
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                num[index++]=nums1[i++];
            }
            else{
                num[index++]=nums2[j++];
            }

        }
        while (i < nums1.length) {
            num[index++] = nums1[i++];
        }

        while (j < nums2.length) {
            num[index++] = nums2[j++];
        }

        int n = num.length;

        if (n % 2 == 1) {
            return num[n / 2];
        } else {
            return (num[n / 2 - 1] + num[n / 2]) / 2.0;
        }
    }
}
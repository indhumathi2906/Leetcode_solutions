class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
                Arrays.sort(nums1);
                        Arrays.sort(nums2);
                                Set<Integer> set = new HashSet<>();
                                        for(int i=0;i<nums1.length;i++) set.add(nums1[i]);
                                                for(int i=0;i<nums2.length;i++)
                                                            {
                                                                            if(set.contains(nums2[i]))return nums2[i];
                                                                                        }
                                                                                                return Math.min(nums1[0]*10+nums2[0],nums2[0]*10+nums1[0]);
                                                                                                    }
                                                                                                    
}
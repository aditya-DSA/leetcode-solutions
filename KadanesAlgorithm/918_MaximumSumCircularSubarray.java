class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxsum = nums[0];
        int minsum = nums[0];
        int curmin = 0;
        int curmax = 0;
        for(int i =0;i<nums.length;i++) {
            curmax = Math.max(curmax+nums[i],nums[i]);
            maxsum = Math.max(maxsum,curmax);
            curmin = Math.min(curmin+nums[i],nums[i]);
            minsum = Math.min(curmin,minsum);
            total+=nums[i];
        }
        if(maxsum<0) {
            return maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}
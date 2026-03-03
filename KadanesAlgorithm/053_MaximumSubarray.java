class Solution {
    public int maxSubArray(int[] nums) {
        //this uses cuurenet sum and max sum which is equal to first element int the array
        int currentsum = 0;
        int maxsum = nums[0];
        for(int i =0;i<nums.length;i++) {
            currentsum = currentsum + nums[i];
            maxsum = Math.max(currentsum,maxsum);
            if(currentsum<0) {
                currentsum = 0;
            }
        }
        return maxsum;
    }
}
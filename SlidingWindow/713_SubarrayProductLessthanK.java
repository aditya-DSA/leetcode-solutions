class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int currproduct = 1;
        for(int right = 0;right<nums.length;right++) {
            currproduct = currproduct*nums[right];
            while(currproduct>=k) {
                currproduct = currproduct/nums[left];//removing the left element so that product decreases
                left++;
            }
            count = count+(right-left+1);//window size is right-left+1
        }
        return count;
    }
}
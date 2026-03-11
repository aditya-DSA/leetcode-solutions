class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[end]) {
                //minimum will be in right half
                start = mid+1;
            } else {
                //orelse if will be in left half
                end = mid;
            }
        }
        //when start<end fails i.e. end becomes mid return start
        return nums[start];
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //     int[] ans = new int[2];
        //     ans[0] = FirstOccurrence(nums,target);
        //     ans[1] = LastOccurrence(nums,target);
        //     return ans;
        // }
        // private int FirstOccurrence(int[] nums,int target) {
        //     int ans = -1;
        //     int start = 0;
        //     int end = nums.length-1;
        //     while(start<=end) {
        //         int mid = start+(end-start)/2;
        //         if(nums[mid] == target) {
        //             ans = mid;
        //             end = mid-1;//move left
        //         } else if (nums[mid]<target) {
        //             start = mid+1;
        //         } else {
        //             end = mid-1;
        //         }
        //     }
        //     return ans;
        // }
        // private int LastOccurrence(int[] nums,int target) {
        //     int ans = -1;
        //     int start = 0;
        //     int end = nums.length-1;
        //     while(start<=end) {
        //         int mid = start+(end-start)/2;
        //         if(nums[mid] == target) {
        //             ans = mid;
        //             start = mid+1;//move right
        //         } else if (nums[mid]<target) {
        //             start = mid+1;
        //         } else {
        //             end = mid-1;
        //         }
        //     }
        //     return ans;

        //lower and upper bound approach
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target) - 1;

        if(first >= nums.length || nums[first] != target){
            return new int[]{-1, -1};
        }

        return new int[]{first, last};
    }

    private int lowerBound(int[] nums, int target){
        int start = 0;
        int end = nums.length;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int upperBound(int[] nums, int target){
        int start = 0;
        int end = nums.length;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] <= target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
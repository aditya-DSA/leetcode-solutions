class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //create list tonstore the result
        List<List<Integer>> result = new ArrayList<>();
        //sort the array
        Arrays.sort(nums);
        for (int i =0;i<nums.length-2;i++) {
            if(nums[i]>0) {
                break;
            }
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            //two pointer
            int left = i+1;
            int right = nums.length-1;
            while(left<right) {
                long sum = (long) nums[i]+nums[left]+nums[right];
                if(sum==0) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) {
                        left++;
                    }
                    while(left<right && nums[right] ==nums[right+1]) {
                        right--;
                    }
                } else if(sum<0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
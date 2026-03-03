class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        //left product
        int leftpro = 1;
        for(int i =0;i<n;i++) {
            ans[i] = leftpro;
            leftpro = leftpro*nums[i];
        }
        //right product
        int rightpro = 1;
        for(int  i =n-1;i>=0;i--) {
            ans[i] = ans[i]*rightpro;
            rightpro= rightpro*nums[i];
        }
        return ans;
    }
}
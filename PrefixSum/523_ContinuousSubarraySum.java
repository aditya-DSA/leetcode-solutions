class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //creating a new hashmap
        Map<Integer,Integer> map = new HashMap<>();
        //intially
        map.put(0,-1);//since if remiander is 0 we see that at -1
        int sum = 0;
        for(int i =0;i<nums.length;i++) {
            sum = sum +nums[i];
            int rem = sum%k;
            if(map.containsKey(rem)) {
                if(i-map.get(rem)>=2) {
                    return true;
                }
            } else {
                map.put(rem,i);
            }
        }
        return false;
    }
}
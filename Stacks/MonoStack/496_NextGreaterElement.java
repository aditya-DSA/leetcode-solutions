class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map =new HashMap<>();
        for(int num:nums2) {
            //if stack not empty and current number is greater than top number in stack
            while(!stack.isEmpty() && num>stack.peek()) {
                map.put(stack.pop(),num);//add to map because in stcak small we get bigger
            }
            stack.push(num); //push to stack
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(),-1);//if no greater than means return -1;
        }
        //add to result
        int[] result = new int[nums1.length];
        for(int i =0;i<nums1.length;i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
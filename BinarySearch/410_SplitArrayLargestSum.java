class Solution {
    public int splitArray(int[] nums, int k) {
        //find the minimum and maximum of array
        //initially
        int start = 0;
        int end =0;
        for(int num :nums){
            start = Math.max(num,start);//worst case k = n means we divide n subarrays so maximum in array will be minimum ans
            end = end+num;//if k=1 we make only one subarray that is entire subaray so maximum is sum of array
        }
        //so we have start and end perfrom binary search and find potential ans
        while(start<end) {
            int mid = start+(end-start)/2;//may be ans
            //now number of peices we want with the sum mid
            int pieces = 1;
            int sum =0;
            for(int num:nums) {
                if(sum+num>mid) {
                    sum = num;
                    //means next piece
                    pieces++;
                } else {
                    sum = sum+num;//add to that piece only
                }
            }
            //now check pieces
            if(pieces>k) {
                //more peices means change the mid
                start = mid+1;
            } else{
                end = mid;//may be mid answer i.e. pieces<=m
            }
        }
        return end;//or start
    }
}
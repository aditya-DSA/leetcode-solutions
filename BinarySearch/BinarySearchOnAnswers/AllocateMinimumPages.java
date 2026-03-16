class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int start = 0;
        int end = 0;
        if(arr.length<k) return -1;
        for(int num:arr) {
            start = Math.max(start,num);
            end = end+num;
        }
        while(start<end) {
            int mid = start+(end-start)/2;
            int sum = 0;
            int student = 1;//min one student
            for(int num:arr) {
                if(sum+num>mid) {
                    sum = num;
                    student++;
                } else{
                    sum+=num;
                }
            }
            if(student<=k) {
                end = mid;
            } else {
                start=mid+1;
            }
        }
        return end;
    }
}
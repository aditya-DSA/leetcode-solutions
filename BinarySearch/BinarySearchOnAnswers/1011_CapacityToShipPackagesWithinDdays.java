class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start =0;
        int end = 0;
        for(int num:weights) {
            start = Math.max(start,num);//since in a single ship maximum weight i can send is the maximum of weights
            end = end+num;//here maximum i can send in a ship is full amount
        }
        //we have start and end apllying binary search on answer
        while(start<end) {
            int mid = start+(end-start)/2;//mid may be answer
            //now finding required days
            int day = 1;//minimum we require one day to send a weight
            int sum = 0;
            for(int num:weights) {
                if(sum+num>mid) {
                    sum = num;//exceeds menas we go to another day
                    day++;
                } else {
                    sum = sum+num;//add to current day
                }
            }
            //now check we have our required days or not if not updates accordingly
            if(day<=days) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return end;//or start
    }
}
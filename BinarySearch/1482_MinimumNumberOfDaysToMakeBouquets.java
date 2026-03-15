class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k >bloomDay.length) {
            return -1;
        }
        int start = 1;//atleast we should one day
        int end = 0;//max we can wait is maximum bloom day only
        for(int num:bloomDay) {
            end = Math.max(end,num);
        }
        //binary search
        while(start<end) {
            int mid = start+(end-start)/2;
            int flowers = 0;//initally
            int bouquets = 0;
            for(int day:bloomDay) {
                if(day<=mid) {
                    flowers++;//add flowers
                    if(flowers == k) {
                        bouquets++;//if flowers equals k we can make boquets
                        flowers = 0;//we cannot use that flowers again after making bouquets
                    }
                } else {
                    flowers = 0;
                }
            }
            if(bouquets>=m) {
                end = mid;//found our required boquets
            } else{
                start = mid+1;//increase mid
            }
        }
        return start;
    }
}
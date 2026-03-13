class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long start = 1;//minimum time allowed that is may be decreaed in 1sec atleast
        long end = (long)1e18;//maximum time allowed we get by solving a quadratic equation
        //perfrom binary search on answer
        while(start<end) {
            long mid = (long) start+(end-start)/2;
            //this may be the answer a potenital answer we assuming
            //let total hieght removed be 0 starting
            long total = 0;
            //now claculate the hieght removed by each workes
            for(int t :workerTimes) {
                long val = (long) ((Math.sqrt(1+(8.0*mid)/t)-1)/2);
                //add it to total height
                total+=val;
                if(total>=mountainHeight) break;//found the ans
            }
            if(total>=mountainHeight) {
                end = mid;
            } else {
                start = mid+1;//total may less soo increase mid
            }
        }
        return start;//or end
    }
}
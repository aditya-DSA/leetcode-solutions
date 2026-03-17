class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;

        for(int i = 0; i < n; i++) {
            int currHeight = heights[i];

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = right - left - 1;
                int area = h * width;
                maxarea = Math.max(maxarea, area);
            }

            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int right = n;
            int left = stack.isEmpty() ? -1 : stack.peek();
            int width = right - left - 1;
            int area = h * width;
            maxarea = Math.max(maxarea, area);
        }

        return maxarea;

        //brute force
        // for(int i =0;i<n;i++) {
        //     int h = heights[i];//fix the height
        //     int left = i;
        //     int right = i;
        //     while(left>=0 && heights[left]>=h) {
        //         left--;//expand left
        //     }
        //     while(right<n && heights[right]>=h) {
        //         right++;//expanding right
        //     }
        //     int width = right-left-1;//since (right-1)-(left+1) +1 is formula
        //     int area = h*width;
        //     //updte max
        //     maxarea = Math.max(maxarea,area);
        // }
        // return maxarea;
    }
}
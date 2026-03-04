class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        //swap from start and end
        while(start<end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        //    String original = s;
        //    String reverse = "";
        //    //reverse the string
        //    for(int i = s.length()-1;i>=0;i--) {
        //     reverse = reverse + s.charAt(i);
        //    }
        //    //checking palindrome or not
        //    if(original.equals(reverse)) {
        //     return true;
        //    }
        //    return false;
        //optimal solution
        int left = 0;
        int right = s.length()-1;
        while(left<right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                //checking palindromic
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
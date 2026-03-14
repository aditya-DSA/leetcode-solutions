class Solution {
    int count = 0;
    String ans = "";
    public String getHappyString(int n, int k) {
        backtrack("",n,k);
        return ans;
    }
    public void backtrack(String s,int n,int k) {
        if(s.length()==n) {
            count++;
            if(count == k) {
                ans = s;
            }
            return ;
        }
        char[] letters = {'a','b','c'};
        for(char ch :letters) {
            if(s.length()>0 && s.charAt(s.length()-1)==ch) {
                continue;//duplicates skipp
            }
            backtrack(s+ch,n,k);
        }
    }
}

// int total = 3 * (int)Math.pow(2, n - 1);
// if (k > total) return "";

// StringBuilder ans = new StringBuilder();

// int block = (int)Math.pow(2, n - 1);
// char[] first = {'a','b','c'};

// int index = (k - 1) / block;
// ans.append(first[index]);

// k = k - index * block;

// for(int i = 1; i < n; i++) {

//     block = block / 2;
//     char prev = ans.charAt(ans.length() - 1);

//     char[] options;

//     if(prev == 'a') options = new char[]{'b','c'};
//     else if(prev == 'b') options = new char[]{'a','c'};
//     else options = new char[]{'a','b'};

//     index = (k - 1) / block;
//     ans.append(options[index]);

//     k = k - index * block;
// }

// return ans.toString();
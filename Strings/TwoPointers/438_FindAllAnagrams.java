class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];//since 26 alphabets
        int[] window = new int[26];
        //string-pfrequency
        for(char c:p.toCharArray()) {
            pCount[c-'a']++;
        }///string-s frequency
        for(int i =0;i<s.length();i++) {
            window[s.charAt(i)-'a']++;
            if(i>=p.length()) {
                //remove the old element
                window[s.charAt(i-p.length())-'a']--;
            }if(Arrays.equals(pCount,window)) {
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            set.clear(); 
            for (int j = i; j < s.length(); j++) { 
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }
}

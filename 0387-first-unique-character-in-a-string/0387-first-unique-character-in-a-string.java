import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 1. Frequency calculation
        for (int i = 0; i < s.length(); i++) {
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), freq);
        }
        
       
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i; 
            }
        }
        
        
        return -1;
    }
}

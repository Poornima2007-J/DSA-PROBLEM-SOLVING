import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character,Integer> tmap = new HashMap<>(); 
        HashMap<Character,Integer> smap = new HashMap<>();

        int l = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = ""; 

        //tmap creation 
        for(int i = 0; i < t.length(); i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int needed = tmap.size();
      
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);

            if(tmap.containsKey(ch)){
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
                if(smap.get(ch).equals(tmap.get(ch))){
                    formed++;
                }
            }

            // window is valid - Inside the for-loop so 'r' is accessible
            while(formed == needed){
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    ans = s.substring(l, r + 1); // Assigned substring to ans
                }

                //remove left chracter
                char leftChar = s.charAt(l);
                if(tmap.containsKey(leftChar)){ 
                    if(smap.get(leftChar).equals(tmap.get(leftChar))){
                        formed--;
                    }
                    smap.put(leftChar, smap.get(leftChar) - 1);
                }
                l++;
            } 
        } 
        
        return ans;
    } 
}

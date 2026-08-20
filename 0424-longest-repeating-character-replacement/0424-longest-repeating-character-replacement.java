class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int count= 0;
        int maxlen = 0;
        int[] arr= new int[26];

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            arr[ch - 'A']++;
            count = Math.max(count, arr[ch - 'A']);
            while((j-i+1)-count>k){
                arr[s.charAt(i)-'A']--;
                i++;
            }
            maxlen=Math.max(maxlen,(j-i+1));
        }

        
        return maxlen;
    }
}
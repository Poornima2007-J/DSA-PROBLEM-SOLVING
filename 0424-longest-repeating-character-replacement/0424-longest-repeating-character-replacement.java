class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int maxFre=0;
        int maxLen=0;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);

            //find maxFre
            maxFre=Math.max(maxFre,map.get(s.charAt(r)));

            //if replacement needed>k
            while((r-l+1)-maxFre > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
        
    }
}
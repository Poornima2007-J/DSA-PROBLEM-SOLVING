class Solution {
    public int maxVowels(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
       int l=0;
       int count=0;
       int maxCount=0;
       for(int r=0;r<s.length();r++){
         //if the character is vowel increase the count
         if(isVowel(s.charAt(r))){
            count++;
         }

         //if the window size is >k
         if((r-l+1)>k){
            if(isVowel(s.charAt(l))){
                count--;
            }
            l++;
         }

         if((r-l+1)==k){
            maxCount=Math.max(count,maxCount);
         }
       }
       return maxCount;
    }
    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
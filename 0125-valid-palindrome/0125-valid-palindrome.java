class Solution {
    public boolean isPalindrome(String s) {
        String alnum=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left=0;
        int right=alnum.length()-1;
        while(left < right){
            if(alnum.charAt(left)!=alnum.charAt(right)){
                return false;
            }
            left++;
            right--;
            
        }
        return true;
        
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int zeroCount = 0; 
        int start = 0;    

 

        for (int end = 0; end < nums.length; end++) {
           
            if (nums[end] == 0) {
                zeroCount++;
            }
 
            
            while (zeroCount > 1) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++; 
            }

          
            int currentWindowSize = end - start + 1;
            maxLength = Math.max(maxLength, currentWindowSize);
        }

        
        return maxLength - 1;
    }
}

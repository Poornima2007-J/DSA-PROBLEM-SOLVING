class Solution {
    public int minSubArrayLen(int target, int[] nums) {
             int start=0;
             int end=0;
             int window=nums[0];
             int minLen=Integer.MAX_VALUE;

             if(window>=target){
                    return 1;
             }
             if(nums==null || nums.length==0){
                return 0;
             }

             while(end<nums.length-1){
                  end++;
                 window+=nums[end];

              while (window >= target) {
               
                minLen = Math.min(minLen, end - start + 1);
    
                window -= nums[start];
                start++;
            }
             }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }
}
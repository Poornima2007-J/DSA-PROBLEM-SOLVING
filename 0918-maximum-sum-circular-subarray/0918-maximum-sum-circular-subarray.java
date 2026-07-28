class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       
        int sum = 0;
        int maxsum = nums[0]; 
        int minSum = 0;
        int minsum = nums[0];
        int totalSum = 0;

       
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            sum += nums[i];
            maxsum = Math.max(maxsum, sum);
            if (sum < 0) {
                sum = 0;
            }

           
            minSum += nums[i];
            minsum = Math.min(minsum, minSum);
            if (minSum > 0) {
                minSum = 0;
            }
        }

        
        if (totalSum == minsum) {
            return maxsum;
        }

        
        int circularMax = totalSum - minsum;
        return Math.max(maxsum, circularMax);
    }
}

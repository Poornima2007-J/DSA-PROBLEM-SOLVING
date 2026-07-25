class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        int start = 0;
        int end = k;

        while (end < nums.length) {
            windowSum += nums[end] - nums[start];
            maxSum = Math.max(maxSum, windowSum);
            start++;
            end++;
        }
        return (double) maxSum / k;
    }
}

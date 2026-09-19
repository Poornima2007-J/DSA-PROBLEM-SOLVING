class Solution {
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int maxSum = nums[0];

        for (int r = 0; r < nums.length; r++) {

            sum += nums[r];

            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
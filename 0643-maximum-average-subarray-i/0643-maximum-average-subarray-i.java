class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int l=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            if(r-l+1==k){
               maxSum=Math.max(maxSum,sum);
                sum-=nums[l];
                l++;
            }
        }
        return (double) maxSum/k;
        
    }
}
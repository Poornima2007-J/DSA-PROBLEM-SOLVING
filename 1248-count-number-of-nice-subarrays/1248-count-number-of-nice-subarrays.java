class Solution {
    public int atMost(int[] nums,int goal){
        int l=0;
        int sum=0;
        int count=0;
          if (goal < 0) {
            return 0;
        }
        for(int r=0;r<nums.length;r++){
           sum+=(nums[r]%2);
            while(sum>goal){
                sum-=(nums[l]%2);
                l++;
            }
            
            if(sum<=goal){
                count+=r-l+1;
            }
        }
        return count;
       
    }
    public int numberOfSubarrays(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
}
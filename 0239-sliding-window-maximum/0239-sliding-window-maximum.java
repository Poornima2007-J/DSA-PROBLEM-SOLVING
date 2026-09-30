class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxDeque=new ArrayDeque<>();
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int l=0;
        int index=0;
        for(int r=0;r<nums.length;r++){
               while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()]<nums[r]){
                   maxDeque.pollLast();
               }
               maxDeque.addLast(r);

               if(maxDeque.peekFirst()<l){
                maxDeque.pollFirst();
               }

               if(r-l+1==k){
                ans[index]=nums[maxDeque.peekFirst()];
                index++;
                l++;
               }
        }
        return ans;
        
    }
}
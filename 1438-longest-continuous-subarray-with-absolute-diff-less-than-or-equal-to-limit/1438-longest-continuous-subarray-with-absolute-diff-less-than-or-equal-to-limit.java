class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque=new ArrayDeque<>();
        Deque<Integer> minDeque=new ArrayDeque<>();

        int l=0;
        int maxLen=0;
        for(int r=0;r<nums.length;r++){

            //add r to maxDeque=>it is decreasing order ex ---> 8,7,4,2
            while(! maxDeque.isEmpty() && maxDeque.peekLast()<nums[r]){
                maxDeque.pollLast();
            }
              maxDeque.addLast(nums[r]);
            
            //add r to minDeque=>it is increasing order ex ---> 2,4,7,8
            while(! minDeque.isEmpty() && minDeque.peekLast()>nums[r]){
                minDeque.pollLast();
            }
              minDeque.addLast(nums[r]);

            //Window becomes invalid
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {

                if (maxDeque.peekFirst() == nums[l]) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == nums[l]) {
                    minDeque.pollFirst();
                }

                l++;
            }

            // Valid window
            maxLen = Math.max(maxLen, r - l + 1);

            
        }
        return maxLen;
       
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> pmap=new HashMap<>();
        int sum=0;
        int count=0;
        pmap.put(0,1);
        for(int r=0;r<nums.length;r++){
                sum+=nums[r];
                if(pmap.containsKey(sum-k)){
                    count+=pmap.get(sum-k);
                }

                pmap.put(sum,pmap.getOrDefault(sum,0)+1);
        }
        return count;
        
    }
}
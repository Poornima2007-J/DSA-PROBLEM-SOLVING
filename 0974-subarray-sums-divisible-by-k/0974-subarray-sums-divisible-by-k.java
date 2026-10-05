class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         HashMap<Integer,Integer> pmap=new HashMap<>();
        int sum=0;
        int count=0;
        pmap.put(0,1);
        for(int r=0;r<nums.length;r++){
                sum+=nums[r];
                int rem=sum%k;

                if(rem<0) rem+=k;
                if(pmap.containsKey(rem)){
                    count+=pmap.get(rem);
                }

                pmap.put(rem,pmap.getOrDefault(rem,0)+1);
        }
        return count;
        
    }
}
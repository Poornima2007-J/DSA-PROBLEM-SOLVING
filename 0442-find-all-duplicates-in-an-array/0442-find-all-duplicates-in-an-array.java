class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int freq=map.getOrDefault(nums[i],0)+1;

            map.put(nums[i],freq);
        }
        List<Integer> res=new ArrayList<>();

        for(int j=0;j<nums.length;j++){
            if(map.get(nums[j])>1){
                res.add(nums[j]);
                 map.put(nums[j], 0); 
            }
        }

        return res;
    }
}
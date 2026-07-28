class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1); 
        
        int result = 0;
        int prefixSum = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            int remainder = prefixSum % k;
            if (remainder < 0) {
                remainder += k;
            }
            
            
            if (sumCountMap.containsKey(remainder)) {
                result += sumCountMap.get(remainder);
            }
            
           
            sumCountMap.put(remainder, 
                sumCountMap.getOrDefault(remainder, 0) + 1);
        }
        
        return result;
    }
}

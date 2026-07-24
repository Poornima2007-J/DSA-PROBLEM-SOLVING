class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxfreq=0;
        int totalfreq=0;
        
        for(int num : nums){
            int cfreq=map.getOrDefault(num,0)+1;
            map.put(num,map.getOrDefault(num,0)+1);
           
            if(cfreq>maxfreq){
                maxfreq=cfreq;
            }
        }
        
        for(int freq:map.values()){
            if(freq==maxfreq){
                totalfreq+=freq;
            }
        }
        return totalfreq;
    }
}
class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            // if(map.containsKey(ch))
            // {
                // map.put(ch,map.get(ch)+1);
                int newVal=map.getOrDefault(s.charAt(i),0)+1;
                map.put(s.charAt(i),newVal);
                ///keySet() used for getting an key value
            // }
            // else
            // {
            //     map.put(ch,1);
            // } 

            

    }
   int targetFreq = map.get(s.charAt(0));


for (int freq : map.values()) {
    if (freq != targetFreq) {
        return false;
    }
}
return true;

    // return new HashSet<>(map.values()).size() == 1;
   }       
}



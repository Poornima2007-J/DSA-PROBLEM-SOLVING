class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), freq);
        }

        int maxGroup = 0;
        int ansFreq = 0;

        // Check every frequency
        for (Map.Entry<Character, Integer> entry1 : map.entrySet()) {
            int count = 0;

            // Count how many characters have this frequency
            for (Map.Entry<Character, Integer> entry2 : map.entrySet()) {
                if (entry1.getValue().equals(entry2.getValue())) {
                    count++;
                }
            }

            // Update majority group
            if (count > maxGroup || (count == maxGroup && entry1.getValue() > ansFreq)) {
                maxGroup = count;
                ansFreq = entry1.getValue();
            }
        }

       
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == ansFreq) {
                sb.append(entry.getKey());
            }
        }
        
        return sb.toString(); // Perfect return type
    }
}

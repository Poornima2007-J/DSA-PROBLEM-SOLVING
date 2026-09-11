

class Solution {
    public int totalNumbers(int[] digits) {
        int[] digitCounts = new int[10];
        for (int d : digits) {
            digitCounts[d]++;
        }
        
        int count = 0;
        
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;        
            int d2 = (num / 10) % 10;  
            int d3 = num % 10;         
            
            int[] needed = new int[10];
            needed[d1]++;
            needed[d2]++;
            needed[d3]++;
            
            if (digitCounts[d1] >= needed[d1] && 
                digitCounts[d2] >= needed[d2] && 
                digitCounts[d3] >= needed[d3]) {
                count++;
            }
        }
        
        return count;
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] digitCounts = new int[10];
        for (int d : digits) {
            digitCounts[d]++;
        }
        
        List<Integer> validNumbers = new ArrayList<>();
        
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;        
            int d2 = (num / 10) % 10;  
            int d3 = num % 10;         
          
            int[] needed = new int[10];
            needed[d1]++;
            needed[d2]++;
            needed[d3]++;
             
            if (digitCounts[d1] >= needed[d1] && 
                digitCounts[d2] >= needed[d2] && 
                digitCounts[d3] >= needed[d3]) {
                validNumbers.add(num);
            }
        }
        
        int[] result = new int[validNumbers.size()];
        for (int i = 0; i < validNumbers.size(); i++) {
            result[i] = validNumbers.get(i);
        }
        
        return result;
    }
}

import java.util.Arrays;

public class Solution {
    public String smallestPalindrome(String s, int k) {
     
        int[] totalCounts = new int[26];
        for (char c : s.toCharArray()) {
            totalCounts[c - 'a']++;
        }
        
    
        String midChar = "";
        int[] halfCounts = new int[26];
        int halfLength = 0;
        
        for (int i = 0; i < 26; i++) {
            if (totalCounts[i] % 2 == 1) {
                midChar = Character.toString((char) ('a' + i));
            }
            halfCounts[i] = totalCounts[i] / 2;
            halfLength += halfCounts[i];
        }
        
        
        StringBuilder firstHalf = new StringBuilder();
        long currentK = k; 
        
        for (int pos = 0; pos < halfLength; pos++) {
            boolean placed = false;
            for (int i = 0; i < 26; i++) {
                if (halfCounts[i] > 0) {
                  
                    halfCounts[i]--;
                    

                    long perms = countPermutations(halfCounts, halfLength - 1 - pos);
                    
                    if (currentK <= perms) {
                        firstHalf.append((char) ('a' + i));
                        placed = true;
                        break; 
                    } else {
                        currentK -= perms;
                        halfCounts[i]++; 
                    }
                }
            }
            
            
            if (!placed) {
                return "";
            }
        }
        
 
        if (currentK > 1) {
            return "";
        }
        
     
        String left = firstHalf.toString();
        String right = firstHalf.reverse().toString();
        return left + midChar + right;
    }
    

    private long countPermutations(int[] counts, int remainingSlots) {
        if (remainingSlots == 0) {
            return 1;
        }
        
        long totalPerms = 1;
        long limit = 1000005; 
        
        for (int count : counts) {
            if (count > 0) {
                totalPerms *= nCr(remainingSlots, count, limit);
                remainingSlots -= count;
                
                if (totalPerms >= limit) {
                    return limit;
                }
            }
        }
        return totalPerms;
    }
    
  
    private long nCr(int n, int r, long limit) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r; 
        
        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1) / i;
            if (ans >= limit) {
                return limit;
            }
        }
        return ans;
    }
}

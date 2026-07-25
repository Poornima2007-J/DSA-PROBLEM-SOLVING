import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int res = 0;

            while (n > 0) {
                int r = n % 10;
                res = res + (r * r); 
                n /= 10;
            }
            n = res;
        }
        
        
        return n == 1;
    }
}

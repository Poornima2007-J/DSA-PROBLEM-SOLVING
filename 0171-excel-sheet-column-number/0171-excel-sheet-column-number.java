class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
       
        for (int i = 0; i < columnTitle.length(); i++) {
          
            int digit = columnTitle.charAt(i) - 'A';
            
           
            result = result * 26 + (digit + 1); 
        }
        
        return result;
    }
}

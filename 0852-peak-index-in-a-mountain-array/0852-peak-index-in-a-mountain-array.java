class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low < high) {
            int mid = (low+high) / 2;
            
            
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;    
            }
        }
        
        // At the end of the loop, low and high will point exactly to the peak index
        return low;
    }
}

import java.util.ArrayList;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        
        while (l < m && r < n) {
            if (nums1[l] < nums2[r]) {
                res.add(nums1[l]);
                l++;
            } else {
                res.add(nums2[r]);
                r++;
            }
        }
        
        
        while (l < m) { res.add(nums1[l]); l++; }
        while (r < n) { res.add(nums2[r]); r++; }
        
        
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res.get(i);
        }
    }
}
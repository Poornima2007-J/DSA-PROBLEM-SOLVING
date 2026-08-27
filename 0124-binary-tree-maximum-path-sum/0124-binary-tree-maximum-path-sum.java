class Solution {
   
    int max = Integer.MIN_VALUE; 
    
    public int maxPathSum(TreeNode root) {
       
        if (root == null) return 0;
        
        findMax(root);
        return max;
    }
    
    
    public int findMax(TreeNode root) {
        if (root == null) return 0;
      
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        
        int maxx = root.val + left + right;
        
        max = Math.max(max, maxx);
        
      
        return root.val + Math.max(left, right);
    }
}

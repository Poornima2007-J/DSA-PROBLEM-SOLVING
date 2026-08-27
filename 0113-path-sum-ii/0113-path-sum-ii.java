import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        dfs(root, targetSum, path, res);
        return res;
    }
    
    private static void dfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        
      
        path.add(root.val);
        
       
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
               
                res.add(new ArrayList<>(path)); 
            }
        } else {
           
            dfs(root.left, targetSum - root.val, path, res);
            dfs(root.right, targetSum - root.val, path, res);
        }
        
        
        path.remove(path.size() - 1);
    }
}

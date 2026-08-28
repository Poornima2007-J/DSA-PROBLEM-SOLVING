/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return buildTree(res, 0, res.size() - 1);
    }
    public void inorder(TreeNode root,List<Integer> res){
        if(root==null) return;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);

    }

    public static TreeNode buildTree(
        List<Integer> res,int l,int r){
       
        if(l>r) return null;
        int mid=(l+r)/2;

        TreeNode root=new TreeNode(res.get(mid));
         root.left=buildTree(res,l,mid-1);
         root.right=buildTree(res,mid+1,r);

         return root;

    }
}
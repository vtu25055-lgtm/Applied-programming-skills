import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            path += node.val;
            // If it's a leaf, add the path
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                path += "->";
                dfs(node.left, path, paths);
                dfs(node.right, path, paths);
            }
        }
    }
}
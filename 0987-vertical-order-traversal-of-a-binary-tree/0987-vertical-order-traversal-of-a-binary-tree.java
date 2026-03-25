import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // List to store (col, row, val)
        List<int[]> nodes = new ArrayList<>();
        
        // DFS traversal
        dfs(root, 0, 0, nodes);
        
        // Sort by col, then row, then val
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   // col
            if (a[1] != b[1]) return a[1] - b[1];   // row
            return a[2] - b[2];                     // val
        });
        
        // Group by column
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> colList = new ArrayList<>();
        
        for (int[] node : nodes) {
            int col = node[0], val = node[2];
            if (col != prevCol) {
                if (!colList.isEmpty()) {
                    result.add(colList);
                }
                colList = new ArrayList<>();
                prevCol = col;
            }
            colList.add(val);
        }
        result.add(colList); // add last column
        
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
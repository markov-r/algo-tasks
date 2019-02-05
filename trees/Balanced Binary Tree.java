public class Main {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(4);
        node.left.right.right = new TreeNode(4);
        node.right.left.left = new TreeNode(4);
        node.right.left.right = new TreeNode(4);
        node.left.left.left.left = new TreeNode(5);
        node.left.left.left.right = new TreeNode(5);
//        node.left.left.left = new TreeNode(4);
//        node.right.right = new TreeNode(4);
//        node.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(node));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int min;
    private static int max;

    private static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(root, 0);
        return max - min < 2;
    }

    private static void dfs(TreeNode node, int depth) {
        if (node.left == null || node.right == null) {
            min = Math.min(min, depth); max = Math.max(max, depth);
        }
        if (node.left != null) dfs(node.left, depth + 1);
        if (node.right != null) dfs(node.right, depth + 1);
    }
}
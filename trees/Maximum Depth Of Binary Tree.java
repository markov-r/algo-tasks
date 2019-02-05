public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//        node.right.right = new TreeNode(7);
//        node.right.left = new TreeNode(15);

//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(9);
//        node.left.left = new TreeNode(9);
//        node.left.left.left = new TreeNode(9);
//        node.left.left.left.left = new TreeNode(9);

        TreeNode node = null;

        System.out.println(maxDepth(node));
    }

    private static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int depth) {
        if (root == null) return depth;
        else depth++;
        return Math.max(dfs(root.left, depth), dfs(root.right, depth));
    }
}
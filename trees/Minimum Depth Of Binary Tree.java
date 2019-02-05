import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        System.out.println(minDepthBfs(node));

//        TreeNode node = null;
//        System.out.println(minDepthBfs(node));
    }

    private static int minDepthDfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepthDfs(root.left) ;
        int right = minDepthDfs(root.right);
        if (left == 0 || right == 0)
            return left + right + 1;
        return (left > right ? right : left) + 1; //return the smaller
    }

    private static int minDepthBfs(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Wrapper> queue = new LinkedList<>();
        queue.offer(new Wrapper(root, 1));
        while (queue.size() > 0) {
            Wrapper cur = queue.poll();
            if (cur.node.left == null && cur.node.right == null)
                return cur.depth;
            if (cur.node.left != null)
                queue.offer(new Wrapper(cur.node.left, cur.depth + 1));
            if (cur.node.right != null)
                queue.offer(new Wrapper(cur.node.right, cur.depth + 1));
        }
        return -1;
    }

    private static class Wrapper{
        TreeNode node;
        int depth;

        Wrapper(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
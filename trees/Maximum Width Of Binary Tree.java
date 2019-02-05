/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Main {
	
		public static void main(String[] args) {
			
		}
	
		/** Do a BFS and calculate the max width for each level
				Besides tree depth also keep track of the path leading 
				to each node, then use that to calculate the width. */
				
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxWidth = 1;
        int lastLevel = -1;
        Wrapper first = new Wrapper(root, 0, ""), last = new Wrapper(root, 0, "");
        Queue<Wrapper> queue = new LinkedList<>();
        queue.offer(new Wrapper(root, 0, ""));
        while (queue.size() > 0) {
            Wrapper cur = queue.poll();
            int level = cur.level;
            if (level > lastLevel) {
                int widthLevel = calcWidth(first.path, last.path);
                maxWidth = Math.max(maxWidth, widthLevel);
                first = cur;
                last = cur;
            }
            if (level == lastLevel) {
                last = cur;
            }
            lastLevel = level;

            if (cur.node.left != null)
                queue.offer(new Wrapper(cur.node.left, cur.level + 1, cur.path + "L"));
            if (cur.node.right != null)
                queue.offer(new Wrapper(cur.node.right, cur.level + 1, cur.path + "R"));
        }

        int widthLevel = calcWidth(first.path, last.path);      //calc last row
        maxWidth = Math.max(maxWidth, widthLevel);

        return maxWidth;
    }

    public int calcWidth(String left, String right) {
        int len = left.length();
        int width = (int) Math.pow(2, len); //max width is 2^len, 
        for (int i = 0; i < len; i++) {
            if (left.charAt(i) == 'R')
                width -= Math.pow(2, len - i - 1);
        }
        for (int i = 0; i < len; i++) {
            if (right.charAt(i) == 'L')
                width -= Math.pow(2, len - i - 1);
        }
        return width;
    }

    private class Wrapper{
        TreeNode node;
        int level;
        String path;

        Wrapper(TreeNode node, int level, String path) {
            this.node = node;
            this.level = level;
            this.path = path;
        }
    }

}
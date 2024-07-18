package algorithms.trees;

public class MorrisTraversalInorder {
    TreeNode root;

    private void morrisTraversal(TreeNode root) {
        if (root == null)
            return;

        TreeNode curr=root, prev;

        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;

                while (prev.right !=  null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        MorrisTraversalInorder tree = new MorrisTraversalInorder();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);

        tree.morrisTraversal(tree.root);
    }
}

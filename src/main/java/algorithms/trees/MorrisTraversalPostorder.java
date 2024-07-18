package algorithms.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MorrisTraversalPostorder {
    TreeNode root;

    private void morrisTraversal(TreeNode root) {
        if (root == null)
            return;
        List<Integer> result = new ArrayList<>();

        TreeNode curr=root, prev;
        while (curr != null) {
            if (curr.right == null) {
                result.add(curr.val);
                curr = curr.left;
            } else {
                prev = curr.right;

                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }

                if (prev.left == null) {
                    result.add(curr.val);
                    prev.left = curr;
                    curr = curr.right;
                } else {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }

        Collections.reverse(result);
        result.forEach(System.out::println);
    }

    public static void main(String[] args) {
        MorrisTraversalPostorder tree = new MorrisTraversalPostorder();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);

        tree.morrisTraversal(tree.root);
    }
}

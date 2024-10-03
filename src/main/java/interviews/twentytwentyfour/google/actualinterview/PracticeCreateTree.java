package interviews.twentytwentyfour.google.actualinterview;

import javafx.util.Pair;

import java.util.*;

public class PracticeCreateTree {
    /*
     * Problem Statement: You are given a list of <node_id, parent_id> which explains the child parent relationship
     * between the nodes. You have to print the tree starting from the root in an indented manner as shown below:
     *
     * Input:
     *  <d, b> (b is parent of d)
     *  <b, a> (a is parent of b)
     *  <c, a> (a is parent of c)
     *
     * Output:
     *   a
     *       b
     *           d
     *       c
     *
     * Input:
     *  <b, a> (a is parent of b)
     *  <c, a> (a is parent of c)
     *  <d, b> (b is parent of d)
     *  <e, b> (b is parent of e)
     *  <f, c> (c is parent of f)
     *  <g, c> (c is parent of g)
     *
     * Output:
     *  a
     *      b
     *          d
     *          e
     *      c
     *          f
     *          g
     *
     *
     * */

    class TreeNode {
        int val;
        Set<TreeNode> childs;

        public TreeNode(int val) {
            this.val = val;
            childs = new HashSet<>();
        }

        public TreeNode(int val, Set<TreeNode> childs) {
            this.val = val;
            this.childs = childs;
        }
    }

    TreeNode root;
    Map<Integer, TreeNode> treeMap = new HashMap<>();

    public PracticeCreateTree() {
        root = null;
        treeMap = new HashMap<>();
    }

    public void constructTree(List<int[]> input) {
        TreeNode childNode, parentNode;

        for (int[] arr: input) {
            int child = arr[0];
            int parent = arr[1];

            if (!treeMap.containsKey(child)) {
                childNode = new TreeNode(arr[0]);
                treeMap.put(child, childNode);
            } else
                childNode = treeMap.get(child);

            if (!treeMap.containsKey(parent)) {
                parentNode = new TreeNode(arr[1], new HashSet<>(Collections.singletonList(treeMap.get(arr[0]))));
                treeMap.put(parent, parentNode);
            } else {
                parentNode = treeMap.get(parent);
                parentNode.childs.add(childNode);
            }

            if (root == null || root == childNode)
                root = parentNode;
        }
    }

    public void printTree(List<int[]> input) {
        constructTree(input);
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> treeNodePair = stack.pop();
            TreeNode treeNode = treeNodePair.getKey();
            int level = treeNodePair.getValue();

            for (int i=0; i<level; i++) {
                System.out.print("\t\t");
            }
            System.out.println(treeNode.val);

            for (TreeNode child: treeNode.childs) {
                stack.push(new Pair<>(child, level+1));
            }
        }
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{2, 1});
        input.add(new int[]{3, 1});
        input.add(new int[]{4, 2});
        input.add(new int[]{5, 2});
        input.add(new int[]{6, 3});
        input.add(new int[]{7, 3});

        PracticeCreateTree practiceCreateTree = new PracticeCreateTree();
        practiceCreateTree.printTree(input);
    }
}
package interviews.twentytwentyfour.google.actualinterview;

import javafx.util.Pair;

import java.util.*;

public class CreateTree {
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

    /*My algorithm:
    * 1. create the tree from the given input
    * 2. start DFS from root covering one branch of the tree at once
    * 3. keep track of the level and introduce indentation accordingly
    * */

    class TreeNode {
        int val;
        Set<TreeNode> childs;

        public TreeNode(int val) {
            this.val = val;
            this.childs = new HashSet<>();
        }

        public TreeNode(int val, Set<TreeNode> childs) {
            this.val = val;
            this.childs = childs;
        }
    }

    TreeNode root;
    Map<Integer, TreeNode> nodeMap;

    public CreateTree() {
        root = null;
        nodeMap = new HashMap<>();
    }

    public void constructTree(List<int[]> input) {
        TreeNode childNode, parentNode;

        for (int i=0; i<input.size(); i++) {
            int child = input.get(i)[0];
            int parent = input.get(i)[1];

            if (!nodeMap.containsKey(child)) {
                childNode = new TreeNode(child);
                nodeMap.put(child, childNode);
            } else {
                childNode = nodeMap.get(child);
            }

            if (!nodeMap.containsKey(parent)) {
                parentNode = new TreeNode(parent, new HashSet<>(Collections.singletonList(childNode)));
                nodeMap.put(parent, parentNode);
            } else {
                parentNode = nodeMap.get(parent);
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
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            int level = p.getValue();

            for (int i=0; i<level; i++) {
                System.out.print("\t\t");
            }
            System.out.print(node.val + "\n");

            for (TreeNode childNode : node.childs) {
                stack.push(new Pair<>(childNode, level+1));
            }
        }
    }

    public static void main(String[] args) {
        CreateTree createTree = new CreateTree();
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{3, 1});
        input.add(new int[]{1, 0});
        input.add(new int[]{2, 0});

        createTree.printTree(input);

        System.out.println("\n\n\n*****************\n\n\n");

        createTree = new CreateTree();
        List<int[]> input2 = new ArrayList<>();
        input2.add(new int[]{1, 0});
        input2.add(new int[]{2, 0});
        input2.add(new int[]{3, 1});
        input2.add(new int[]{4, 1});
        input2.add(new int[]{5, 2});
        input2.add(new int[]{6, 2});

        createTree.printTree(input2);
    }
}
package interviews.twentytwentyone.enthire;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AllRootToLeafPaths {
    List<List<Integer>> result = new ArrayList<>();

    private List<Integer> deepCopy(List<Integer> subResult){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<subResult.size(); i++)
            list.add(subResult.get(i));
        return list;
    }

    public void rootToLeaf(TreeNode root, List<Integer> subResult){
        if(root == null)
            return;

        List<Integer> list = deepCopy(subResult);
        list.add(root.val);
        if (root.left == null && root.right == null){
            result.add(list);
            return;
        }

        rootToLeaf(root.left, list);
        rootToLeaf(root.right, list);
        return;
    }

    public void print(TreeNode root){
        if (root == null)
            return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        AllRootToLeafPaths allRootToLeafPaths = new AllRootToLeafPaths();
        allRootToLeafPaths.rootToLeaf(root, new ArrayList<>());
        System.out.println(allRootToLeafPaths.result);
        //allRootToLeafPaths.print(root);
    }
}

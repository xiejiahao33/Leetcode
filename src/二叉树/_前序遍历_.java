package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历：先访问根节点，再前序遍历左子树，再前序遍历右子树
 */


public class _前序遍历_ {
    //node节点的定义
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //前序递归
    private void preorder(TreeNode root, List<Integer> result){
        if (root==null) return;
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }


    //前序非递归
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>(); //存储结果
        Stack<TreeNode> stack = new Stack<>();    //辅助栈

        while (root!=null || !stack.isEmpty()){
            //遍历栈,把它加到结果列表
            while (root!=null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //遍历右子树
            root = stack.pop().right;
        }
        return result;
    }

    //分治法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if(root==null) return  result;

        //Divide
        List<Integer> left =  preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);


        //Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }
}

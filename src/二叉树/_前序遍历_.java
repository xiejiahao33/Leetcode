package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历：先访问根节点，再前序遍历左子树，再前序遍历右子树
 */


public class _前序遍历_ {


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
    public static List<Integer> preorderTraversal(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = preorderTraversal(root);
        System.out.println("层序遍历:"+  result);
    }
}

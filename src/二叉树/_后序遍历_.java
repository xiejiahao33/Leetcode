package 二叉树;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历：先后序遍历左子树，再后序遍历右子树，再访问根节点
 比如说，给你的二叉树是：

    1
  /   \
 2    3
 \
 4

 你要返回的后序遍历序列是：

 [4, 2, 3, 1]
 */
public class _后序遍历_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归写法
    private void postorder(TreeNode root, List<Integer> result){
        if (root==null) return;

        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversalRecursive1(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }

    //递归写法
    /**
     *遍历顺序是左右根,从根节点开始访问左子树，左子树的顺序也是左右根，所以总是会最先访问最左边。
     * 第一步:入栈当前节点，不断访问左子树
     * 第二步:访问左子树到空节点时,将它移动到栈顶节点的右节点
     * 重复之前操作访问所有左子树节点
     *
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode pre = null ; //记录上一次出栈的节点
        while (!s.isEmpty() || root!=null ){
            if(root!=null){
                s.push(root);
                root = root.left;
            }else {
                root = s.peek().right;
                if(root==null || root==pre){
                    pre  = s.pop(); //栈顶元素出栈 更新pre
                    result.add(pre.val);
                    root = null;//避免因为root 等于pre 而进入这一条语句
                }
            }

        }
        return result;
    }


    /**
     * 这个的思路是根据后序遍历是 左右根
     * 所有使用一个链表，先存储根的值在最后面，然后不断往根的前面插入右子树，左子树
     * 因为栈的压入顺序和出来顺序是相反的，所以压入时是先压入 左子树和右子树
     *
     *
     */
    public List<Integer> inorderTraversalIterative2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        return result;
    }

    //分治法
    public List<Integer> postorderTraversalRecursive2(TreeNode root) {

        if(root==null) return new ArrayList<>();

        List<Integer> left = postorderTraversalRecursive2(root.left);
        List<Integer> right= postorderTraversalRecursive2(root.right);


        left.addAll(right);
        left.add(root.val);

        return left;
    }
}

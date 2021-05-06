package 牛客;



import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class NC15_层序遍历 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here

        if (root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            ArrayList<Integer> tmp  = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }

            res.add(tmp);

        }




        return res;
    }
}

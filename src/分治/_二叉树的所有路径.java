package 分治;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。

 样例
 样例 1:

 输入：{1,2,3,#,5}
 输出：["1->2->5","1->3"]
 解释：
    1
  /   \
 2     3
 \
 5
 样例 2:

 输入：{1,2}
 输出：["1->2"]
 解释：
  1
 /
 2
 */
public class _二叉树的所有路径 {

    //dfs算法
    private void dfs(TreeNode root, String path, List<String> result) {
        if(root==null) return;
        path += root.val;

        //leaf
        if(root.left ==null && root.right==null){
            result.add(path);
        }else {
            path+="->";
            dfs(root.left,path,result);
            dfs(root.right,path,result);
        }


    }

    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result  = new ArrayList<>();
        dfs(root,"",result);
        return result;
    }


    //分治算法
    public List<String> binaryTreePathsDivide(TreeNode root){
        List<String> paths = new ArrayList<>();

        if (root==null) return paths;

        //leaf
        if(root.right==null && root.left==null){
            paths.add(root.val+"");
            return paths;
        }

        //divide
        List<String> left = binaryTreePathsDivide(root.left);
        List<String> right = binaryTreePathsDivide(root.right);

        //merge
        for (String path:left) {
            paths.add(root.val+"->"+path);
        }

        for (String path:right) {
            paths.add(root.val+"->"+path);
        }

        return paths;
    }
}

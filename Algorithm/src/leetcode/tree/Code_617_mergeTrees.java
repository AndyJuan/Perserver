package leetcode.tree;

import java.util.LinkedList;

/**
 * 方法： 按前序遍历——递归——深度优先遍历
 *
 *算法流程： 先合并root节点，再递归合并左右子节点，最后再返回root节点，如此不断递归
 *
 * 时间复杂度：O(min(m,n)), m,n 分别是两个二叉树的节点个数
 * 空间复杂度：O(min(m,n)), 空间复杂度取决于递归调用的层数
 */
public class Code_617_mergeTrees {

    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 ==null){
            return null;
        }

        if(t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);

        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);

        return root;
    }
}

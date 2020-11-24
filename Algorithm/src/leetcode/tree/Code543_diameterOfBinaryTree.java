package leetcode.tree;

/**
 * 递归： 深度优先遍历
 *        类似后序遍历： 任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到
 *        递归函数求该节点为根的子树的深度为  max(L,R)+1 , 定义一个全局变量，记录这个最大值
 */
public class Code543_diameterOfBinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root){
        getDepth(root);
        return ans;
    }
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getDepth(root.left); // 左儿子为根的子树的深度
        int right = getDepth(root.right);  // 右儿子为根的子树的深度

        ans = Math.max(ans,left+right); // 计算当前节点的直径 left+right+1, 并更新ans

        return Math.max(left,right)+1; // 返回该节点为根的子树的深度
    }
}

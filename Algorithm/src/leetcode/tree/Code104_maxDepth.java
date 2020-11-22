package leetcode.tree;

/**
 *算法流程： 深度优先遍历（DFS）
 *     找出终止条件：当前节点为空
 *     找出返回值：节点为空时说明高度为 0，所以返回 0；节点不为空时则分别求左右子树的高度的最大值，同时加1表示当前节点的高度，返回该数值
 *     某层的执行过程：在返回值部分基本已经描述清楚
 *
 * 时间复杂度：O(N)
 * 空间复杂度: O(height),height为树的高度
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/hua-jie-suan-fa-104-er-cha-shu-de-zui-da-shen-du-b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Code104_maxDepth {
    public int maxDepth (TreeNode root){
        if (root == null){
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}

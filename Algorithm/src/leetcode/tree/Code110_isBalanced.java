package leetcode.tree;


/**
 * 方法1： 递归(深度优先遍历)——前序遍历——自顶向下方法
 *           遍历到当前节点，判断左右子树的高度差是否不超过了，如果不超过，再遍历左右子树是否是平衡二叉树
 *
 *           时间复杂度：O(N^2)
 *           时间复杂度：O(n ^ 2)其中 n 是二叉树中的节点个数。
 * 最坏情况下，二叉树是满二叉树，需要遍历二叉树中的所有节点，时间复杂度是 O(n)。
 * 对于节点 pp，如果它的高度是 dd，则 height(p) 最多会被调用 d 次（即遍历到它的每一个祖先节点时）。
 * 对于平均的情况，一棵树的高度 h 满足 O(h)=O(log n)，因为 d \≤h，所以总时间复杂度为 O(nlogn)。
 * 对于最坏的情况，二叉树形成链式结构，高度为 O(n)，此时总时间复杂度为 O(n^2)
 *
 * 空间复杂度：O(n)，其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
 *
 * 方法2： 递归(深度优先遍历)——后序遍历——自低向上方法
 *         先分别看左右子树是否满足，最后再求当前节点的左右子树的高度，这样自底向上的方法，不会重复求高度
 *
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Code110_isBalanced {

    /**
     * 自顶向下方法
     * @param root
     * @return
     */
    public boolean isBalanced1 (TreeNode root){
        if (root == null){
            return true;
        }else {
            return Math.abs(depth1(root.left)-depth1(root.right))<=1 && isBalanced1(root.left) && isBalanced1(root.right);
        }

    }

     public static int depth1(TreeNode root){
        if (root == null){
            return 0;
        }else {
            return Math.max(depth1(root.left),depth1(root.right))+1;
        }
    }

    /**
     * 自底向上方法
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root){
        return depth2(root)>=0;
    }

    public  static  int depth2(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = depth2(root.left);
        int rightHeight = depth2(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }

    }
}

package leetcode.tree;


import java.util.LinkedList;


/**
 * 递归方法： 深度优先搜索
 *           按前序遍历，先比较中节点，再比较左节点，再比较右节点是否相等
 *
 * 时间复杂度：
 *          O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。
 *          对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不
 *          为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
 *
 * 空间复杂度：
 *          O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。空间复
 *          杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，
 *          最坏情况下，二叉树的高度等于节点数。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/same-tree/solution/xiang-tong-de-shu-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 迭代方法： 广度优先搜索（前序遍历）
 *        通过两个队列，通过迭代的方式，先中节点压入队列中，
 *        再弹出队头节点，比较队列中的两个节点是否相等，
 *        再比较左右节点是否是都同时为null，最后左右节点分别压入队列中
 */
public class Code_100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null ){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 迭代算法： 广度优先搜素
     */

    public boolean isSameTreeIteration(TreeNode p, TreeNode q){
            if (p == null && q == null){
                return true;
            }

            if (p == null || q == null){
                return false;
            }

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode temp1 =queue1.removeFirst();
            TreeNode temp2 =queue2.removeFirst();


            if (temp1.val != temp2.val){
                return false;
            }

            // ^表示异或，只要两个不相等，就返回false
            if (temp1.left == null ^ temp2.left == null){
                return false;
            }

            if (temp1.right == null ^ temp2.right == null){
                return false;
            }

            if (temp1.left != null){
                queue1.add(temp1.left);
            }

            if (temp1.right != null){
                queue1.add(temp1.right);
            }

            if (temp2.left != null){
                queue2.add(temp2.left);
            }

            if (temp2.right != null){
                queue2.add(temp2.right);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}

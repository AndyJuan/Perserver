package leetcode.tree;


import java.util.LinkedList;

public class Code_101_isSymmetric {

    /**
     * 方法1： 递归
     * 相当于前序遍历，递归时判断两个节点是否都为空，不都为空则返回false，再判断左右节点的内容是否相等，
     * 再递归比较左右节点是否对称
     *
     * 算法的时间复杂度是 O(n)，因为要遍历 n 个节点
     * 空间复杂度是 O(n)，空间复杂度是递归的深度，也就是跟树高度有关，最坏情况下树变成一个链表结构，高度是 n。
     *
     *
     *
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    public  boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }
        return isSymmetric(left.left , right.right) && isSymmetric(left.right,right.left);
    }


    /**
     * 迭代算法：
     * 通过一个队列实现，前序遍历二叉树节点，再比较两个节点是否相等
     *
     * 时间复杂度： O(N)
     * 空间复杂度： O(N)
     */
    public boolean isSymmetricIteration(TreeNode root){
        if (root == null || (root.left==null && root.right==null)){
            return true;
        }
        LinkedList<TreeNode>  queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (queue.size()>0){
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();

            if (left == null && right == null){
                continue;    //这个地方不能写return true，还要继续下面的判断
            }

            if (left == null || right == null){
                return false;
            }

            if (left.val != right.val){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);

        }

        return true;
    }
}

package leetcode.tree;


import java.util.LinkedList;

/**
 * 方法1： 后序遍历二叉树——递归——深度优先遍历
 *            从根节点开始遍历递归，先从叶子节点开始翻转，
 *            先翻转左子树，再翻转右子树，
 *            再把翻转后的左子树给根节点的右节点，翻转后的右子树给左子节点
 *
 *     时间复杂度： O(N)——每个元素都必须访问
 *     空间复杂度： O(h)——树的高度，最坏情况下，需要存放O(H)个函数调用
 *
 *  方法2： 后序遍历二叉树——迭代——广度优先遍历
 *              通过队列层层把节点压入队列中，先把根节点压入队列中，再交换根节点的左右子节点，
 *              然后再把左右节点压入队列中进行循环操作
 *
 *      时间复杂度： O(N)——每个元素都必须访问
 *  *   空间复杂度： O(N)——最坏情况下，需要访问所有的叶子节点，完全二叉树叶子节点是 n/2 个
 */
public class Code_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTreeInteration(TreeNode root){
        if (root == null){
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();

            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            if (temp.left != null){
                queue.add(temp.left);
            }

            if (temp.right !=null){
                queue.add((temp.right));
            }

        }

        return root;
    }

}

package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *中序遍历： 中 左 右
 *
 * 迭代解法
 *
 * 算法流程：
 *      用一个栈，treenode = root, treenode进栈顺序： 先把treenode的左节点全部压入栈中，
 *     然后 node = stack.pop 遍历中节点（也就是栈中弹出的节点），最后再右节点 treenode = node.right
 *
 * 递归算法
 *
 * 算法流程：先打印 左 节点 ，再递归 中 ，最后递归 右
 *
 */
public class Code94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack =new Stack<>();
        TreeNode treeNode = root;
        while (treeNode!=null || !stack.isEmpty()){

            while (treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);

            treeNode = node.right;
        }
        return list;

    }


    /**
     * @description
     * 递归算法
     * @param root
     * @return
     */
    public List<Integer> inorderRecur(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        inorderRecur(root,list);
        return list;
    }

    public void inorderRecur(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorderRecur(root.left,list);
        list.add(root.val);
        inorderRecur(root.right,list);
    }


    /**
     *   如果只是打印，则递归算法只要一个函数
     */

    public void preorderRecurPrint(TreeNode treeNode){
        if (treeNode == null){
            return;
        }

        preorderRecurPrint(treeNode.left);
        System.out.println(treeNode.val);
        preorderRecurPrint(treeNode.right);
    }
}

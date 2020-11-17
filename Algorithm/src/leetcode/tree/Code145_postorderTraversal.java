package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *后序遍历：  左 右 中
 *
 * 迭代解法
 *
 * 算法流程：
 *      前序遍历是 中 左 右，压栈过程是 中 右 左，到了中节点直接打印， 所以压栈过程不是 中 左 右，
 *      后续遍历是 左 右 中，压栈过程是 中 左 右，刚好和前序遍历相反，但压栈过程不是一样的
 *      再将这个全部压入栈中，再弹出来倒序打印
 *
 * 递归算法
 *
 * 算法流程：先打印 左 节点 ，再递归 右 ，最后递归 中
 *
 */
public class Code145_postorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list =new LinkedList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode treeNode = stack1.pop();
            // 跟前序遍历相比，只要把list.add换成stack2的压栈过程即可
            stack2.push(treeNode);

            if (treeNode.left != null){
                stack1.push(treeNode.left);
            }

            if (treeNode.right != null){
                stack1.push(treeNode.right);
            }
        }

        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;

    }

    /**
     * 递归算法: 用list保存value
     * @param root
     * @return
     */
    public List<Integer> postorderRecur(TreeNode root){
        List<Integer> list =new LinkedList<>();
        if (root == null){
            return list;
        }
        postorderRecur(root,list);
        return list;
    }

    public void postorderRecur(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }

        postorderRecur(root.left,list);
        postorderRecur(root.right,list);
        list.add(root.val);
    }

    /**
     *   如果只是打印，则递归算法只要一个函数
     */

    public void preorderRecurPrint(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        preorderRecurPrint(treeNode.left);
        preorderRecurPrint(treeNode.right);
        System.out.println(treeNode.val);
    }
}

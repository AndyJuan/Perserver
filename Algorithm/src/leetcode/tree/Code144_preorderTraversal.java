package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *前序遍历： 中 左 右
 *
 * 迭代解法
 *
 * 算法流程：
 *      用一个栈，进栈顺序： 中 右 左 →出栈 ： 中 左 右
 *      root先压入栈中，然后 treenode = stack.pop()，再把treenode的左右不为空的节点都压入栈中
 *
 * 递归算法
 *
 * 算法流程：先打印 中 节点 ，再递归 左 ，最后递归 右
 *
 */
public class Code144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if (treeNode.right != null){
                stack.push(treeNode.right);
            }

            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return list;
    }

    public List<Integer> preorderRecur(TreeNode root){
        List<Integer> list = new LinkedList<>();
        preorderRecur(root,list);
        return list;
    }

    public void preorderRecur(TreeNode root, List<Integer> list){
        if (root == null){
            return ;
        }
        list.add(root.val);
        preorderRecur(root.left,list);
        preorderRecur(root.right,list);
    }

    /**
     *   如果只是打印，则递归算法只要一个函数
     */

    public void preorderRecurPrint(TreeNode treeNode){
        if (treeNode == null){
            return;
        }

        System.out.println(treeNode.val);
        preorderRecurPrint(treeNode.left);
        preorderRecurPrint(treeNode.right);
    }
}



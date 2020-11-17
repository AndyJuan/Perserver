package leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 *
 * 算法流程：1、如果 c 是右括号的一种，则压入栈
 *           2、否则弹出栈中对应的括号, 并判断是否是成对的括号中的一种，如果不是那三种情况之一或者栈已经为空栈了，则直接false返回
 *           3、最后返回栈是否为空栈
 *
 * 时间复杂度; O(N) 正确的括号组合需要遍历 11 遍 s
 * 空间复杂度; O(N) 栈使用线性的空间大小
 */
public class Code20_validBracket {
    public boolean isValid(String s){
        if (s.length()%2!=0){
            return false;
        }

        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                boolean b1 = c == ')' && pop == '(';
                boolean b2 = c == ']' && pop == '[';
                boolean b3 = c == '}' && pop == '{';

                // b1，b2，b3中最多只能有1个true
                if ( !(b1 || b2 || b3)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

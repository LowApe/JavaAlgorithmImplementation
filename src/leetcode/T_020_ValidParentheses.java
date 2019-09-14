package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效括号
 * 1.左括号压入栈
 * 2.右括号弹出并检查是否匹配
 * 3.栈为空
 */
public class T_020_ValidParentheses {
    public static void main(String[] args) {
        String s="([)()()()";
        System.out.println(isValid(s));
    }

    /**
     *
     * 复杂度分析:
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param s
     * @return
     */
    public static boolean isValid(String s){
        int len = s.length();
        if(len==0){//边界判断
            return true;
        }
        HashMap<Character,Character> map = new HashMap<>();//hash 表记录匹配规则,key为右括号是为了检查匹配
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(char val : s.toCharArray()){//遍历string中的字符
            if(val=='(' || val=='{' || val=='['){//1.如果左括号就压入栈
                stack.push(val);
            }

            if((val==')' || val=='}' || val==']')&&(stack.isEmpty() || stack.pop()!=map.get(val))){//如果右括号并且栈为空或栈pop出的并不匹配则无效
                return false;
            }
        }
        return stack.isEmpty();//栈中不能有元素
    }
}

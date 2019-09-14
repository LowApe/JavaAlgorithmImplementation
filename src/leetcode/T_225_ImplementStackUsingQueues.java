package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * leetcode-225-用队列实现栈
 * 思路:准备两个队列，根据队列的特点
 * pop的最后一个元素是模仿栈的栈顶
 * 将前面的元素放入准备好的队列
 * 下一次从另一方的队列开始pop
 */
public class T_225_ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }

    static class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private int top;
        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q1=new LinkedList<>();
            q2=new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q1.add(x);//添加到队列1
            top=x;//记录栈顶,最后添加到队列的就是栈需要的栈顶
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while(q1.size()>1){
                top=q1.remove();//删除后的top
                q2.add(top);
            }
            int remove=q1.remove();//删除q1最后一个元素就是要 pop 出的元素
            Queue<Integer> temp = q1;//交换q1和q2让循环继续
            q1 = q2;
            q2 = temp;
            return remove;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if(!q1.isEmpty())
                return top;
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}

package leetcode;

import java.util.Stack;

/**
 * leetcode 232 stack 实现 queue
 */
public class T_232_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
    /**
     * 1. 将元素压入s1
     * 2. pop 将s1 导入 s2 并pop
     * 3.
     */
    static class MyQueue {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        private int front;//队首元素
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(s1.isEmpty()){//如果s1队列为空则
                front=x;
            }
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(!s2.isEmpty()){
                return s2.peek();
            }
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(s1.isEmpty()){
                return s2.isEmpty();
            }
            return false;
        }
}


}



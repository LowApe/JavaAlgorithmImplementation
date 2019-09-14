package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 * 1.规定时间是否停止
 * 2.经过记录到set并判断
 * 3.快慢指针相遇
 */
public class T_141_LinkedListCycle {
    public static void main(String[] args) {
        //        节点初始化 1->2->3->4->5->null
        ListNode initList = new ListNode(1);
        printInit(initList);
        //哈希表
//        System.out.println(hasCycle1(initList));

        //快慢执政
        System.out.println(hasCycle2(initList));
    }
    /**
     *  简单单链表
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        };
    }

    /**
     *  打印初链表
     * @param listNode
     */
    public static void printInit(ListNode listNode){
        ListNode curr = listNode;
        System.out.print(listNode.val);
        for (int i = 2; i < 6; i++) {
            System.out.print("->");
            curr.next=new ListNode(i);
            curr=curr.next;
            System.out.print(curr.val);
        }
        System.out.println();
    }

    /**
     * 哈希表(遍历所有结点并在哈希表中存储每个结点的引用)
     * 复杂度分析
     * 时间复杂度:O(n)
     * 空间复杂度:O(n) 空间取决于添加到哈希表中的元素数目,最多可以添加 n 个元素
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head){
        Set<ListNode> nodesSeen=new HashSet<>();//创建一个存储节点 hash 表
        while(head!=null){//如果头不为空就进行遍历
            if(nodesSeen.contains(head)){//如果 hash 表有就表示是环
                return true;
            }else{
                nodesSeen.add(head);//遍历的同时添加到 hash 表中
            }
            head = head.next;//head指向下一个节点
        }
        return false;
    }

    /**
     * 双指针(不同的速度在遇到环是会发生相遇的情况)
     * 复杂度分析
     * 时间复杂度:O(n)
     * 空间复杂度:O(1) 我们只使用了慢指针和快指针两个结点,所有空间复杂度 O(1)
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;//一开始保证不相同的位置上
        ListNode fast = head.next;
        while(slow!=fast){
            if(fast==null || fast.next == null){//判断快指针到null
                return false;
            }
            slow = slow.next;//慢指针移动1个节点
            fast = fast.next.next;//快指针移动2个节点
        }
        return true;
    }
}

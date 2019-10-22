package leetcode;

/**
 * leetcode 206 反转链表
 */
public class T_206_ReverseLinkedList {
    public static void main(String[] args) {
//        节点初始化 1->2->3->4->5->null
        ListNode initList = new ListNode(1);
        printInit(initList);
//        反转操作1
//        ListNode afterList= reverseList1(initList);
//        while(afterList!=null){
//            System.out.print(afterList.val);
//            System.out.print("->");
//            afterList=afterList.next;
//        }
//        反转操作2
        ListNode after2List = reverseList2(initList);
        while(after2List!=null){
            System.out.print(after2List.val);
            System.out.print("->");
            after2List=after2List.next;
        }
    }

    /**
     *
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
     *  简单单链表
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;};
    }

    /**
     *  迭代法
     *  反转链表操作方法
     * 复杂度分析:
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param head //头节点
     * @return //返回反转后的头节点
     */
    public static ListNode reverseList1(ListNode head){
        ListNode prev = null;//每个节点需要反转的节点
        ListNode curr = head;//当前节点
        while(curr!=null){//向前遍历
            ListNode nextTemp=curr.next; //将下一个节点的"链"存起来
            curr.next = prev;//将指向反转
            prev = curr;//将需要被连接的"节点"向前移动
            curr = nextTemp;//当前指向下一个节点
        }
        return prev;
    }

    /**
     * 递归
     * 反转链表操作方法
     * 复杂度分析:
     * 时间复杂度:O(n)
     * 空间复杂度:O(n) 使用递归,将会使用隐式栈空间.递归深度可能会达到 n 层
     * @param head //头节点
     * @return //返回反转后的头节点
     */
    public static ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){//递归的基准条件
            return head;
        }
        /**
         * 重新debug 了一下，发现之前理解错了，这些节点并没有移动，而是链表的形式不断增。
         */
        ListNode p = reverseList2(head.next);//递归从下一个节点开始的链表进行反转
        head.next.next =head;//将下一节点指向进行反转
        head.next = null;
        return p;
    }
}

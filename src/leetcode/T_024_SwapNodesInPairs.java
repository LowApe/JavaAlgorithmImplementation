package leetcode;

/**
 * leetcode 24 链表两两交换
 */
public class T_024_SwapNodesInPairs {
    public static void main(String[] args) {
        //        节点初始化 1->2->3->4->5->null
        ListNode initList = new ListNode(1);
        printInit(initList);
        //非递归
        ListNode after1List = swapPairs1(initList);
        while(after1List!=null){
            System.out.print(after1List.val);
            System.out.print("->");
            after1List=after1List.next;
        }

        //递归
//        ListNode after2List = swapPairs1(initList);
//        while(after2List!=null){
//            System.out.print(after2List.val);
//            System.out.print("->");
//            after2List=after2List.next;
//        }
    }

    /**
     * 非递归
     * 两两交换操作方法
     * 复杂度分析:
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head){
            ListNode thead=new ListNode(0);//初始化一个节点
            thead.next = head;//指向头部,转换后返回头节点
            ListNode temp = thead;//添加一个需要变化的临时节点
            while(temp.next!=null && temp.next.next!=null){//判断两个不能为空
                ListNode start = temp.next;//将新的链表中跳出两两的标志t(新头)->1(start)->2(end)->...
                ListNode end = temp.next.next;
                temp.next = end;//交换
                start.next = end.next;
                end.next = start;
                temp = start;//将头指向 start接着循环后面的
            }
            return thead.next;
    }

    /**
     * 递归法
     * 两两交换操作方法
     * 复杂度分析:
     * 时间复杂度:O(n)
     * 空间复杂度:O(n) 使用递归,将会使用隐式栈空间.递归深度可能会达到 n 层
     * @param head //头节点
     * @return //返回转换后的头节点
     */
    public static ListNode swapPairs1(ListNode head){
        if(head==null || head.next ==null){//判断第一个节点和第二个节点不为空才进行比较
            return head;
        }
        ListNode next = head.next;//创建一个节点记录下个节点
        head.next = swapPairs1(next.next);//交换后指向后面排好的链表
        next.next = head;//连接"第二个节点"head因为上面所以换到的二号位
        return next;
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
}

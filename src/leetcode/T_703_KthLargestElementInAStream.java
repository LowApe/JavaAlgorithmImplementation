package leetcode;

import java.util.PriorityQueue;

/**
 * 703-leetcode 返回数据流中的第K个值
 * 方法1:进行排序在寻找 N*KlogK
 * 方法2:优先队列(最小堆来进行最大值堆的管理)
 */
public class T_703_KthLargestElementInAStream {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3,arr);
        System.out.println(kthLargest.add(10));
    }

     static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap  = new PriorityQueue<>();
            for(int a : nums){
                add(a);
            }
        }

         /**
          * 向小顶堆添加元素
          * @param val
          * @return
          */
        public int add(int val) {
            if(minHeap.size()<k){//如果小于最大元素就继续添加
                minHeap.offer(val);//加入小顶堆
            }else if(minHeap.peek()<val){//如果加入的元素比小顶堆最小的还打，就加入
                minHeap.poll();//顶掉最小
                minHeap.offer(val);//重新调整
            }
            return minHeap.peek();
        }
    }
}

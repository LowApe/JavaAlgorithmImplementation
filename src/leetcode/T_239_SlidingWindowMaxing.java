package leetcode;

import java.util.ArrayDeque;

/**
 * 239-leetcode 滑动窗口最大值
 * 方法1:暴力法-直接遍历每一个滑动窗口,找到每个窗口的最大值（N-K+1个滑动窗口）时间复杂度O(Nk)
 * 方法2:双向队列,使用堆,因为在最大堆中 heap[0] 永远是最大的元素。在大小为 k 的堆中插入一个元素消耗log(k)
 * 方法3:动态规划
 */
public class T_239_SlidingWindowMaxing {
    public static void main(String[] args) {

    }

    /**
     * 方法1
     * 复杂度:
     * 时间复杂度:O(Nk)其中 N为数组中元素个数
     * 空间复杂度:O(N-K+1)用于输出数组
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;//最大长度
        if(n*k == 0)//如果滑动窗口为0则没有输出
            return new int[0];
        int[] output = new int[n-k+1];//输出结果的数组 共有n-k+1个滑动窗口
        for(int i=0;i<n-k+1;i++){//有多少个滑动窗口
            int max = Integer.MIN_VALUE;//记录每个滑动窗口的最大值
            for(int j=i;j<i+k;j++){//遍历每一个滑动窗口的
                max = Math.max(max,nums[j]);//比较并得出最大值
            }
            output[i] = max;//将最大值存储到数组中
        }
        return output;
    }

    /**
     * 方法2 双向队列
     * 复杂度分析
     * 时间复杂度：O(N)，每个元素被处理两次- 其索引被添加到双向队列中和被双向队列删除。
     * 空间复杂度：O(N)，输出数组使用了 O(N−k+1) 空间，双向队列使用了 O(k)。
     * @param nums
     * @param k
     * @return
     */
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;//总长度
        if(n*k==0) return new int[0];//边界
        if(k==1)return nums;

        this.nums = nums;
        int max_idx = 0;//最大值索引
        for(int i=0;i<k;i++){//滑动窗口
            clean_deque(i,k); //清理双向队列
            deque.addLast(i);//添加索引
            if(nums[i] > nums[max_idx]){//获取最大索引
                max_idx = i;
            }
        }
        int[] output = new int[n-k+1];
        output[0] = nums[max_idx];

        for(int i=k ;i<n;i++){//几个滑动窗口
            clean_deque(i,k);
            deque.addLast(i);
            output[i-k+1] = nums[deque.getFirst()];
        }
        return output;
    }

    /**
     * 清理双向队列
     * @param i 索引
     * @param k 滑动窗口大小
     */
    public void clean_deque(int i,int k){
        if(!deque.isEmpty() && deque.getFirst()==i-k){
            deque.removeFirst();
        }
        while(!deque.isEmpty() && nums[i]>nums[deque.getLast()]){//移除比当前元素小的所有元素, 它们不可能是最大的
            deque.removeLast();
        };
    }


    /**
     * 方法3 动态规划
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        return null;
    }

}

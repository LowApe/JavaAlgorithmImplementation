/**
 * 二分查找
 */
public class BinarySearch {
    /**
     *
     * @param objects   有序数组
     * @param searchValue   查询的数值
     * @return 返回下标;-1 表示没有
     */
    public static int search(int[] objects, int searchValue) {
        int low = 0;
        int high = objects.length - 1;
        int mid = 0; //向下取整
        while (low<=high){//当相等的时候比较一次,处理边界(最大和最小)
            mid = (low + high) / 2;
            if (searchValue == objects[mid]) {
                return mid;
            } else if (searchValue > objects[mid]) {
                low = mid + 1;
            } else if (searchValue < objects[mid]) {

                high = mid - 1;
            }
        }
        return -1;
    }
    /**
     * Test类
     * @param args
     */
    public static void main(String[] args) {
        int[] arry={1,2,3,4,5,7,9,10};
        System.out.println(search(arry,15));
    }
}

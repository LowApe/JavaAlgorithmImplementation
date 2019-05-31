import java.util.Arrays;

public class QuickSort {
    /**
     * 由于快速排序的平均情况和最糟情况,我们选用平均情况(选择中间值作为基线)
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static void quickSort(int[] array, int low, int high) {
        /*
        快速排序的基线(数组为空,或者只有一个值)
        根据基线形成的数组,不过是通过交换做到的,
        因为直接开一个数组,不如用交换来的直接
        然后通过记录索引的值,将数组分区
         */
        if (low > high) {
            return;
        }
        //现将第一位变成基线
        int i = low;
        int j = high;
        int pivot = array[i];
        while (i < j) {
            while (i < j && pivot < array[j]) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && pivot > array[i]) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        array[i] = pivot;
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}

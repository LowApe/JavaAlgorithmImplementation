import java.util.ArrayList;
import java.util.List;

public class RecursionSumArray {
    private static int total = 0;
    private static int max = 0;
    private static int count = 0;

    /**
     * 递归的数组查分并求和
     * @param array
     * @return 数组各数值之和
     */
    public static int splitArray(List<Integer> array) {

        if (array.size() >= 1) {
            total += array.get(0);
            array.remove(0);
            arraySize(array);
            splitArray(array);
        }
        return total;
    }

    /**
     * 递归的列表个数
     * @param array
     */
    public static void arraySize(List<Integer> array){
       if(array.size()>0){
           count++;
           array.remove(0);
           arraySize(array);
       }
    }

    /**
     * 递归的求最大值
     * @param array
     */
    public static void maxArray(List<Integer> array){
       if(array.size()>1){

           max=array.get(0);
           if(max<array.get(1)){
               max=array.get(1);

           }
           System.out.println(max);
           array.remove(0);
           maxArray(array);
       }
    }

    /**
     * 测试上面的方法
     * @param args
     */
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 5, 4, 7, 9};
        List<Integer> list = new ArrayList<>();
        for (Integer a:array) {
            list.add(a);

        }

//        System.out.println(splitArray(list));
//        arraySize(list);
        maxArray(list);
        System.out.println(count);
        System.out.println(max);
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 选择排序
 * sortA:经典的选择排序,通过交换最小(最大)实现排序
 * sortB:先从数据中找到最大的然后
 */
public class SelectionSort {
    /**
     * 经典的选择排序,通过交换最小(最大)实现排序
     * @param list
     * @return int[]
     */
    public static int[] sortA(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if(list[i]<list[j]){
                    //交换位置
                    list[i]=list[i]^list[j];
                    list[j]=list[i]^list[j];
                    list[i]=list[i]^list[j];
                }
            }
        }
        return list;
    }

    /**
     * 选择排序:从小到大排序;
     * 从数组中选取最小的数值
     * 插入到新数组
     * @param list
     * @return 排序后的新数组
     */
    public static List sortB(List list) {

        List newList=new ArrayList();
        int listlength=list.size();
        for (int i = 0; i < listlength; i++) {
            int deleteIndex=findSmallest(list);
            newList.add(list.get(deleteIndex));
            list.remove(deleteIndex);

        }
        return newList;
    }
    /**
     * 查找数组最小元素
     * @return
     */
    public static int findSmallest(List list){
        if(list.isEmpty()){
            return -1;
        }
        int smallest=Integer.valueOf(list.get(0).toString());
        int smallIndex=-1;
        for (int i =0; i < list.size(); i++) {
            if(smallest>=Integer.valueOf(list.get(i).toString())){
                smallest=Integer.valueOf(list.get(i).toString());
                smallIndex=i;
            }
        }
        return smallIndex;
    }


    public static class TestSelectionSort{
        /**
         * 选择排序测试类
         * @param args
         */
        public static void main(String[] args) {
            int[] arry={122,2,1,4,77,7,4,10};
            List list= new ArrayList();
            for (int i = 0; i < arry.length; i++) {
                list.add(arry[i]);
            }
            System.out.println(sortB(list));
            System.out.println();
            for (int a:sortA(arry)) {
                System.out.print(a+",");
            }

        }
    }
}

package nowcoder;

import java.util.Scanner;

/**
 * @author qujiacheng
 * @create 2021-09-18-下午9:19
 * <p>
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
 * <p>
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 复制
 * 输出：
 * 2
 * 复制
 */
public class HJ2 {

    /**
     * 全部小写，然后找，全查询
     */
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     String inputString = scanner.nextLine().toLowerCase();
    //     //检查
    //     if (inputString.length() >= 500) {
    //         System.out.println("字符串长度大于500");
    //     }
    //     String searchChar = scanner.nextLine().toLowerCase();
    //     //检查
    //     if (searchChar.length() != 1) {
    //         System.out.println("第二行输入一个字母");
    //     }
    //     int count = 0;
    //     for(int i = 0; i < inputString.length();i++){
    //         if(inputString.charAt(i) == searchChar.toCharArray()[0]){
    //             count++;
    //         }
    //     }
    //     System.out.println(count);
    // }
    /**
     * 利用减法，删除重复的出现的，获取减少的数量
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toLowerCase();
        //检查
        if (inputString.length() >= 500) {
            System.out.println("字符串长度大于500");
        }
        String searchChar = scanner.nextLine().toLowerCase();
        //检查
        if (searchChar.length() != 1) {
            System.out.println("第二行输入一个字母");
        }
        System.out.println(inputString.length()-inputString.replaceAll(searchChar,"").length());

    }
}

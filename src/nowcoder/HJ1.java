package nowcoder;


import java.util.Scanner;

/**
 * @author qujiacheng
 * @create 2021-09-18-下午8:50
 * <p>
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * （注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 * <p>
 * 示例1
 * 输入：
 * hello nowcoder
 * 复制
 * 输出：
 * 8
 * 复制
 * 说明：
 * 最后一个单词为nowcoder，长度为8
 */
public class HJ1 {
    /**
     * 空格分割，取最后一个
     */
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     String inputString = scanner.nextLine();
    //     //检查规范
    //     if("".equals(inputString)){
    //         System.out.println("字符串为null");
    //     }else if(inputString.length() > 5000){
    //         System.out.println("字符串长度大于5000");
    //     }
    //     //获取最后一个单词的长度
    //     String[] strings = inputString.split(" ");
    //     System.out.println(strings[strings.length-1].length());
    // }

    /**
     * 反着打印
     */
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     String inputString = scanner.nextLine();
    //     char[] chars = inputString.toCharArray();
    //     int lastIndex = chars.length - 1;
    //     int count = 0;
    //     for (int i = lastIndex; i >= 0; i--) {
    //         if(chars[i] == ' '){
    //             break;
    //
    //         }
    //         count++;
    //     }
    //     System.out.println(count);
    // }

    /**
     * 别人的反着打印
     */

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     String inputString = scanner.nextLine();
    //     int i = inputString.length()-1;
    //     int t=0;
    //     while(i>=0 && inputString.charAt(i) != ' '){
    //         t++;
    //         i--;
    //     }
    //     System.out.println(t);
    // }

    /**
     * 找到最后单词前空格，索引相减
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int lastIndex = inputString.length()-1;
        int lastSpaceIndex = inputString.trim().lastIndexOf(" ");

        System.out.println(lastIndex-lastSpaceIndex);
    }
}

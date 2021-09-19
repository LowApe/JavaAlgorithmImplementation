package nowcoder;

import java.util.Scanner;

/**
 * @author qujiacheng
 * @create 2021-09-19-下午8:57
 * 描述
 * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例1
 * 输入：
 * abc
 * 123456789
 * 复制
 * 输出：
 * abc00000
 * 12345678
 * 90000000
 */
public class HJ4 {
    /**
     * 每8个获取字符串
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            str = str.replace(" ", "");
            while (str.length() >= 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
            if (str.length() > 0 && str.length() < 8) {
                //需要补0个数
                StringBuffer sb = new StringBuffer(str);
                for (int i = 0; i < (8 - str.length()); i++) {
                    sb.append("0");
                }
                System.out.println(sb.toString());
            }
        }
    }
}

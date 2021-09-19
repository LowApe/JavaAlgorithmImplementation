package nowcoder;

import java.util.Scanner;

/**
 * @author qujiacheng
 * @create 2021-09-19-下午9:49
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 * <p>
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * 输入：
 * 0xA
 * 0xAA
 * 复制
 * 输出：
 * 10
 * 170
 */
public class HJ5 {
    /**
     * 利用数学计算的十六进制转换二进制
     * 遍历 ox 之后的
     * A-F a-f
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            str = str.substring(2);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                int number = 0;
                char c = str.charAt(i);
                if(c >= '0' && c <= '9'){
                    number = c - '0';
                }else if(c >= 'A' && c <= 'F'){
                    number = c - 'A' + 10;
                }else if(c >= 'a' && c<= 'f'){
                    number = c - 'a' + 10;
                }
                count += number * Math.pow(16,str.length()-i-1);
            }
            System.out.println(count);
        }
    }

    /**
     * 解法二： 直接用Integer.parseInt("String", 进制) 进行转换。
     */
    // public static void main(String[] args){
    //     Scanner scan=new Scanner(System.in);
    //     while(scan.hasNext()){
    //         String str=scan.next();
    //         System.out.println(Integer.valueOf(str.replaceAll("x",""),16));
    //
    //     }
    // }

}

/**
 * 出自算法第四版第一章
 * 欧几里得算法:找到两个最大公约数
 * 自然语言描述:
 * 计算两个非负整数 p he q 的最大公约数,若 q 是 0,
 * 则 p 是最大公约数。否则将 p 除以 q 得到余数 r ,p和q的
 * 最大公约数即为 q 和 r 的最大公约数
 */
public class EuclideanAlgorithm {
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println("6和9的最大公约数:" + gcd(6, 9));
    }
}


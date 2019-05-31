public class PMT {
    static int[] pmt;

    public static int getPMT(char[] s, char[] p) {
        int i = 0;
        int j = 0;
        int sLen = s.length;
        int pLen = p.length;
        while (i < sLen && j < pLen) {
            //j==0 遗漏第一位没有比较
//            表示没有最大长度值,整体 i 和 j 向后移
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                //如果 s[i]!=p[j] 查看最大长度值
                j--;
                if (j == -1) {
                    continue;
                } else {
                    j = pmt[j];
                }
            }
        }
        if (j == pLen) {
            return i - j;
        }
        return -1;
    }

    public static void getMatchLength(char[] p, int pmt[]) {
        //k是最大长度值 初始值0表示没有最大长度值
        int k = 0;
        int pLen = p.length;
        //j初识下标为1,因为第一位没有前后缀,p[k],p[j]指向同一个数
        int j = 1;
        pmt[0] = 0;
        //循环目的是把整个搜素串的各个位置的最大长度值求出来
        while (j < pLen) {

            if (p[j] == p[k]) {
                //如果 p[j]==p[k],表示当前符合前后缀k++,赋值
                k++;
                pmt[j] = k;

            } else {
                //如果 p[j]!=p[k],表示没有最大长度值,赋值k
                k = pmt[k];
            }
            j++;
        }
    }

    public static class TestPMT {
        public static void main(String[] args) {
            String s = "dabadcabecbaabadcabfasdads";
            String p = "abadcabf";
            pmt = new int[p.length()];
            getMatchLength(p.toCharArray(), pmt);
            System.out.println("PMT 局部匹配表");
            for (int i = 0; i < pmt.length; i++) {
                System.out.print(pmt[i] + "\t");
            }
            System.out.print("\n");
            System.out.println("首次出现的位置 " + getPMT(s.toCharArray(), p.toCharArray()));
        }
    }
}

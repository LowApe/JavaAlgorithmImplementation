/**
 * 暴露破解字符串匹配
 */
public class BruteForceStringMatching {
    public static int Search(char[] s, char[] p) {
        int i = 0;
        int j = 0;
        int sLen = s.length;
        int pLen = p.length;
        while (i < sLen && j < pLen) {
            if (p[j] == s[i]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLen) {
            return j;
        } else {
            return -1;
        }
    }

    public static class TestBruteForceStringMatching {
        public static void main(String[] args) {
            String s = "abacababc";
            String p = "abab";
            //搜索
            System.out.println(Search(s.toCharArray(), p.toCharArray()));
        }
    }
}

/**
 * KMP 算法
 * 局部匹配表 PMT(关键)
 * 移动位数=已匹配的字符数-不匹配上一个最大长度值
 * PMT 转换为 next 数组(核心):将PMT 整体后移移位,首位赋值-1
 */
public class KMPAlgorithm {
     private static int[] next;
    /**
     *
     * @param s
     * @param p
     * @return 返回是否查询到
     */
    public static int KMPSearch(char[] s,char[] p){
        int i=0;
        int j=0;
        int sLen=s.length;
        int pLen=p.length;
        while (i<sLen && j<pLen){
            if(j==-1 || p[j]==s[i]){
                i++;
                j++;

            }else{
                j=next[j];
            }
        }
        if(j==pLen){
            return i-j;
        }
        return -1;
    }

    /**
     * 通过PMT递推的next数组求得索引之前匹配了的最大长度值
     * @param p
     * @param next
     */
    public static void getNext(char[] p,int next[]){
        int k=-1;
        int pLen=p.length;

        next[0]=-1;
        int j=0;
        while (j<pLen-1){
            if(k==-1||p[j]==p[k]){
                ++k;
                ++j;
                next[j]=k;
            }else{
                k = next[k];
            }
        }
    }

    public static class TestKMP{
        public static void main(String[] args) {
            String s="dabadcabecbaabadcabfasdads";
            String p="abadcabf";
            next=new int[p.length()];
            //next 数组
            getNext(p.toCharArray(),next);
            //搜索
            System.out.println(KMPSearch(s.toCharArray(),p.toCharArray()));
        }
    }
}

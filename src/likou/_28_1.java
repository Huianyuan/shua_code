package likou;

/**
 * @author :lhy
 * @description :找出字符串中第一个匹配项的下标  KMP算法
 * @date :2023/03/20 上午 10:10
 */
public class _28_1 {

    public static void main(String[] args) {
        String haystack="ababc";
        String needle="abc";
        int res = strStr(haystack, needle);
        System.out.println(res);

    }
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }

        return -1;
    }

    public static void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }
}

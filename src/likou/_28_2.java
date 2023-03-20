package likou;

/**
 * @author :lhy
 * @description :找出字符串中第一个匹配项的下标  KMP算法 前缀表（不减一）Java实现
 * @date :2023/03/20 上午 10:31
 */
public class _28_2 {
    public static void main(String[] args) {
        String haystack = "abababc";
        String needle = "ababc";
        int res = strStr(haystack, needle);
        System.out.println(res);

    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
}

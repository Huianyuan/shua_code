package likou;

/**
 * @author :lhy
 * @description :找出字符串中第一个匹配项的下标  滑动窗口
 * @date :2023/03/20 上午 10:22
 */
public class _28_3 {
    public static void main(String[] args) {
        String haystack = "abababc";
        String needle = "ababc";
        int res = strStr(haystack, needle);
        System.out.println(res);

    }

    /**
     * 基于窗口滑动的算法
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 注：n为haystack的长度，m为needle的长度
     */
    public static int strStr(String haystack, String needle) {
        int nL = needle.length();
        if (nL == 0) return 0;// 当 needle 是空字符串时我们应当返回 0

        int hL = haystack.length();
        if (hL < nL) return -1;

        int i = 0;
        int j = 0;
        while (i < hL - nL + 1) {
            // 找到首字母相等
            while (i < hL && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
            if (i == hL) {// 没有首字母相等的
                return -1;
            }
            // 遍历后续字符，判断是否相等
            i++;
            j++;
            while (i < hL && j < nL && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == nL) {// 找到
                return i - j;
            } else {// 未找到
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }
}

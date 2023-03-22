package likou;

/**
 * @author :lhy
 * @description :重复的子字符串
 * @date :2023/03/22 上午 09:58
 */
public class _459 {
    public static void main(String[] args) {
        String s = "abcabcabc";
        // boolean result = repeatedSubstringPattern1(s);
        // boolean result = repeatedSubstringPattern2(s);
        boolean result = repeatedSubstringPattern3(s);
        System.out.println(result);
    }


    /**
     * 错位匹配，x是基串，则原始串左移x位和右移x位相等。且s是x的整数倍。
     *
     * @param s 原始串
     * @return boolean
     */
    public static boolean repeatedSubstringPattern1(String s) {
        int lens = s.length();
        int i = 0;
        while (++i < lens) {
            if (lens % i != 0) continue;
            if (s.substring(lens - i, lens).equals(s.substring(0, i))) // 判断x是不是基串
                if (s.substring(i, lens).equals(s.substring(0, lens - i))) return true; // 判断拿去x后是否相等
        }
        return false;
    }

    /**
     * 暴力循环，子串个数一定小于等于s串的一半（i * 2 <= n）
     *
     * @param s 原始串
     * @return boolean
     */
    public static boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * KMP
     * @param s 原始串
     * @return boolean
     */
    public static boolean repeatedSubstringPattern3(String s) {
        if (s.equals("")) return false;

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) j++;
            // 更新 next 数组的值
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}

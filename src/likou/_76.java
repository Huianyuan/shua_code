package likou;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author :lhy
 * @description :最小覆盖子串
 * @date :2023/03/09 下午 01:23
 */
public class _76 {

    public static void main(String[] args) {
       String s="ADOBECODEBANC";
       String t="ABC";

        String result = minWindow(s, t);
        print(result);
    }


    public static String minWindow(String s, String t) {
        int lenS = s.length(), lenT = t.length(), minL = 0, minR = -1, left = 0, right = -1;
        int[] cntMap1 = new int[58], cntMap2 = new int[58];

        //统计t的数据
        for (int i = 0; i < lenT; i++) {
            cntMap1[t.charAt(i) - 'A']++;
        }

        int cnt = 0; //统计窗口有效元素个数
        while (left < lenS) {
            while (right < lenS && cnt < lenT) {
                ++right;
                if (right < lenS && ++cntMap2[s.charAt(right) - 'A'] <= cntMap1[s.charAt(right) - 'A']) {
                    cnt++;
                }
            }

            if (cnt == lenT && (minR == -1 || right - left < minR - minL)) {
                minL = left;
                minR = right;
            }

            if (--cntMap2[s.charAt(left) - 'A'] < cntMap1[s.charAt(left) - 'A']) {
                cnt--;
            }
            ++left;
        }
        return s.substring(minL, minR + 1);
    }

}

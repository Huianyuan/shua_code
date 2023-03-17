package likou;

/**
 * @author :lhy
 * @description :反转字符串2
 * @date :2023/03/17 上午 10:09
 */
public class _541 {

    public static void main(String[] args) {
        String s="abcdefg";
        int k=4;
        String res = reverseStr(s, k);
    }

    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i, end = Math.min(ch.length - 1, start + k - 1);
            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}

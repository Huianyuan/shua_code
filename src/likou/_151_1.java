package likou;

/**
 * @author :lhy
 * @description :反转字符串中的单词
 * @date :2023/03/19 上午 08:43
 */
public class _151_1 {

    public static void main(String[] args) {
        String s= "the sky is blue";
        String s1= "  ni  hao  ";
        reverseWords(s1);
    }
    /**
     * 不使用Java内置方法实现
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public static String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder ns = removeSpace(s);
        // 2.反转整个字符串
        reverseString(ns, 0, ns.length() - 1);
        // 3.反转各个单词
        reverseEachWord(ns);
        return ns.toString();
    }

    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder ns = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || ns.charAt(ns.length() - 1) != ' ') {
                ns.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: ns = [" + ns + "]");
        return ns;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static void reverseString(StringBuilder ns, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: ns = [" + ns + "], start = [" + start + "], 
        // end = [" + end + "]");
        while (start < end) {
            char temp = ns.charAt(start);
            ns.setCharAt(start, ns.charAt(end));
            ns.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: ns = [" + ns + "]");
    }

    private static void reverseEachWord(StringBuilder ns) {
        int start = 0;
        int end = 1;
        int n = ns.length();
        while (start < n) {
            while (end < n && ns.charAt(end) != ' ') {
                end++;
            }
            reverseString(ns, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}

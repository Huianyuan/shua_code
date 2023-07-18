package mianshi;

import java.util.Scanner;

/**
 * 定义一个“模板串”为一个由数字字符和′?"组成的字符串。我们可以通过将问号替换成数字字符来得到正整数。
 * 显然，一个模板串可能会和多个正整数匹配。例如: "1?2"可以和102或者132等正整数匹配。
 * 请注意，匹配的正整数不能包含前导零，例如"??1"可以匹配101，但不能匹配001。
 * 小红拿到了一个模板串，她想知道，和这个模板串匹配的正整数中，第k小的是多少?
 * 输入描述
 * 第一行输入一个正整数t，代表询问次数。接下来的2* t行，每两行为一次询问: 第一行输入一个字符串，仅由数字字符和?'组成。第二行输入一个正整数k，代表询问的是第k小。
 * 1≤t ≤ 10^4 1≤k≤10 ^9
 * 字符串长度不超过30。
 * 输出描述
 * 输出t行，每行输出一个答案。如果一共都没有k个匹配的正整数，则输出-1。否则输出第小的匹配的正整数。
 * 输入：
 * 4
 * ??1
 * 1
 * 22?
 * 100000000
 * 2??
 * 3
 * 000???
 * 1
 * 输出：
 * 101
 * -1
 * 202
 * -1
 */
public class KeDaXunFei20230715C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        String input = scanner.nextLine();
        char[] s = input.toCharArray();
        int k = scanner.nextInt();
        scanner.nextLine();

        int wh = 0;
        for (char c : s) {
            if (c == '?') {
                wh++;
            }
        }

        if ((s[0] == '?' && Math.pow(10, wh - 1) * 9 < k) || (s[0] != '?' && Math.pow(10, wh) < k) || (s[0] == '0')) {
            System.out.println(-1);
            return;
        }

        String strk = new StringBuilder(String.valueOf(k - 1)).reverse().toString();

        boolean flag = false;
        if (s[0] == '?') flag = true;

        int n = s.length;
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '?') {
                if (j < strk.length()) {
                    s[i] = strk.charAt(j);
                    j++;
                } else {
                    s[i] = '0';
                }
            }
        }

        if (flag) s[0] += 1;

        System.out.println(new String(s));
    }
}

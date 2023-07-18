package mianshi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 小红拿到了一个字符串，她希望你帮她切割成若干子串，满足以下两个条件:
 * 子串长度均为不小于3的奇数。
 * 子串内部的字符全部相同。
 * 输入描述
 * 第一行输入一个正整数n，代表字符串长度。第二行输入一个字符串，仅由小写字母组成。1 <n ≤200000输出描述如果无解，请输出-1。否则按顺序输出若干个字符串，用空格隔开。
 * 输入：
 * 8
 * aaabbbbb
 * 输出：
 * aaa bbbbb
 */
public class KeDaXunFei20230715B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[] cs = scanner.nextLine().toCharArray();

        //记录每个相同字符的子串的字符数量
        List<String> list = new LinkedList<>();

        char pre = '.';

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (pre == '.' || cs[i] == pre) {
                pre = cs[i];
                sb.append(cs[i]);
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
                pre = cs[i];
                sb.append(cs[i]);
            }
        }

        if (sb != null) list.add(sb.toString());
        List<String> res = new LinkedList<>();

        for (String s : list) {
            if (s.length() % 2 != 0) {
                // 奇数
                res.add(s);
            } else {
                //偶数
                if (s.length() < 6) {
                    System.out.println(-1);
                    return;
                }
                res.add(s.substring(0, 3));
                res.add(s.substring(3));
            }
        }

        System.out.println(res.toString().replace("[", "").replace("]", "").replace(",", ""));
    }

    //遍历字符串，获取相邻且字符相同的子串。
    // 对于每一个字符串做如下判断：
    // 长度如果为奇数，则直接加入结果集
    // 长度如果为偶数，不难发现，只有长度为2和4无解，其余的都可以分割为长度为3和其他的一个奇数的子串。
}

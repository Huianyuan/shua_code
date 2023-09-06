package mianshi;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 小米手机通信校准
 * 时间限制:1000MS内存限制:65536KB
 * 题目描述:
 * 小米手机生产过程中会经过严苛的测试环节，其中包括手机通讯功能中的射频校准。射频校准会打点数据上报到云端。
 * 其中包含两组数据:第一组数据中会包含此次校准的频道号(freq)信息;第二组会上传一批数据，包含一组频道号(freg)和其对应的损失值(loss)，其中这一组频道号(freg)不会重复，且是有序的。
 * 现在需要根据第一组数据中的频道号(freg)，找到离第二组中频道号(fre)最近的那个freq对应的loss值，如果两边一样近，则取两边loss的平均。(注:入为int，输出为double类型四舍五入保留1位小数)
 * 输入描述
 * 包含两组数据:
 * 第一组数据中会包含此次校准的频道号(freq)信息。
 * 第二组会上传一批数据，包含一组频道号(freg)和其对应的损失值loss)，其中这一组频道号(freg)不会重复，且是有序的。
 * 输出描述
 * 离频道号(freq)最近的freq对应的loss值，如果两边一样近，则取两边loss的平均。
 * 样例输入
 * 2800
 * 1950:10 2000:15 3000:9
 * 样例输出
 * 9.0
 */
public class XIAOMI20230902A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int baseFreq = scanner.nextInt(); // 第一组数据中的频道号(freq)
        scanner.nextLine(); // 消耗换行符

        String[] data = scanner.nextLine().split(" "); // 第二组数据
        TreeMap<Integer, Double> map = new TreeMap<>();

        for (String item : data) {
            String[] parts = item.split(":");
            int freq = Integer.parseInt(parts[0]);
            double loss = Double.parseDouble(parts[1]);
            map.put(freq, loss);
        }

        double result = findNearestLoss(baseFreq, map);
        System.out.println(String.format("%.1f", result)); // 输出结果，保留一位小数
    }

    private static double findNearestLoss(int baseFreq, TreeMap<Integer, Double> map) {
        Integer lowerKey = map.floorKey(baseFreq); // 不大于freq的最大键
        Integer higherKey = map.ceilingKey(baseFreq); // 不小于freq的最小键

        if (lowerKey == null) {
            return map.get(higherKey);
        } else if (higherKey == null) {
            return map.get(lowerKey);
        } else {
            double lowerLoss = map.get(lowerKey);
            double higherLoss = map.get(higherKey);
            double lowerDiff = Math.abs(baseFreq - lowerKey);
            double higherDiff = Math.abs(baseFreq - higherKey);

            if (lowerDiff < higherDiff) {
                return lowerLoss;
            } else if (higherDiff < lowerDiff) {
                return higherLoss;
            } else {
                return (lowerLoss + higherLoss) / 2.0;
            }
        }
    }

}

package mianshi;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 手机流畅运行的秘密
 * 时间限制: 1000MS内存限制: 65536KB
 * 题目描述:
 * 8月份发布会一结束，米小兔就在公司领到了一台最新发布的Xiaomi MIX Fold 3手机，这是一款小米旗舰折叠屏手机，并搭载了全新升级架构的MIU114系统。其先进的应用引擎不仅让系统更流畅，应用体验也大幅提升。
 * 在一个优化项中，为了尽可能提升用户白天使用手机的体验和续航，某些已经在系统中注册过的任务会被设置为空闲任务，仅在手机空闲时运行 (比如数据备份或AI相册整理)。
 * 现在系统中注册了若干组空闲任务，每个任务有各自的耗电量以及允许任务运行的最低初始电量，我们需要计算手机能够串行完成全部任务的最低初始电量。
 * 注意点1: 所有电量以mAh(毫安时)计，Xiaomi MIX Fold 3的大电池容量是4800mAh。
 * 注意点2:本题目假设手机在运行空闲任务期间，不处于充电状态，也没有额外耗电行为。
 * 注意点3:智能应用引擎会以最合适的顺序串行运行任务。
 * 输入描述
 * 一个描述了所有任务的长字符串。任务与任务之间用逗号阳开，每组任务由耗电量及最低初始电量组成，用冒号限开。
 * 输出描述
 * 一个数字，代表依次完成全部任务的最低初始电量，如果最低初始电量超过手机电池容量，则返回-1。
 * 样例输入
 * 1:10,2:12,3:10
 * 样例输出
 * 13
 * 提示
 * 在样例中，手机至少需要有13mah的初始电量，在运行任务2后剩余电量11mAh、运行任务1后剩余电量10mah、运行任务3后剩余7mah。
 */
public class XIAOMI20230902B {
    public static void main(String[] args) {
        //贪心
        // 任务主最低初始电量为B(i) ，耗电为 C(i) ，则设T(i)=B(i)-C(i), 即任务最低结束电量。
        // 证明贪心性质：设有任务j，T(i)<T(j), 则
        // 如果先执行七要求的最低初始电量是 S(i) = max(T(i), T(j) +C(j)+C(i) = T(j) +C(j) +C(i)
        // 如果先执行 j ：要求的最低初始电量是 S(j)= max(T(j), T(i) +C(i))+ C(j)
        //
        // 1.  若 T(j)>=T(i)+C(i): 此时S(j)=T(i)+C(i)    <T(j)+C(j)+C(i)=S(i)
        // 2． 若 T(j)<T(i)+C(i) ：此时S(j)=T(i)+C(i)+C(j)<T(j)+C(j)+C(i)=S(i)
        //
        // 所以 S(j) <S(j), 优先执行 j 是最佳选择。


        // 初始化一个Scanner对象用于读取输入字符串
        Scanner scanner = new Scanner(System.in);
        // 初始化一个TreeMap用于存储任务
        TreeMap<Integer, Integer> tasks = new TreeMap<>();
        // 读取输入字符串并创建任务
        System.out.println("请输入任务描述：");
        String input = scanner.nextLine();
        String[] taskArray = input.split(",");
        for (String task : taskArray) {
            String[] taskParts = task.split(":");
            int batteryPower = Integer.parseInt(taskParts[0]);
            int minimumInitialBatteryPower = Integer.parseInt(taskParts[1]);
            tasks.put(batteryPower, minimumInitialBatteryPower);
        }
        // 对任务按照电池电量从小到大排序
        SortedMap<Integer, Integer> sortedTasks = new TreeMap<>(tasks);
        // 初始化最小初始电池电量为0
        int minInitialBatteryPower = 0;
        // 遍历排序后的任务
        for (Map.Entry<Integer, Integer> task : sortedTasks.entrySet()) {
            // 计算当前任务的电池电量需求
            int taskBatteryPower = task.getKey();
            // 计算当前任务的最低初始电池电量
            int taskMinInitialBatteryPower = task.getValue();
            // 如果当前任务的电池电量需求大于等于剩余最低初始电池电量，跳过该任务
            if (taskBatteryPower >= minInitialBatteryPower) {
                continue;
            }
            // 更新最低初始电池电量
            minInitialBatteryPower = taskMinInitialBatteryPower;
        }
        // 输出最低初始电池电量
        System.out.println("最低初始电池电量为：" + minInitialBatteryPower);
    }
}

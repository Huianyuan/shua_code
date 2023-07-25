package likou;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 2208. 将数组和减半的最少操作次数
 * 给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
 *
 * 数组和 减少至少一半 的最少操作数，从最大的数开始减半，用优先队列，每次选出最大数，减半
 */
public class _2208 {

    public static void main(String[] args) {
        int[] nums={5,19,8,1};
        double s=0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:nums){
            priorityQueue.offer(num*1.0);
            s=s+num;
        }
        s/=2.0;//减半，只要判断这个值<0就可
        int result=0;

        while(s>0){
            double t=priorityQueue.poll();//弹出最大的
            s=s-t/2.0;
            priorityQueue.offer(t/2.0);//最大值减半入队列
            result++;
        }
        System.out.println(result);
    }
}

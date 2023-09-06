package mianshi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 令牌桶是一种常用的限流算法，SHEIN api gateway就使用了令牌桶算法作为限流器的实现。基本原理为: 系统以一个恒定的速度往桶里放入令牌，而如果请求需要被处理，则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务。
 * 小明的服务接口响应耗时比较长高达500ms，于是他在自己的web服务中引入了一个令牌桶限流器，该限流器每100ms产生10个令牌，令牌桶的最大容量为150个令牌。
 * 小明服务上线后，接收到了无数请求，请输出被限流的请求总数。初始状态下，桶中有100个令牌。
 * 输入描述：
 * 第一行为输入的总行数。输入为每时刻新接口到的请求，第一列为时刻 (单位ms)，第二列为请求数量
 * 输出描述：
 * 被限流的请求总和
 */
public class SHEIN20230906A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int totalLines = Integer.parseInt(scanner.nextLine());
        List<int[]> requests = new ArrayList<>();
        for (int i = 0; i < totalLines; i++) {
            String[] input = scanner.nextLine().split(" ");
            int timestamp = Integer.parseInt(input[0]);
            int requestCount = Integer.parseInt(input[1]);
            requests.add(new int[]{timestamp, requestCount});
        }

        // 计算被限流的请求总数
        int rejectedCount = countRejectedRequests(requests);

        // 输出结果
        System.out.println(rejectedCount);
    }
    public static int countRejectedRequests(List<int[]> requests) {
        int tokenBucket = 100; // 初始状态下桶中的令牌数量
        int tokenRate = 10; // 每100ms产生的令牌数量
        int maxTokens = 150; // 令牌桶的最大容量
        int rejectedRequests = 0; // 被限流的请求总数

        for (int[] request : requests) {
            int timestamp = request[0];
            int requestCount = request[1];
            int tokensNeeded = requestCount;

            // 等待直到有足够的令牌可用
            while (tokensNeeded > tokenBucket) {
                tokensNeeded -= tokenBucket;
                tokenBucket = Math.min(tokenBucket + tokenRate, maxTokens);
            }

            // 处理请求，并减去相应数量的令牌
            tokenBucket -= tokensNeeded;

            // 如果令牌不足，则增加被限流的请求计数
            if (tokensNeeded > 0) {
                rejectedRequests += requestCount;
            }
        }

        return rejectedRequests;
    }
}
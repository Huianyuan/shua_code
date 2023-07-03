package test;

import java.util.Arrays;

/**
 * @author :lhy
 * @description :零钱问题
 * @date :2023/07/03 上午 09:05
 */
public class coin {

    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0]=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}

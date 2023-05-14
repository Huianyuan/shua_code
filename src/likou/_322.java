package likou;

import java.util.Arrays;

/**
 * @author :lhy
 * @description :322.凑零钱-记忆化搜索
 * @date :2023/03/01 下午 02:08
 */
public class _322 {

    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
        int result = coinChange(coins, amount);
        int result2 = coinChange2(coins, amount);
        System.out.println(result);
    }

    private static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];//记忆数组，存储已经计算过的状态
        if(amount<1) return 0;
        return coinChanges(coins,amount,memo);
    }

    private static int coinChanges(int[] coins, int amount, int[] count){
        if(amount<0) return -1;
        if(amount==0) return 0;

        if(count[amount-1]!=0) {//在记忆数组中搜索，存在当前情况则直接返回
            return count[amount-1];
        }

        int min =Integer.MAX_VALUE;
        for(int coin:coins){
            int res=coinChanges(coins,amount-coin,count);
            if(res>=0 && res<min)
                min=1+res;
        }

        count[amount-1] =(min==Integer.MAX_VALUE)?-1:min;
        return count[amount-1];
    }
    //动态规划
    public static int coinChange2(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                //只有dp[j-coins[i]]不是初始最大值时，该位置才有选择的必要
                if(dp[j-coins[i]]!=max){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==max? -1 :dp[amount];
    }
}

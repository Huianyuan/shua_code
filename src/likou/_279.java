package likou;

import java.util.Arrays;

/**
 * @author :lhy
 * @description :完全平方数
 * @date :2023/05/12 上午 10:51
 */
public class _279 {
    public static void main(String[] args) {
        int n=12;
        int i = numSquares(n);
        System.out.println(i);
    }
    public static int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n+1];
        Arrays.fill(dp, max);
        dp[0]=0;
        for(int i=0;i*i<=n;i++){
            for(int j=i*i;j<=n;j++){
                if(dp[j-i*i]!=max){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}

package likou;

/**
 * @author :lhy
 * @description :不同子序列
 * @date :2023/05/23 上午 10:58
 */
public class _115 {

    public static void main(String[] args) {
        String s="babgbag";
        String t="bag";
        int res = numDistinct(s, t);
        System.out.println(res);
    }

    public static int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length();i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}

package likou;

/**
 * @author :lhy
 * @description :1和0
 * @date :2023/05/10 上午 10:05
 */
public class _474 {

    public static void main(String[] args) {
        String[] strs=new String[]{"10", "0001", "111001", "1", "0"};
        int m=3;
        int n=3;
        int maxForm = findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        int oneNum,zeroNum;
        for(String str:strs){
            oneNum=0;
            zeroNum=0;
            for(char ch:str.toCharArray()){
                if(ch=='0'){
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }
            for(int i=m;i>=zeroNum;i--){
                for(int j=n;j>=oneNum;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
}

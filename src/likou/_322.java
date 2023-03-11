package likou;

/**
 * @author :lhy
 * @description :322.凑零钱-记忆化搜索
 * @date :2023/03/01 下午 02:08
 */
public class _322 {

    public static void main(String[] args) {
        int[] coins={5,6,7};
        int amount=6;
        int result = coinChange(coins, amount);
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
}

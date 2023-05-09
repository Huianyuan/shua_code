package likou;

import java.util.Arrays;

/**
 * @author :lhy
 * @description :目标和 （动态规划）
 * @date :2023/05/09 上午 10:31
 */
public class _494 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,1,1};
        int target=3;
        int sumWays = findTargetSumWays(nums, target);
        System.out.println(sumWays);
    }


    public static int findTargetSumWays(int[] nums, int target) {
        int sum= Arrays.stream(nums).sum();
        if(target<0 && sum< -target) return 0;
        if((target+sum)%2!=0) return 0;
        int size=(target+sum)/2;
        if(size<0) size=-size;
        int[] dp=new int[size+1];
        dp[0]=1;

        for(int i=0;i<nums.length;i++){
            for(int j=size;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[size];
    }
}

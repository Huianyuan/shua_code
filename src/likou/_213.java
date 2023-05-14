package likou;

/**
 * @author :lhy
 * @description :打家劫舍2
 * @date :2023/05/14 下午 04:48
 */
public class _213 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,2,2,2,2,2};
        // int[] nums=new int[]{0,0};
        int rob = rob(nums);
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        // int res1=robRange(nums,0,nums.length-2);
        int res1=robRange(nums,0,nums.length-1);
        // int res2=robRange(nums,1,nums.length-1);
        int res2=robRange(nums,1,nums.length);

        return Math.max(res1,res2);
    }

    public static int robRange(int[] nums,int start,int end){
        // if(start==end) return nums[start];
        if(end-start==1) return nums[start];
        int[] dp=new int[nums.length+1];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start+1],nums[start]);

        for(int i=start+2;i<end;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end-1];
    }
}

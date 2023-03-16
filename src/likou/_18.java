package likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :lhy
 * @description :四数之和
 * @date :2023/03/16 下午 03:28
 */
public class _18 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        int target = 8;
        fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                //注意j的起始位置
                // if (j + 1 > 0 && nums[j] == nums[j - 1]) continue; //错误
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

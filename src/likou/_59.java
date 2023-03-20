package likou;

import java.util.Arrays;

import static sun.misc.Version.print;

/**
 * @author :lhy
 * @description :螺旋数组2
 * @date :2023/03/11 下午 03:54
 */
public class _59 {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for(int[] re:res){
            for(int i:re) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            System.out.println();
            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            System.out.println();
            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            System.out.println();
            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}

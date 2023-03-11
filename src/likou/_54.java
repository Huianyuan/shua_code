package likou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lhy
 * @description :螺旋数组
 * @date :2023/03/11 下午 05:42
 */
public class _54 {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = new int[][]{{1, 2, 3}, {10, 11, 4}, {9, 12, 5},{8,7,6}};
        List<Integer> res = spiralOrder(matrix1);
        System.out.println(res.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int left = 0, top = 0, right = matrix[0].length - 1, down = matrix.length - 1;

        while (true) {
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            top++;
            if (top > down) break;

            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) {
                arr.add(matrix[down][i]);
            }
            down--;
            if (top > down) break;

            for (int i = down; i >= top; i--) {
                arr.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return arr;
    }
}

package likou;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lhy
 * @description :合并区间
 * @date :2023/04/29 下午 06:20
 */
public class _56 {

    public static void main(String[] args) {
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10}};
        int[][] merges = merge(intervals);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < merges.length; i++) {
            sb.append("[");
            sb.append(merges[i][0]);
            sb.append(",");
            sb.append(merges[i][1]);
            sb.append("]");
            if (i != merges.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        String intervalsString = sb.toString();
        System.out.println(intervalsString); //输出：[[1,3],[2,6],[8,10]]

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        //initial start 是最小左边界
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (intervals[i][0] > rightmostRightBound) {
                //加入区间 并且更新start
                res.add(new int[]{start, rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            } else {
                //更新最大右边界
                rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }
}

package likou;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lhy
 * @description :组合
 * @date :2023/03/28 上午 09:21
 */
public class _77 {

    private static final List<List<Integer>> result = new LinkedList<>();
    private static final LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        backTracking(n, k, 1);
    }

    private static void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}

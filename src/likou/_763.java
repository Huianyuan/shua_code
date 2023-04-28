package likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lhy
 * @description :划分字母区间，采用模拟区间重叠划分的方法
 * @date :2023/04/28 上午 10:32
 */
public class _763 {

    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(result.toString());
    }

    public static List<Integer> partitionLabels(String s) {
        int[][] partitions = findPartitions(s);
        List<Integer> res = new ArrayList<>();
        Arrays.sort(partitions, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int right = partitions[0][1];
        int left = 0;
        for (int i = 0; i < partitions.length; i++) {
            if (partitions[i][0] > right) {
                //左边界大于右边界即可纪委一次分割
                res.add(right - left + 1);
                left = partitions[i][0];
            }
            right = Math.max(right, partitions[i][1]);

        }
        //最右端
        res.add(right - left + 1);
        return res;

    }

    public static int[][] findPartitions(String s) {
        List<Integer> temp = new ArrayList<>();
        int[][] hash = new int[26][2];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash[c - 'a'][0] == 0)
                hash[c - 'a'][0] = i;

            hash[c - 'a'][1] = i;

            hash[s.charAt(0) - 'a'][0] = 0;
        }
        List<List<Integer>> h = new LinkedList<>();
        //组装区间
        for (int i = 0; i < 26; i++) {
            //if (hash[i][0] != hash[i][1]) {
            temp.clear();
            temp.add(hash[i][0]);
            temp.add(hash[i][1]);
            //System.out.println(temp);
            h.add(new ArrayList<>(temp));
            // }
        }
        // System.out.println(h);
        // System.out.println(h.size());
        int[][] res = new int[h.size()][2];
        for (int i = 0; i < h.size(); i++) {
            List<Integer> list = h.get(i);
            res[i][0] = list.get(0);
            res[i][1] = list.get(1);
        }

        return res;
    }

}

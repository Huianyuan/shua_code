package likou;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :lhy
 * @description :两个数组的交集
 * @date :2023/03/15 下午 06:50
 */
public class _349 {

    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,3,1};
        int[] nums2=new int[]{2,3};
        int[] res = intersection(nums1, nums2);

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0) return new int[0];

        Set<Integer> res=new HashSet<>();
        Set<Integer> set=new HashSet<>();

        for(int i :nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        // return res.stream().mapToInt(x->x).toArray();
        int[] arr=new int[res.size()];
        int j=0;
        for(int i:res){
            arr[j++]=i;
        }
        return arr;
    }
}

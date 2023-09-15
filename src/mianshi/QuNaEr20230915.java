package mianshi;


import java.util.HashSet;

/**
 * 去哪儿0915日编程题
 * 第一题 给一个有重复的数组，只保留最后出现的数字。全过100%
 * 第二题 完成一个带条件的二分查找，找不到则返回第一个大于等于查找值的数字的下标；没有符合的则返回数组长度+1。80%
 * 第三题 返回单链表长度（不重复数字个数），注意复杂度和重复值。60%，hashSet怎么就超时了。。。。
 *
*/


public class QuNaEr20230915 {
    public static void main(String[] args) {
        // int[] nums={10,20,20,99,20,99,100,100};
        // findQ(8, nums);

        // int[] a = {1, 2, 4, 4, 5};
        // int i = find(5, 4, a);
        // System.out.println(i);

        ListNode head =new ListNode(1);
        head.next.val=2;
        head.next.next.val=3;
        lengthL(head);
    }

    public static int[] findQ(int n, int[] nums) {
        int count = 0;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = -1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) count++;
        }
        int[] result = new int[nums.length - count];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                result[j] = nums[i];
                j++;
            }
        }
        return result;
    }

    // public static int find(int n, int v, int[] a) {
    //     int res = n + 1;
    //     if (a[n - 1] < v) return res;
    //     if (a[0] > v) return a[0];
    //     int l = 0;
    //     int h = a.length - 1;
    //     int mid = 0;
    //     while (l < h) {
    //         mid = l + (h - l) / 2;
    //         if (a[mid] < v) {
    //             l = mid + 1;
    //         } else if (a[mid] > v) {
    //             h = mid;
    //         }
    //     }
    //     System.out.println("二分结束");
    //     int index = 0;
    //     for (int i = mid; i < n - 1; i++) {
    //         if (a[i] >= v) {
    //             index = i;
    //             System.out.println("找到索引");
    //             break;
    //         }
    //     }
    //     return a[index];
    // }
    public static int find(int n, int v, int[] a) {
        int res = n + 1;
        if (a[n - 1] < v) return res;
        if (a[0] > v) return a[0];
        int l = 0;
        int h = a.length - 1;
        int mid = 0;
        int index = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (a[mid] >= v) {
                index = mid;
                h = mid - 1;
            } else if (a[mid] < v) {
                l = mid + 1;
            }
        }
        return index + 1;
    }

    public static int lengthL (ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        while(head.next!=null){
            set.add(head.val);
        }
        return set.size();
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

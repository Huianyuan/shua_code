package mianshi;

import java.util.Scanner;

/**
 * 给定一个长度为n的数组，数组元素为a1, a2, . . , an，每次能删除任意a的任意一位，求将所有数字变成0最少需要几步。
 * 例如103若删除第1位则变成3;若删除第2位则变成13;若删除第3位则变成10。
 * 输入描述 第一行一个正整数n代表数组长度。接下来一行n个数第j个数代表a。
 * 1≤n ≤10^5 0≤ai≤10^9
 * 输出描述 输出一行一个数代表答案。
 * 示例：
 * 输入：
 *  5
 *  10 13 22 100 30
 * 输出：
 *  7
 */
public class KeDaXunFei20230715A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[] nums=new int[n];

        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int count=0;
        for(int num:nums){
            while(num>0){
                if(num%10!=0) count++;
                num/=10;
            }
        }

        System.out.println(count);
    }

}

package likou;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author :lhy
 * @description :滑动窗口最大值
 * @date :2023/03/28 上午 09:46
 */
public class _239 {
    public static void main(String[] args) {
        int[] nums={1,3,1,2,0,5};
        int k=3;
        int[] ints = maxSlidingWindow(nums, k);

    }

    public static int[] maxSlidingWindow( int[] nums,int k){
        if(nums.length==1) return nums;

        int[] res = new int[nums.length-k+1];
        int num=0;

        MyQueue myQueue=new MyQueue();

        for(int i=0;i<k;i++){
            myQueue.add(nums[i]);
        }

        res[num++]=myQueue.peek();
        for(int i=k;i<nums.length;i++){
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[num++]=myQueue.peek();
        }
        return res;
    }


}
class MyQueue{
    Deque<Integer> deque=new LinkedList<>();

    void poll(int val){
        if(!deque.isEmpty() && val==deque.peek()){
            deque.poll();
        }
    }

    void add(int val){
        while(!deque.isEmpty() && val>deque.getLast()){
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek(){
        return deque.peek();
    }
}
package likou;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author :lhy
 * @description :逆波兰表达式求值
 * @date :2023/03/23 上午 10:30
 */
public class _20 {
    public static void main(String[] args) {
        String s="{}}{";
        boolean res = isValid(s);
        System.out.println(res);

    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}

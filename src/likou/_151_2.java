package likou;

/**
 * @author :lhy
 * @description :反转字符串中的单词    解法二：创建新字符数组填充。时间复杂度O(n)
 * @date :2023/03/19 上午 08:57
 */
public class _151_2 {

    public static void main(String[] args) {
        String s= "the sky is blue";
        String s1= "  ni  hao  ";
        reverseWords(s1);
    }
    public static String reverseWords(String s) {
        //源字符数组
        char[] initialArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initialArr.length + 1];//下面循环添加"单词 "，最终末尾的空格不会返回
        int newArrPos = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length - 1;
        while (i >= 0) {
            while (i >= 0 && initialArr[i] == ' ') {
                i--;
            }  //跳过空格
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            int right = i;
            while (i >= 0 && initialArr[i] != ' ') {
                i--;
            }
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i + 1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if (j == right) {
                    newArr[newArrPos++] = ' ';//空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if (newArrPos == 0) {
            return "";
        } else {

            String ns= new String(newArr, 0, newArrPos - 1);
            System.out.println(ns);
            return ns;
        }
    }
}



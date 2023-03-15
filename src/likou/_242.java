package likou;

/**
 * @author :lhy
 * @description :有效的字母异位词
 * @date :2023/03/15 上午 11:28
 */
public class _242 {
    public static void main(String[] args) {
        String s="abc";
        String t="cba";
        boolean res = isAnagram2(s, t);
        System.out.println(res);
    }

    //大小写通用
    public static boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()) return false;

        int[] arr=new int[123];
        char[] charS=s.toCharArray();
        char[] charT=t.toCharArray();
        int count =0;
        for(int i=0;i<s.length();i++){
            if(++arr[charS[i]]<=0){
                count++;
            }
            if(--arr[charT[i]]>=0){
                count++;
            }
        }
        return count==s.length();
    }

    //经包含小写字母
    public static boolean isAnagram2(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}

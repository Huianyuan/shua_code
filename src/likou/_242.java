package likou;

/**
 * @author :lhy
 * @description :有效的字母异位词
 * @date :2023/03/15 上午 11:28
 */
public class _242 {
    public static void main(String[] args) {
        String s="abcdesf";
        String t="cdsfeab";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

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
}

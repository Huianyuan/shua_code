package likou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lhy
 * @description :电话号码的字母组合
 * @date :2023/04/20 上午 10:11
 */
public class _17 {


    public static void main(String[] args) {

        String digits="23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);

    }


    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        if(digits==null||digits.length()==0) return result;

        String[] numString={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits,numString,0,result,temp);
        return result;
    }

    public static void backtracking(String digits, String[] numString, int num,List<String> result,StringBuilder temp){
        if(num==digits.length()){
            result.add(temp.toString());
            return;
        }

        String str=numString[digits.charAt(num)-'0'];
        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            backtracking(digits,numString,num+1,result,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}

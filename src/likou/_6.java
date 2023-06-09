package likou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lhy
 * @description :N字形变换
 * @date :2023/06/09 下午 10:11
 */
public class _6 {

    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int numRows=4;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }
    public static String convert(String s, int numRows) {
        if(numRows<2) return s;
        List<StringBuilder> rows=new ArrayList<StringBuilder>();
        for(int i=0;i<numRows;i++) rows.add(new StringBuilder());

        int i=0;
        int flag=-1;//行转向标志
        for(char c:s.toCharArray()){
            rows.get(i).append(c);
            if(i==0 || i==numRows-1){
                flag=-flag;
            }
            i=i+flag;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder row:rows) res.append(row);
        return res.toString();
    }
}

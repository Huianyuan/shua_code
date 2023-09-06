package mianshi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 如：SHINEFORALL，3
 * S   E   A
 * H N F R L
 * I   O   L
 */
public class SHEIN20230906B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\.");

        String s = parts[0];
        int numRows = Integer.parseInt(parts[1]);

        String result = convert(s, numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int direction = 1; // 1 for down, -1 for up
        int row = 0;

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder rowStr : rows) {
            result.append(rowStr);
        }

        return result.toString();
    }
}
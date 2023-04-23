package likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :lhy
 * @description :N皇后问题
 * @date :2023/04/23 下午 09:07
 */
public class _51 {
    static List<List<String>> result=new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists.toString());
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] chessboard=new char[n][n];
        for(char[] c:chessboard){
            Arrays.fill(c,'.');//表示每一个空位
        }
        backtracking(n,0,chessboard);
        return result;
    }

    public static void backtracking(int n,int row ,char[][] chessboard){
        if(row==n){
            result.add(Array2List(chessboard));
            return;
        }

        for(int col=0; col<n; col++){
            if(isValid(row, col, chessboard, n)){//验证是否合法
                chessboard[row][col]='Q';//放置皇后
                backtracking(n,row+1,chessboard);
                chessboard[row][col]='.';//回撤，撤销皇后
            }
        }
    }

    public static List Array2List(char[][] chessboard){
        List<String> list=new ArrayList<>();

        for(char[] c:chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public static boolean isValid(int row ,int col,char[][] chessboard,int n){
        for(int i=0;i<row;i++){//列
            if(chessboard[i][col]=='Q') return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){//45°
            if(chessboard[i][j]=='Q') return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<n;i--,j++){//135°
            if(chessboard[i][j]=='Q') return false;
        }
        return true;
    }
}

package leetcode.leetcode37_Êý¶À;

import org.junit.Test;

import java.util.HashSet;

public class solveSudoku {
    public char[][] res;
    public char[][] input = new char[9][9];
    public HashSet<Character>[] temp_row = new HashSet[9];
    public HashSet<Character>[] temp_col = new HashSet[9];
    public HashSet<Character>[] temp_block = new HashSet[9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board[i], 0, input[i], 0, 9);
        }
        init(temp_block);
        init(temp_col);
        init(temp_row);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(input[i][j]!='.'){
                    temp_row[i].add(input[i][j]);
                    temp_col[j].add(input[i][j]);
                    temp_block[i/3*3+j/3].add(input[i][j]);
                }
            }
        }

        backtrace(0, board);
        int a = 1;
    }
    public boolean backtrace(int pos, char[][] temp_res){
        if(pos == 81){
            res = temp_res;
            return true;
        }
        int row = pos/9;
        int col = pos%9;
        if(input[row][col] != '.'){
                if(backtrace(pos+1, temp_res)){
                    return true;
                }
        }else{
            for (int i = 1; i <= 9; i++) {
                char j = (char) (i+'0');
                if(!temp_row[row].contains(j) && !temp_col[col].contains(j) && !temp_block[row/3 * 3 + col/3].contains(j)) {
                    temp_res[row][col] = j;
                    temp_row[row].add(j);
                    temp_col[col].add(j);
                    temp_block[row/3 * 3 + col/3].add(j);
                    if(backtrace(pos + 1, temp_res)){
                        return true;
                    }
                    temp_res[row][col] = '.';
                    temp_row[row].remove(j);
                    temp_col[col].remove(j);
                    temp_block[row/3 * 3 + col/3].remove(j);
                }
            }
        }
        return false;
    }
    public void init(HashSet<Character>[] array){
        for (int i = 0; i < 9; i++) {
            array[i] = new HashSet<Character>();
        }
    }
    @Test
    public void test(){
        char[][] chars = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(chars);
    }
}

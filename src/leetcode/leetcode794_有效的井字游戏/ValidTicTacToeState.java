package leetcode.leetcode794_有效的井字游戏;

import org.junit.Test;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        return testValid(board);
    }
    public int[] calNum(String[] board) {
        int X_num = 0;
        int O_num = 0;
        for (String s : board) {
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if(c == 'O'){
                    O_num++;
                }
                if(c == 'X'){
                    X_num++;
                }
            }
        }
        return new int[]{O_num,X_num};
    }
    public boolean testValid(String[] board){
        int valid_X = 0;
        int valid_O = 0;
        StringBuffer col_0 = new StringBuffer();
        StringBuffer col_1 = new StringBuffer();
        StringBuffer col_2 = new StringBuffer();
        StringBuffer major = new StringBuffer();
        StringBuffer minor = new StringBuffer();

        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            if("XXX".equals(s)){
                valid_X++;
            }
            if("OOO".equals(s)){
                valid_O++;
            }
            char[] charArray = s.toCharArray();
            col_0.append(charArray[0]);
            col_1.append(charArray[1]);
            col_2.append(charArray[2]);
            major.append(charArray[i]);
            minor.append(charArray[2-i]);
        }
        if("XXX".equals(col_0.toString())){
            valid_X++;
        }
        if("OOO".equals(col_0.toString())){
            valid_O++;
        }
        if("XXX".equals(col_1.toString())){
            valid_X++;
        }
        if("OOO".equals(col_1.toString())){
            valid_O++;
        }
        if("XXX".equals(col_2.toString())){
            valid_X++;
        }
        if("OOO".equals(col_2.toString())){
            valid_O++;
        }
        if("XXX".equals(major.toString())){
            valid_X++;
        }
        if("OOO".equals(major.toString())){
            valid_O++;
        }
        if("XXX".equals(minor.toString())){
            valid_X++;
        }
        if("OOO".equals(minor.toString())){
            valid_O++;
        }
        int[] ints = calNum(board);
        int X_num = ints[1];
        int O_num = ints[0];
        if(X_num-O_num < 0 || X_num-O_num > 1){
            return false;
        }
        else if(valid_O >= 1 && valid_X >= 1 ){
            return false;
        }
        else if(valid_O == 0 && valid_X == 0 ){
            return true;
        }
        else if(valid_O == 1 && X_num == O_num){
            return true;
        }
        else if(valid_X == 1 && X_num == O_num+1){
            return true;
        }
        else if(valid_X == 2 && X_num == 5){
            return true;
        }
        else{
            return false;
        }
    }
    @Test
    public void test(){
        String[] board = {"XXX","XOO","OO "};
        validTicTacToe(board);
    }
}

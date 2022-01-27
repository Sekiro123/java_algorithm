package leetcode.leetcode51_N»Êºó;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class n_queen_1 {
    public List<List<Integer>> res = new ArrayList<>();
    public Set<Integer> major = new HashSet<>();
    public Set<Integer> minor = new HashSet<>();
    public int n;

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        this.n = n;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrace(0, new ArrayList<Integer>());
        for (List<Integer> re : res) {
            ArrayList<String> reStr = new ArrayList<>();
            for (Integer i : re) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        stringBuffer.append("Q");
                    } else {
                        stringBuffer.append(".");
                    }
                }
                reStr.add(stringBuffer.toString());
            }
            result.add((ArrayList<String>) reStr.clone());
        }
        return result;
    }
    public void backtrace(int row, ArrayList<Integer> temp_res){
        if(row == n){
            res.add((ArrayList<Integer>)temp_res.clone());
        }
        for (int col = 0; col < n; col++) {
            if(!temp_res.contains(col) && !major.contains(row-col) &&!minor.contains(row+col)){
                temp_res.add(col);
                major.add(row-col);
                minor.add(row+col);
                backtrace(row+1, temp_res);
                temp_res.remove(temp_res.size()-1);
                major.remove(row-col);
                minor.remove(row+col);
            }
        }
    }
    @Test
    public void main() {
        ArrayList<ArrayList<String>> arrayLists = solveNQueens(5);
        System.out.println(arrayLists.toString());
    }
}

package leetcode.leetcode506_相对名次;

import org.junit.Test;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if(score[j] < score[j+1]){
                    int temp = score[j+1];
                    score[j+1] = score[j];
                    score[j] = temp;
                    int temp_2 = pos[j];
                    pos[j] = pos[j+1];
                    pos[j+1] = temp_2;
                }
            }
        }
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if(i == 0){
                res[pos[i]] = "Gold Medal";
            }
            else if(i == 1){
                res[pos[i]] = "Silver Medal";
            }
            else if(i == 2){
                res[pos[i]] = "Bronze Medal";
            }
            else{
                res[pos[i]] = String.valueOf(i+1);
            }

        }
        return res;
    }
    @Test
    public void test(){
        int[] score = {7,10,3,8,9,4};
        findRelativeRanks(score);
    }
}

package leetcode.oj.triangle;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by mark on 2/10/14.
 */

public class Solution {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[][] data = new int[triangle.size()][triangle.size()];
        int length = triangle.size();

        for (int i = 0; i < length; i++) {
            data[length - 1][i] = triangle.get(length - 1).get(i);
        }

        for (int j = length - 2; j > -1; j--) {
            for (int k = 0; k <= j; k++) {
                data[j][k] = triangle.get(j).get(k) + Math.min(data[j + 1][k], data[j + 1][k + 1]);
            }
        }
        return data[0][0];
    }

}

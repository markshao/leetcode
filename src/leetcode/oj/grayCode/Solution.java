package leetcode.oj.grayCode;

import java.util.ArrayList;

/**
 * Created by mark on 2/12/14.
 */

//http://oj.leetcode.com/problems/gray-code/

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            res.add(0);
            return res;
        }

        ArrayList<Integer> preRes = grayCode(n - 1);
        res.addAll(preRes);
        for (int i = preRes.size() - 1; i >= 0; i--) {
            res.add(preRes.get(i) + (int) Math.pow(2, n - 1));
        }
        return res;
    }
}
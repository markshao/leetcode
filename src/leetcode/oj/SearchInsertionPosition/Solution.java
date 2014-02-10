package leetcode.oj.SearchInsertionPosition;

/**
 * Created by mark on 2/10/14.
 */

public class Solution {
    public int searchInsert(int[] A, int target) {
        int i = 0;
        int position = -1;
        while (i < A.length) {
            if (A[i] == target) {
                position = i;
                break;
            } else if (A[i] < target) {
                i++;
                continue;
            } else {
                position = i;
                break;
            }
        }

        if (position == -1)
            position = A.length;

        return position;
    }
}
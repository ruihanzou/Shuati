/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
//solution 1:
/*class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}*/

//Solution 2:
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}
// @lc code=end


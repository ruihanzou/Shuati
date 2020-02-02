/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        /**
         * 这个终止条件取决于里面的判断怎么写，因为
         * start节点会往右走，使得start == end
         * 所以start < end 终止条件成立，不会造成死循环
         * 
         * 观察到的规律是：
         * 左半部分重复元素的位置在奇数位置
         * 右半部分重复元素的位置在偶数位置
         * 所以可以通过判断奇数和偶数相等情况来获得mid在哪个部分的位置
         * if (mid % 2) == 1
         * 左半部分：
         * nums[mid - 1] == nums[mid]
         * 右半部分：
         * nums[mid] == nums[mid + 1]
         * 
        */
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                // 在奇数位置， 设定往左走
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                //mid正处于在要找的目标节点的右半部分
                end = mid;
            } else {
                //mid正处于要找的目标节点的左半部分
                start = mid + 2;
            }
        }
        /**
         * 这里return start 或者 end 都一样
         * 因为只能出现start == end的情况
         * 会不会start > end 呢？
         * 不会， 原因是由end的取值条件决定的
         */
        return nums[start];
        //return nums[end];
    }
}
// @lc code=end


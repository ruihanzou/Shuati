/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
/*
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKth(nums1, nums2, n/2) + findKth(nums1, nums2, n/2 + 1)) / 2.0;
        }
        return findKth(nums1, nums2, n/2 + 1);
    }
    //从A,B两个数组中，找到第K小的数
    public int findKth(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k - 1];
        }
        if (nums2.length == 0) {
            return nums1[k - 1];
        }
        int start = Math.min(nums1[0], nums2[0]);
        int end = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (countSmallerOrEqual(nums1, mid) + countSmallerOrEqual(nums2, mid) < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    //从数组array中找出小于等于number的数有多少个
    public int countSmallerOrEqual(int[] arr, int number) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= number) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (arr[start] > number) {
            return start;
        } 
        if (arr[end] > number) {
            return end;
        }
        return arr.length;
    }
}

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, n/2) + findKth(nums1, 0, nums2, 0, n/2 + 1)) / 2.0;
        }
        return findKth(nums1, 0, nums2, 0, n/2 + 1);
    }
    //从A,B两个数组中，找到第K小的数
    public int findKth(int[] a, int aleft, int[] b, int bleft, int k) {
        //three base cases:
        //1. we already eliminate all the elements in a
        //2. we already eliminate all the elements in b
        //3. when k is reduced to 1, don't miss the base case.
        //The reason why we have this as base case in the following 
        //logic we need k >= 2 to make it work
        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }
        if (bleft >= b.length) {
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }
        // we compare the k/2 th element in a's subarray.
        // and the k/2 th element in b's subarray.
        // to determine which k/2 partition can be surely included
        // in the smallest k elements
        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval <= bval) {
            return findKth(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return findKth(a, aleft, b, bmid + 1, k - k / 2);
        }
    }
}


class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKth(nums1, nums2, n/2) + findKth(nums1, nums2, n/2 + 1)) / 2.0;
        }
        return findKth(nums1, nums2, n/2 + 1);
    }
    //从A,B两个数组中，找到第K小的数
    public int findKth(int[] a, int[] b, int k) {
        if (a.length == 0) {
            return b[k - 1];
        }
        if (b.length == 0) {
            return a[k - 1];
        }
    
        int aleft = 0;
        int bleft = 0;
        while (k >= 2) {
            int amid = aleft + k / 2 - 1;
            int bmid = bleft + k / 2 - 1;
            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
            if (aval <= bval) {
                aleft = amid + 1;
            } else {
                bleft = bmid + 1;
            }
            k = k - k / 2;
        }
        if (aleft >= a.length) {
            return b[bleft];
        }
        if (bleft >= b.length) {
            return a[aleft];
        }
        return Math.min(a[aleft], b[bleft]);
    }
}

// @lc code=end


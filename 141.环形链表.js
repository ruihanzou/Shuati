/*
 * @lc app=leetcode.cn id=141 lang=javascript
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    if (!head || !head.next || !head.next.next) {
        return false;
    }
   
    let slow = head;
    let fast = head;
    while (fast && fast.next) {
        fast = fast.next.next
        if (slow == fast) {
            return true
        }
        slow = slow.next
    }
    return false
};
// @lc code=end


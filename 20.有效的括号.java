import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> validPairs = new HashMap<>();
        validPairs.put('(', ')');
        validPairs.put('{', '}');
        validPairs.put('[', ']');
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ele : arr) {
            if (validPairs.containsKey(ele)) {
                stack.offerLast(ele);
            } else if (stack.isEmpty() || ele != validPairs.get(stack.pollLast())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end


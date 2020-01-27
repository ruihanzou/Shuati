import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.equals("..")) {
                stack.pollLast();
            } else if (!p.equals("") && !p.equals(".")) {
                stack.offerLast(p);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append("/" + stack.pollFirst());
        }
        return res.toString();
        //return "/" + stack.stream().collect(Collectors.joining("/"));
    }
}
// @lc code=end


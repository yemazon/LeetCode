package leetcode;

public class Solution294 {
    public boolean canWin(String s) {
        return helper(s, false);
    }

    private boolean helper(String s, boolean flag) {
        if (s == null || s.length() <= 1) {
            return flag;
        }

        if (s.charAt(0) == '-') {
            return helper(s.substring(1,s.length()), flag);
        } else if (s.charAt(0) == '+' && s.charAt(1) == '-') {
            return helper(s.substring(2,s.length()), flag);
        } else {
            return helper(s.substring(2, s.length()), !flag);
        }
    }
}

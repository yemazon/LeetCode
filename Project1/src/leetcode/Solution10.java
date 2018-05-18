package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution10 {
    public boolean isMatch(String s, String p) {

        if (s == null || s.length() == 0) {
            return (p == null || p.length() == 0);
        }

        Node sNode = construct(s);
        Node pNode = construct(p);

        while (sNode != null || pNode != null) {
            if (sNode == null) {
                while (pNode != null) {
                    if (pNode.amount != Integer.MAX_VALUE) {
                        return false;
                    } else {
                        pNode = pNode.next;
                    }
                }
                return true;
            }

            if (pNode == null) {
                return false;
            }

            if (sNode.value == pNode.value || pNode.value == '.') {
                if (pNode.amount == Integer.MAX_VALUE) {
                    sNode = sNode.next;
                } else if (pNode.amount >= sNode.amount) {
                    sNode = sNode.next;
                    pNode = pNode.next;
                } else {
                    return false;
                }
            } else {
                if (pNode.amount == Integer.MAX_VALUE) {
                    pNode = pNode.next;
                } else {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.isMatch("ab", ".*"));
        Map m = new HashMap();
        m.containsKey()
    }

    private class Node {
        public Character value;
        public int amount;
        public Node next;

        public Node(Character value, int amount) {
            this.value = value;
            this.amount = amount;
        }
    }

    public Node construct(String s) {
        Node dummy = new Node('#', 0);
        Node head = dummy;
        Character first = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                count++;
            } else if (s.charAt(i) == '*') {
                count = Integer.MAX_VALUE;
            } else {
                head.next = new Node(first, count);
                head = head.next;
                first = s.charAt(i);
                count = 1;
            }
        }
        head.next = new Node(first, count);
        return dummy.next;
    }
}

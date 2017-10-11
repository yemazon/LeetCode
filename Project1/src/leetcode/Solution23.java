package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for(ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            while (listNode.next != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }
        if (list.size() == 0) {
            return null;
        }
        int[] array = toIntArray(list);
        Arrays.sort(array);
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        for (int i=0;i<array.length;i++) {
            node = new ListNode(array[i]);
            node.next = new ListNode(0);
            node = node.next;
        }
        return dummy;
    }
    private int[] toIntArray(List<Integer> list){
        if(list == null || list.size() == 0) {
            return null;
        }
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }
}

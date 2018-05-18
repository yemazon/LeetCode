///**
// * Definition for ListNode.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int val) {
// *         this.val = val;
// *         this.next = null;
// *     }
// * }
// */
//public class Solution {
//    /**
//     * @param lists: a list of ListNode
//     * @return: The head of one sorted list.
//     */
//    public ListNode mergeKLists(List<ListNode> lists) {
//        // write your code here
//        if( lists == null || lists.size() < 1 ) return null;
//        return mergeHandler(lists, 0, lists.size() - 1);
//    }
//    public ListNode mergeHandler(List<ListNode> list, int start, int end){
//        if( start > end ) return null;
//        if( start == end ) return list.get(start);
//        int mid = (start + end)/2;
//        ListNode first = mergeHandler(list, start, mid);
//        ListNode second = mergeHandler(list, mid + 1, end);
//        ListNode head = new ListNode(0), node = head;
//        while(first != null && second != null){
//            if(first.val < second.val){
//                node.next = first;
//                node = node.next;
//                first = first.next;
//            }else{
//                node.next = second;
//                node = node.next;
//                second = second.next;
//            }
//        }
//        if(first == null){
//            if(second == null) return head.next;
//            node.next = second;
//        }else node.next = first;
//        return head.next;
//    }
//}

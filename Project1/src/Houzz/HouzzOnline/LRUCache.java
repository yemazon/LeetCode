import java.util.HashMap;

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node current = map.get(key);
        // delete current node
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // add current node to head;
        current.next = head.next;
        head.next = current;
        current.prev = head;
        current.next.prev = current;
        return map.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // update value
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        // check capacity
        if (map.size() == capacity) {
            Node deleteItem = tail.prev;
            deleteItem.prev.next = tail;
            tail.prev = deleteItem.prev;
            map.remove(deleteItem.key);
        }
        // add new node
        Node node = new Node(key, value);
        map.put(key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}
package JavaCollectionClass;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        //
//        List<String> arraylist = new ArrayList<>();
//        List<String> linkedlist = new LinkedList<>();
//
//        linkedlist.add("a");
//        linkedlist.add("c");
//        linkedlist.add("b");
//        System.out.println(linkedlist.get(0));

        Set<Item> set = new HashSet<>(2,2.0f);
        Item foo = new Item("foo");
        set.add(foo);

        System.out.println(set.contains(foo));
        System.out.println(set.contains(new Item("foo")));

        foo.setValue("foos");
        System.out.println(set.size());

        set.add(foo);
        System.out.println(set.size());

        set.remove(foo);
        System.out.println(set.size());

//        System.out.println("-------");
//        System.out.println(new Item("foo").hashCode());
//        System.out.println(new Item("foos").hashCode());
//
//        for (Item item : set) {
//            System.out.println(item.hashCode());
//        }

        System.out.println(set.contains(foo));
//        Collections.binarySearch()
    }
}

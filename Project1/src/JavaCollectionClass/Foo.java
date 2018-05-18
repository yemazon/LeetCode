package JavaCollectionClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Foo {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("foo");
        collection.add("bar");

        //wrong way
        collection.add("Wat!");

        System.out.println(collection.size());

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            //System.out.println(collection.remove(value)); 这样是不对的
            //应该调用
            //iterator.remove();

            System.out.println(collection.remove(value));
        }

        System.out.println(collection.size());
    }
}

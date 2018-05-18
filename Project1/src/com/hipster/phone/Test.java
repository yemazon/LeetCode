package com.hipster.phone;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        TextingDictionary textingDictionary = new TextingDictionary();

        textingDictionary.insert("CMO");
        textingDictionary.insert("Bat");
        textingDictionary.insert("Combo");
        textingDictionary.insert("Test");
        textingDictionary.insert("Apple");




        List<ValidTextKeyPress> list = new ArrayList<>();
        list.add(ValidTextKeyPress.Two);
        list.add(ValidTextKeyPress.Six);

        //System.out.println(textingDictionary.getMap().keySet());


        List<String> list1 = textingDictionary.search(list);

        System.out.println(list1);


    }
}

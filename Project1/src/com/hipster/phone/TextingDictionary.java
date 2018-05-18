package com.hipster.phone;

import java.util.*;

public class TextingDictionary {

    private final Map<List<ValidTextKeyPress>, Set<String>> map;

    public TextingDictionary() {
        map = new HashMap<>();
    }

    /**
     * break the word to Map of <List<ValidTextKeyPress> and List<String>>
     * for example: "bat"
     * {Two} -> {"bat"}, {Two, Two} -> {"bat"}, {Two, Two, Eight} -> {"bat"}
     * @param word to be handled
     */
    public void insert(String word) {
        if (word == null || !word.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("can only take in a-z and A-Z");
        }

        List<ValidTextKeyPress> prefixList = new LinkedList<>();
        word = word.toLowerCase();
        NumberPrefixConverter converter = new NumberPrefixConverter();
        for (int i = 0; i < word.length(); i++) {
            insertHelper(prefixList, converter.transfer(word.substring(i,i+1)), word);
        }
    }

    /**
     * function used to search prefixes
     * @param prefixes is the input search keyword
     * @return the result of search of prefixes
     */
    public List<String> search(List<ValidTextKeyPress> prefixes) {
        return (map.get(prefixes) == null) ? new ArrayList<>() : new ArrayList<>(map.get(prefixes));
    }

    /**
     * help the insert function to finish the map one key after another
     * @param prefixes keeps all the ValidTextKeyPress already dealt with
     * @param key is the ValidTextKeyPress that needs to be handled
     * @param word to be added
     */
    private void insertHelper(List<ValidTextKeyPress> prefixes, ValidTextKeyPress key, String word) {
        prefixes.add(key);
        List<ValidTextKeyPress> prefixInMap = new LinkedList<>();
        prefixInMap.addAll(prefixes);
        Set<String> stringList;
        if (map.containsKey(prefixes)) {
            stringList =  map.get(prefixes);
            stringList.add(word);
            map.put(prefixes, stringList);
        } else {
            stringList = new HashSet<>();
            stringList.add(word);
            map.put(prefixInMap, stringList);
        }
    }
}

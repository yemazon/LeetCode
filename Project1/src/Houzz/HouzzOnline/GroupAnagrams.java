/*

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char ch : s.toCharArray()) {
                key *= (prime[ch - 'a']);
            }
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
            }
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

*/
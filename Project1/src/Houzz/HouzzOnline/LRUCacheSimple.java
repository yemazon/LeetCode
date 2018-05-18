//package Houzz.HouzzOnline;
////
////import java.util.LinkedHashMap;
////import java.util.Map;
////
////@SuppressWarnings("unchecked")
////public class LRUCacheSimple {
////	int capacity;
////	LinkedHashMap<Integer, Integer> cache;
////	public LRUCache(int capacity) {
////		this.capacity = capacity;
////		cache = new LinkedHashMap<>(capacity, 0.75, true) {
////			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
////				return size() > capacity;
////			}
////		};
////	}
////	// @return an integer
////    public int get(int key) {
////    	if (!map.contains(key)) {
////    		return -1;
////    	} else {
////    		return map.get(key);
////    	}
////    }
////    public void set(int key, int value) {
////    	map.put(key, value);
////    }
////}
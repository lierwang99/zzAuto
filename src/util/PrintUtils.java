/**
 * 
 */
package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class PrintUtils {

	public static void printStringArray(String[] strArray) {
		int x = 1 ;
		for(String str : strArray) {
			System.out.println(x++ + " : " + str);
		}
	}
	public static void printIntArray(int[] intArray) {
		int x = 1 ;
		for(int i : intArray) {
			System.out.println(x++ + " : " + i);
		}
	}
	public static void printObjectArray(Object[] objArray) {
		int x = 1 ;
		for(Object obj : objArray) {
			System.out.println(x++ + " : " + obj);
		}
	}
	
	/**
	 * 通过迭代器输出
	 * @param <E>
	 * @param coll
	 */
	public static <E> void printCollection(Collection<E> coll) {
		Iterator<E> iterator = coll.iterator();
		int x = 1 ;
		while(iterator.hasNext()) {
			E e = iterator.next();
			System.out.println(x++ + " : " + e);
		}
	}
	
	/**
	 * map.Iterator通过while(){}
	 * @param <K>
	 * @param <V>
	 * @param map
	 */
	public static <K,V> void printMapByIterator(Map<K,V> map) {
		Set<Map.Entry<K, V>> entrySet = map.entrySet();
		Iterator<Map.Entry<K, V>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Map.Entry<K, V> next = iterator.next();
			K key = next.getKey();
			V value = next.getValue();
			System.out.println(key+" : "+value);
		}
	}
	
	/**
	 * forEach进行输出。
	 * @param <K>
	 * @param <V>
	 * @param map
	 */
	public static <K,V> void printMapByForEach(Map<K,V> map) {
		Set<Map.Entry<K, V>> entrySet = map.entrySet();
		for(Map.Entry<K, V> mapEntry :entrySet) {
			K key = mapEntry.getKey();
			V value = mapEntry.getValue();
			System.out.println(key+" : "+value);
		}
	}
	
	
	
	public static void main(String[] args) {
		printStringArray(new String[] {"1","2","3"}) ;
		printObjectArray(new Object[] {1,2,2.3,true,null,"StringA"});
	}
}

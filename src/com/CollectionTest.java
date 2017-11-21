package com;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 集合的测试
 * */
public class CollectionTest {
	
	public static void main(String[] args) {
		/**
		 * 测试Iterator和ListIterator
		 * 任何集合类都能使用Iterator,但是只有List、ArrayList、LinkedList和Vector可以使用ListIterator
		 * **/
//		List<String> ids = new ArrayList<>(0);
//		ids.add("ddd");
//		ids.add("ddx");
//		ids.add("ddh");
//		
//		ListIterator<String> liter = ids.listIterator();
//		liter.hasNext();
//		String temps = liter.next();
//		System.out.println(temps);
//		liter.set("sdf");
//		liter.add("235");
//		liter.hasPrevious();
//		liter.previous();
//		liter.add("235");
//		liter.nextIndex();
//		System.out.println(Pattern.compile("\\b([\\w]*)\\b").matcher(ids.toString()).find()); 
//		System.out.println(ids.toString().replaceAll("\\b([\\w]*)\\b", "'$1").replaceAll(" ", "").replace("[", "(").replace("]", ")"));
//		System.out.println(s);
//		System.out.println(ids.toString().replace(",", "','").replace("[", "['").replace("]", "']").replaceAll(" ", ""));
		
		/**
		 * HashMap源码分析
		 * */
		Map<String,Object> map =  new HashMap<String,Object>();
		Map<String,Object> map2 =  new HashMap<String,Object>();
		map.put("ft", map);
		map.put("ft2", "123");
		System.out.println(map.toString());
		if (map.equals(map2)) {
			System.out.println("test.....");
		} 
		/**
		 * Map的以下方法就不一一展示了,日常常用
		 * size();
		 * isEmpty();
		 * containsKey(key);
		 * containsValue(value);
		 * get(key);
		 * put(key,value);
		 * remove(Object);
		 * putAll(Map);
		 * clear();
		 * keySet();
		 * values();
		 * EntrySet<K,V>();
		 * equals();
		 * hasCode();
		 */
		//看一下HashTable和HashMap的区别
		Hashtable<String,String> ht = new Hashtable<String, String>();
		ht.put("123", "123");
		ht.put("12", "12");
		//同步方法
		Enumeration<String> ss = ht.elements();
		while(ss.hasMoreElements()){
			System.out.println(ss.nextElement());
		}
		
		System.out.println(new ArrayList());
	}
}

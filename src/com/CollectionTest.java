package com;

import java.util.HashMap;
import java.util.Map;

/**
 * ���ϵĲ���
 * */
public class CollectionTest {
	
	public static void main(String[] args) {
		/**
		 * ����Iterator��ListIterator
		 * �κμ����඼��ʹ��Iterator,����ֻ��List��ArrayList��LinkedList��Vector����ʹ��ListIterator
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
		 * HashMapԴ�����
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
		 * Map�����·����Ͳ�һһչʾ��,�ճ�����
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
	}
}

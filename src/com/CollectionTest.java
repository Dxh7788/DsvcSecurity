package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
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
		//��һ��HashTable��HashMap������
		Hashtable<String,String> ht = new Hashtable<String, String>();
		ht.put("123", "123");
		ht.put("12", "12");
		//ͬ������
		Enumeration<String> ss = ht.elements();
		while(ss.hasMoreElements()){
			System.out.println(ss.nextElement());
		}
		
		System.out.println(new ArrayList<String>());
		
		//SingletonList��ʹ��
		List<String> singletonList = Collections.singletonList(new String(""));
		System.out.println(singletonList.size());
	}
}

package com;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

/**
 * ���ϵĲ���
 * */
public class CollectionTest {
	
	public static void main(String[] args) {
		/**
		 * ����Iterator��ListIterator
		 * �κμ����඼��ʹ��Iterator,����ֻ��List��ArrayList��LinkedList��Vector����ʹ��ListIterator
		 * **/
		List<String> ids = new ArrayList<>(0);
		ids.add("ddd");
		ids.add("ddx");
		ids.add("ddh");
		
		ListIterator<String> liter = ids.listIterator();
		liter.hasNext();
		String temps = liter.next();
		System.out.println(temps);
		liter.set("sdf");
		liter.add("235");
		liter.hasPrevious();
		liter.previous();
		liter.add("235");
		liter.nextIndex();
		System.out.println(Pattern.compile("\\b([\\w]*)\\b").matcher(ids.toString()).find()); 
		System.out.println(ids.toString().replaceAll("\\b([\\w]*)\\b", "'$1").replaceAll(" ", "").replace("[", "(").replace("]", ")"));
//		System.out.println(s);
//		System.out.println(ids.toString().replace(",", "','").replace("[", "['").replace("]", "']").replaceAll(" ", ""));
	}
}

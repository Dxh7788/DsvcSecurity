package org.otk.listsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.otk.model.User;

public class Sorter {
	
	public static void main(String[] args) {
		
		User user1 = new User(1,"ddd");
		User user2 = new User(1,"dxd");
		User user3 = new User(1,"dhd");
		
		List<User> us = new ArrayList<User>();
		us.add(user1);
		us.add(user2);
		us.add(user3);
		
		Collections.sort(us,new Comparator<User>(){
			@Override
			public int compare(User arg0, User arg1) {
				return 0;
			}
		});
	}
}

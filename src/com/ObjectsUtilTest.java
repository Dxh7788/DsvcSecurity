package com;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.dsvc.model.Address;
import com.dsvc.model.User;

/**
 * 研究下Objects工具类
 * */
public class ObjectsUtilTest {
	public static void main(String[] args) {
		
		String t1 = "abc";
		String t2 = "abc";
		//Objects.equals和Objects.deepEquals的相同点
		System.out.println(Objects.equals(t1, t2));
		System.out.println(Objects.deepEquals(t1, t2));
		//Objects.equals和Objects.deepEquals的不同点是,deepEquals可用来比较数组
		String[] ta1={"a","b","c"};
		String[] ta2={"a","b","c"};
		System.out.println(Objects.equals(ta1, ta2));
		System.out.println(Objects.deepEquals(ta1, ta2));
		//那么自定义类可以这样比较吗?由结果可知无论是Objects.equals或者Objects.deepEquals都无法比较自定义类,因为自定义类无法一一重载hashCode和equals方法
		User u1 =new User();
		User u2 =new User();
		System.out.println(Objects.equals(u1, u2));
		System.out.println(Objects.deepEquals(u1, u2));
		//关于hashCode和hash方法,直接调用hashCode和使用Objects的hashCode是一样的.hash只能用来操作数组,不能用来操作非数组
		System.out.println(t1.hashCode()+"   "+Objects.hashCode(t1));
		System.out.println(ta1.hashCode()+"   "+Objects.hashCode(ta1));
		System.out.println(t1.hashCode()+"   "+Objects.hash(t1));
		
		u1.setName("ddd");
		u2.setName("ddd");
		Address addr = new Address();
		u1.setAddress(addr);
		u2.setAddress(addr);
		u1.setPwd("123");
		u2.setPwd("234");
		//hash的行为
		Objects.hash(u1);
		System.out.println(Objects.hash(u1.getAddress(),u1.getName(),u1.getPwd()));
		System.out.println(Objects.hash(u2.getAddress(),u2.getName(),u2.getPwd()));
		System.out.println(Objects.hash(u1)==Objects.hash(u2));
		/**
		 * 判空,总的来说,Objects工具类的判空操作比较初级,比起apache工具类的StringUtils类不够完善,StringUtils的isBlank不仅能判定字符串中是否为空,为空指针,还判定字符串中是否是空格.如下展示：
		 * true
		 *false
		 *false
		 *false
		 *true
		 *true
		 *true
		 *false
		 * */
		System.out.println(Objects.isNull(null));
		System.out.println(Objects.isNull(""));
		System.out.println(Objects.isNull(" "));
		System.out.println(Objects.isNull("123  365"));
		System.out.println(StringUtils.isBlank(""));
		System.out.println(StringUtils.isBlank(null));
		System.out.println(StringUtils.isBlank(" "));
		StringUtils.isBlank("123  365");
		System.out.println(StringUtils.isBlank("123  365"));
	}
}

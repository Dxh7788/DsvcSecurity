package com;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.dsvc.model.Address;
import com.dsvc.model.User;

/**
 * �о���Objects������
 * */
public class ObjectsUtilTest {
	public static void main(String[] args) {
		
		String t1 = "abc";
		String t2 = "abc";
		//Objects.equals��Objects.deepEquals����ͬ��
		System.out.println(Objects.equals(t1, t2));
		System.out.println(Objects.deepEquals(t1, t2));
		//Objects.equals��Objects.deepEquals�Ĳ�ͬ����,deepEquals�������Ƚ�����
		String[] ta1={"a","b","c"};
		String[] ta2={"a","b","c"};
		System.out.println(Objects.equals(ta1, ta2));
		System.out.println(Objects.deepEquals(ta1, ta2));
		//��ô�Զ�������������Ƚ���?�ɽ����֪������Objects.equals����Objects.deepEquals���޷��Ƚ��Զ�����,��Ϊ�Զ������޷�һһ����hashCode��equals����
		User u1 =new User();
		User u2 =new User();
		System.out.println(Objects.equals(u1, u2));
		System.out.println(Objects.deepEquals(u1, u2));
		//����hashCode��hash����,ֱ�ӵ���hashCode��ʹ��Objects��hashCode��һ����.hashֻ��������������,������������������
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
		//hash����Ϊ
		Objects.hash(u1);
		System.out.println(Objects.hash(u1.getAddress(),u1.getName(),u1.getPwd()));
		System.out.println(Objects.hash(u2.getAddress(),u2.getName(),u2.getPwd()));
		System.out.println(Objects.hash(u1)==Objects.hash(u2));
		/**
		 * �п�,�ܵ���˵,Objects��������пղ����Ƚϳ���,����apache�������StringUtils�಻������,StringUtils��isBlank�������ж��ַ������Ƿ�Ϊ��,Ϊ��ָ��,���ж��ַ������Ƿ��ǿո�.����չʾ��
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
3	}
}

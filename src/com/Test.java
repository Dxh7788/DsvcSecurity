package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.otk.model.User;


public class Test {

    public static void main(String[] args){
        String s = "1.12511965E9, 1.3134877E7, 6.70219968E8, 7447400.0, 7.54892376E8, 5136042.0, 2.460051E7, 1.85955416E8, 52769.0, 3.98237983E8, 4.54841268E8, 2.83502544E8, 876931.0, 640322.0, 2.62509625E9, 1399999.0, 1.72882069E8, 7.67072208E8, 1.77497969E9, 4.11156612E8, 1.06626912E8, 1.540947633E9, 1.362020287E9, 8.574827E7, 2.02021623E8, 9.65134177E8, 4.96356134E8, 2.81731921E8, 6851312.0, 1.817731585E9, 4.46187667E8, 9.8321282E7, 9.42714509E8, 9.41878387E8, 6.53419409E8, 2.82987439E8, 7.39551085E8, 3.31392267E8, 3.60026247E8, 7.7026962E7, 8.9209921E8, 1.044150754E9, 3.5888634E7, 5.0021258E7, 3.342575E7, 6.9487741E8, 9.19136228E8, 2.45562571E8, 5927665.0, 5.61676719E8, 8.44527653E8, 7.59619428E8, 9952795.0, 3.29748456E8, 1.24018376E8, 1.23021545E8, 3.3115096E7, 1.71343904E8, 1.978047078E9, 4.10030411E8, 1.23021545E8";
//        System.out.println(s.replaceAll(", ","\n"));
        List<String> ks = new ArrayList<String>();
        ks.add("qw");
        ks.add("lk");
        ks.add("oi");
        for(String k:ks){
        }
        
        System.out.println(new Date().getTime());
//        System.out.println(ks.toString());
//        System.out.println(StringUtils.strip(ks.toString().replaceAll("\"", "\'"),"[]"));
        
//        
//        String[] k = new String[]{"id",
//        		"debtName",
//        		"debtType",
//        		"tiexiRate",
//        		"tiexiPeriod",
//        		"tiexiUnit",
//        		"minRate",
//        		"MaxRate",
//        		"leftRemainMoney",
//        		"freeFeeDay",
//        		"accuredJoinedMoney",
//        		"accuredJoinedNum",
//        		"debtDesc",
//        		"isKZPlan",
//        		"startMoney",
//        		"incrMoney",
//        		"addendusMoney",
//        		"balance",
//        		"feeRate"};
//        for(String k0:k){
//        	System.out.println("debtelidgeDetailRespData.set"+k0.substring(0,1).toUpperCase()+k0.substring(1,k0.length())+"();");
//        	
//        }
        System.out.println("[");
	        String [] convert = new String[]{"String,id,//id","String,senderUserName,//������","String,recevierUserName,//������","String,title,//����","String,content,//����","String,receiveTime,//����ʱ��","String,status,//��Ϣ״̬","String,isdelete,//�Ƿ�ɾ��"};
	        System.out.println("      {");
	        for(String c:convert){
	        	String[] a = c.split("[*,*]");
	        	System.out.println("        \""+a[1]+"\":\"\","+a[2]+",\""+a[0]+"\"");
	        }
	        System.out.println("      },");
        System.out.println("]");
        System.out.println(ObjectUtils.identityToString(ks));
        System.out.println(ks.hashCode());
        System.out.println(Integer.toHexString(System.identityHashCode(ks)));
        
        User u = new User();
        //hashCode��identityHashCode��ֵһ��,identityHashCode������ΪhashCode�ĸ���
        System.out.println(u.hashCode());
        System.out.println(System.identityHashCode(u));
        System.out.println(System.identityHashCode(new User()));
        System.out.println(System.identityHashCode(new User()));
        System.out.println(System.identityHashCode(new User()));
        
        String s0="invest_success,join_novice_plan_success,join_plan_success,join_roll_plan_success,join_twenty_one_plan_success,withdraw_fail,withdraw_success,recharge_success,advance_repay,normal_repay,overdue_repay,invest_rebate_Transfered,coupon_transfered,platform_reward,platform_tiexi_transfer,reward_money_transfered,exit_sheng_xin_bao_plan,give_money_to_borrower";
        String [] ss0=s0.split("[*,*]");
        System.out.println(ss0.length);
        
    }
    
}

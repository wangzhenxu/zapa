package com.loiot.baqi.utils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.loiot.baqi.constant.DictionaryUtil;
import com.loiot.baqi.pojo.ZpCompanyJobInfo;
import com.loiot.baqi.pojo.ZpDictionaryInfo;
import com.loiot.baqi.pojo.ZpJlInfo;
import com.loiot.baqi.status.JobMatchType;
import com.loiot.commons.utils.StringUtil;


public class JLBUtils {
	
	public static String dealDeEducation(String str){
		if(str!=null && "大专".equals(str))
		str="专科";
		str=str.replace(" ", "");
		return str;
	}
	
	public static String dealbirthday(String str){
		 str= str.replace("年", "-").replace("月", "-").replace("/", "-").replace(".", "-").replace("\\", "-");
		 str=str+"-01";
		 return str;
	}
	
	public static String englishLevel(String str){
		if(str!=null && ("英语四级".equals(str) || "CET-4".equalsIgnoreCase(str)))
	    str="四级";
		if(str!=null && ("英语六级".equals(str) || "CET-6".equalsIgnoreCase(str)))
	    str="六级";
		if(str!=null && ("英语八级".equals(str) || "CET-8".equalsIgnoreCase(str)))
		str="八级";
		return str;
	}
	
	
	public static String  dealYearMoney(Long money){
		String str = "";
		if(money!=null) {
			str=String.valueOf(money/10000);
		}
		return str;
	}
	
	public static String dealExpectedYearMoney(Long start ,Long end){
		String str="";
		String startStr="";
		String endStr="";
		if(start!=null) {
			startStr=String.valueOf(start/10000);
		}
		if(end!=null) {
			endStr=String.valueOf(end/10000);
		}
		
		if(start==null && end==null){
			str = "无";
		} else 
		if(start!=null && end==null){
			str = startStr+"万以上";
		} else
		if(start==null && end!=null){
			str = endStr+"万以下";
		}
		else
		if(start!=null && end!=null){
			str = startStr+"-" +endStr +"万";
		}
		return str;
	}
	
	//自动放大，预计年薪
	public static void dealExpectedYearMoneyBig(ZpCompanyJobInfo p){
	    Double startMoney = p.getExpectedYearMoneyStart();
	    Double endMoney = p.getExpectedYearMoneyEnd();
	    if(startMoney!=null)
	    {
	    	startMoney = startMoney*10000;
	    }
	    if(endMoney!=null)
	    {
	    	endMoney = endMoney*10000;
	    }
	    p.setExpectedYearMoneyStart(startMoney);
	    p.setExpectedYearMoneyEnd(endMoney);
	}
	
	//简历预计月薪转换年薪
	public static Long   getJlExpectedYearWan(Long salaryRequireId,int index){
		Double money=0d;
		ZpDictionaryInfo info = DictionaryUtil.getBean(salaryRequireId);
		if(info.getValue()!=null){
			String moneyStr=info.getValue().split(",")[index];
			money= Double.parseDouble(moneyStr)*12;
			return money.longValue();
		}
	    return money.longValue();
	}
	
	//月薪转年薪 （页面调用）
	public static String mothMoneyCovertYearMoney(Long salaryRequireId){
		long startMoney = getJlExpectedYearWan(salaryRequireId,0);
		long endMoney = getJlExpectedYearWan(salaryRequireId,1);
		return dealExpectedYearMoney(startMoney, endMoney);
	}
		
		
	
	public static String dealAgeRange(Integer start ,Integer end){
		String str="";
		if(start==null && end==null){
			str = "无";
		} else 
		if(start!=null && end==null){
			str = start+"岁以上";
		} else
		if(start==null && end!=null){
			str = end+"岁以下";
		}
		else
		if(start!=null && end!=null){
			str = start+"-" +end +"岁";
		}
		return str;
	}
	
	public static String dealWordTerm(Integer start, Integer end ){
		String str="";
		if(start==null && end==null){
			str = "无";
		} else 
		if(start!=null && end==null){
			str = start+"年以上";
		} else
		if(start==null && end!=null){
			str = end+"年以下";
		}
		else
		if(start!=null && end!=null){
			str = start+"-" +end +"年";
		}
		return str;
	}
	
	
	public static void testmoney(){
		ZpJlInfo jl = new ZpJlInfo();
		jl.setSalaryRequireId(2l);
	   
		ZpCompanyJobInfo job = new ZpCompanyJobInfo();
		//job.setExpectedYearMoneyStart(14000d);
		//job.setExpectedYearMoneyEnd(19000d);
		
		Double moneyS = job.getExpectedYearMoneyStart();
		Double moneyE = job.getExpectedYearMoneyEnd();
		String  startMatchFlag ="";
		String  endMatchFlag="";
		String resultMatchFlag="";
		if(moneyS!=null){
			Double jlMoneyS=  15000d;
			if(jlMoneyS!=null){
				 startMatchFlag="nomatch";
				 if(moneyS<=jlMoneyS){
					 startMatchFlag="match";
				 } else {
					 startMatchFlag="nomatch";
				 }
			}
		}
		
		if(moneyE!=null){
			Double jlMoneyE= 20000d;
			if(jlMoneyE!=null){
				endMatchFlag="nomatch";
				 if(moneyE>=jlMoneyE){
					 endMatchFlag="match";
				 } else {
					 endMatchFlag="nomatch";
				 }
			}
		}
		
		if(moneyS!=null && moneyE!=null){
			if(startMatchFlag.equals("match") &&  endMatchFlag.equals("match")){
				resultMatchFlag="match"; 
			} else {
				resultMatchFlag="nomatch";
			}
		}else
		if(moneyS!=null){
			if(startMatchFlag.equals("match")){
				resultMatchFlag="match"; 
			}else {
				resultMatchFlag="nomatch";
			}
		}else
		if(moneyE!=null){
			if(endMatchFlag.equals("match")){
				resultMatchFlag="match"; 
			}else {
				resultMatchFlag="nomatch";
			}
		}
		
	  System.out.println("startMatchFlag:" + startMatchFlag);
	  System.out.println("endMatchFlag:" + endMatchFlag);
	  System.out.println("resultMatchFlag:" + resultMatchFlag);
	}
	
	public static void testAGE(){
		ZpJlInfo jl = new ZpJlInfo();
		
	   
		ZpCompanyJobInfo job = new ZpCompanyJobInfo();
		//job.setExpectedYearMoneyStart(14000d);
		//job.setExpectedYearMoneyEnd(19000d);
		
		Integer ageS = job.getAgeStart();
		Integer ageE = job.getAgeEnd();
		String  startMatchFlag ="";
		String  endMatchFlag="";
		String resultMatchFlag="";
		if(ageS!=null){
			Integer jlageS=  12;
			if(jlageS!=null){
				 startMatchFlag="nomatch";
				 if(ageS<=jlageS){
					 startMatchFlag="match";
				 } else {
					 startMatchFlag="nomatch";
				 }
			}
		}
		
		if(ageE!=null){
			Integer jlageE= 20;
			if(jlageE!=null){
				endMatchFlag="nomatch";
				 if(ageE>=jlageE){
					 endMatchFlag="match";
				 } else {
					 endMatchFlag="nomatch";
				 }
			}
		}
		
		if(ageS!=null && ageE!=null){
			if(startMatchFlag.equals("match") &&  endMatchFlag.equals("match")){
				resultMatchFlag="match"; 
			} else {
				resultMatchFlag="nomatch";
			}
		}else
		if(ageS!=null){
			if(startMatchFlag.equals("match")){
				resultMatchFlag="match"; 
			}else {
				resultMatchFlag="nomatch";
			}
		}else
		if(ageE!=null){
			if(endMatchFlag.equals("match")){
				resultMatchFlag="match"; 
			}else {
				resultMatchFlag="nomatch";
			}
		}
		
	  System.out.println("startMatchFlag:" + startMatchFlag);
	  System.out.println("endMatchFlag:" + endMatchFlag);
	  System.out.println("resultMatchFlag:" + resultMatchFlag);
	}
	
	public static String dealDistance(String distance){
		String result="无";
		if(!StringUtils.isBlank(distance)){
			int kmps=Integer.parseInt(distance)/1000;
			result=kmps+"公里";
		}
		return result;
	}
	
	public static String dealduration(String duration){
		String result="无";
		if(!StringUtils.isBlank(duration)){
			int second=Integer.parseInt(duration);
			int minute=second/60;
			//minute=80;
			if(minute>60){
				int hour=minute/60;
				int residue=minute%60;
				result=hour+"小时"+residue+"分";
			}else{
				result=minute+"分";
			}	
		}
		return result;
	}
	
	public static void dealJlKeyWord(){
		String content ="sdfsadff  sdf  df";
		String keyword="sdf";
		
		
	}
	
	public static void main(String args[]) {
		
		//System.out.println(JLBUtils.dealYearMoney(500l));;
		//String str1= JLBUtils.dealExpectedYearMoney(null, 250000l);
		//System.out.println(str1);
		//System.out.println(JLBUtils.dealYearMoney(500l));
		//JLBUtils.testmoney();
		System.out.println(JLBUtils.dealduration("8088"));
	}
	
	
	
	

}

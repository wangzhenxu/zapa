package com.loiot.baqi.constant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.loiot.baqi.pojo.ZpDictionaryInfo;
import com.loiot.baqi.status.DictionaryType;
import com.loiot.baqi.utils.IndexInfoSingleTon;
import com.loiot.commons.utils.FileUtil;
import com.loiot.commons.utils.JsonUtil;
/**
 * 招聘字典 类
 * @author Administrator
 *
 */
public class DictionaryUtil {
	
	public static List<ZpDictionaryInfo> getTypes(int type){
		List<ZpDictionaryInfo> dictList=queryDicAll();
		List<ZpDictionaryInfo> newList = new ArrayList<ZpDictionaryInfo>();
		for(ZpDictionaryInfo dic : dictList){
			if(dic.getType()!=null && dic.getType()==type){
				newList.add(dic);
			}
		}
		return newList;
	}
	
	public static String getName(Long code){
		if(code==null){
			return "";
		}
		List<ZpDictionaryInfo> dictList=queryDicAll();
		String name ="";
		for(ZpDictionaryInfo dic : dictList){
			//System.out.println(code+"=" + dic.getDictionaryId()  +"结果:"+(dic.getDictionaryId()==code));
			if(dic.getDictionaryId().intValue()==code.intValue()){
				name=dic.getShowName();
				break;
			}
		}
		return name;
	}
	
	public static ZpDictionaryInfo getBean(Long code){
		if(code==null){
			return null;
		}
		List<ZpDictionaryInfo> dictList=queryDicAll();
		for(ZpDictionaryInfo dic : dictList){
			if(dic.getDictionaryId().intValue()==code.intValue()){
				return dic;
			}
		}
		return null;
	}
	
	public static List<ZpDictionaryInfo> getRegexpList(){
		List<ZpDictionaryInfo> newList = new ArrayList<ZpDictionaryInfo>();
		List<ZpDictionaryInfo> dictList=queryDicAll();
		String name ="";
		for(ZpDictionaryInfo dic : dictList){
			if(dic.getType()==DictionaryType.RESUME_REGEXP.getCode()){
				newList.add(dic);
			}
		}
		return newList;
	}
	
	public static Long getCode(int type,String name){
		List<ZpDictionaryInfo> dictList=queryDicAll();
		for(ZpDictionaryInfo dic : dictList){
			if(dic.getType()==type && dic.getName().equals(name)){
				return dic.getDictionaryId();
			}
		}
		return null;
	}
	
	//查询所有字典数据
	public static List<ZpDictionaryInfo> queryDicAll(){
		String jsonStr;
		List<ZpDictionaryInfo> dictList=null;
		/*try {
			jsonStr = FileUtil.readFileToString(new File("d:\\dictList.txt"));
		    dictList=JsonUtil.toList(jsonStr, ZpDictionaryInfo.class);
		//List<ZpDictionaryInfo> dictList= maps.get(Const.SESSION_DICTIONARYS_KEY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Map<String,List> maps = IndexInfoSingleTon.getInstance().getIndexInfoMap();
		dictList= maps.get(Const.SESSION_DICTIONARYS_KEY);
	
		return dictList;
	}
}

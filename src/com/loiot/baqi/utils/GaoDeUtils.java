package com.loiot.baqi.utils;

import java.util.ArrayList;
import java.util.List;
public class GaoDeUtils {
	private String key;//高德key
	private String type="json";//json 或xml
	private String url;
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	private  List<Object []> list = new ArrayList<Object []>();
	
	public  void pushf(Object [] arr){
		this.list.add(arr);
	}
	

	public List<Object[]> getList() {
		return list;
	}


	public void setList(List<Object[]> list) {
		this.list = list;
	}


	public String getDistanceParam(String destinationX,String destinationY){
		String url=null;
		if(this.list!=null && list.size()>0){
			for(Object [] obj : list){
				String coordx = String.valueOf(obj[0]);
				String coordy = String.valueOf(obj[1]);
				if((coordx!=null && coordx.length()>0) && (coordy!=null && coordy.length()>0) ){
					if(url==null)
					url=coordx+","+coordy;
					else
					url=url+"|"+coordx+","+coordy;
				}
			}
		}
		if(url!=null){
			url="origins="+url+"&destination="+destinationX+","+destinationY+"&output="+this.getType()+"&key="+this.getKey();
		}
		System.out.println(url);
		return  url;
	}
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

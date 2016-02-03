package com.loiot.baqi.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}
	
	
	public static void test1(){
		try {
			String url ="http://hd.hunteron.com/#/index?redirect=http%253A%252F%252Fhd.hunteron.com%252F%2523%252Fpositions%252Fmatch";
			
			
			HashMap<String,String> cookies = new HashMap<String,String>();
			cookies.put("gr_user_id", "97783ad5-0bac-4a19-97ff-3998dbfe7eef");
			cookies.put("channel_referer", "https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DN2fqowmOmgNe3KVkUFDi1qaCekId_6tC6iMM__xeR5LZ2cHjRkeIytvFUqI8BfI4%26wd%3D%26eqid%3Def9724640003cbd500000002569b4b81");
			cookies.put("Hm_lvt_e027492847dbffb174946a3ab7774aa0", "1453012367,1453015319,1453017609,1453017736");
			cookies.put("Hm_lpvt_e027492847dbffb174946a3ab7774aa0", "1453012367");
			cookies.put("_gat", "1");
			cookies.put("td_cookie", "511612673");
			cookies.put("event_referer", "http%3A%2F%2Fhd.hunteron.com%2F");
			cookies.put("_ga", "GA1.2.1771527012.1453007173");
			cookies.put("gr_session_id", "0ed8f667-ce68-4f48-9737-3be6534943cd");
			cookies.put("token", "0935de7662314f83b19ae36576a64bfc");
			cookies.put("X-TOKEN", "0935de7662314f83b19ae36576a64bfc");

			
			  Document doc = Jsoup.connect(url)
			  .data(
					  "loginName", "18500357912",
					  "authorizeCode","b6fc04937e426c6c69c468541abffebb",
					  "twoAuthorizeCode","c31c88b15f2bcbf17aa8cccdf530f04b",
					  "noRemind","true",
					    "password","123456"
					  )
			  .header("X-TOKEN", "37c4424110b4406eafd2cda1ea1a7614")
			  .header("v", "1.0")
			  .header("uipos", "null")
			  .header("tc", "1453018455601")
			  .header("t", "web")
			  .header("res", "1600_900")
			  .header("Referer", "http://hd.hunteron.com/")
			  .header("r", "http://hd.hunteron.com/#/positions/match")
			  .header("Pragma", "no-cache")
			  .header("pdv", "3.1.1")
			  .header("pdt", "web")
			  .header("pd", "wa")
			  .header("Host", "hd.hunteron.com")
			  .header("Accept", "application/json, text/plain")
			  			  
			  .cookies(cookies).ignoreContentType(true)
			  .get();
			
			System.out.println(doc);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test2(){
		try {
			String url ="https://www.baidu.com/";
			 Response response = Jsoup.connect(url)
			  .execute();
			 Map<String, String> cookies = response.cookies();
			 System.out.println(cookies.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}






package com.loiot.baqi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.loiot.commons.utils.IOUtil;

public class HtmlUnitUtil {
	private static Set<Cookie> AllCookies = new HashSet<Cookie>();
    private static Logger log = LoggerFactory.getLogger(HtmlUnitUtil.class);

    public static WebClient wc;
    
    
	public static String webClientPost(String url, Map<String, String > params){
		String resultContent="";
		try {
			WebClient wc = WebClientInit();
			WebRequest req = new WebRequest(new URL(url), HttpMethod.POST);
			req.setRequestParameters(translateParams(params));
			
			Iterator<Cookie> i = AllCookies.iterator();
			while(i.hasNext()){
				wc.getCookieManager().addCookie(i.next());
			}
			Page page = wc.getPage(req);
			
			
			if(page instanceof UnexpectedPage){
				 resultContent =((UnexpectedPage)page).getWebResponse().getContentAsString();
			}else{
				 resultContent =((HtmlPage)page).asXml();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			wc.closeAllWindows();
		}
		return resultContent;
		
	}

	public static String webClientGet(String url,int min,int max){
		String responseContent="";
		try {
			
			System.out.println("fetch url:"+url);
			Thread.sleep(com.loiot.commons.utils.RandomUtil.nextInt(min, max));
			WebClient wc = WebClientInit();
			
			WebRequest req = new WebRequest(new URL(url), HttpMethod.GET);
			Map<String, String> params = new HashMap<String, String>();
			params.put("Access-Control-Allow-Origin", "hd.hunteron.com");
			req.setAdditionalHeaders(params);
			Iterator<Cookie> i = AllCookies.iterator();
			while(i.hasNext()){
				Cookie cookie = i.next();
				wc.getCookieManager().addCookie(cookie);
				log.info("cookie  key:" + cookie.getName() +" value :" + cookie.getValue());
			}
			Page page = wc.getPage(req);
			
			Set<Cookie> cooks = wc.getCookieManager().getCookies();
			
			AllCookies.addAll(cooks);
			
			log.info("login cookies:"+JsonUtils.toJson(AllCookies));

			
			WebResponse webResponse = page.getWebResponse();  
		      
		    int status = webResponse.getStatusCode();  
		    
			/*for(Cookie c : cooks){
				System.out.println("0"+c.getName() +":"+c.getValue());
			}*/
			/*if(page instanceof UnexpectedPage){
				String resultContent =((UnexpectedPage)page).getWebResponse().getContentAsString();
				wc.closeAllWindows();
				return resultContent;
			}else{
				wc.closeAllWindows();
				String resultContent =((HtmlPage)page).asXml();
				return resultContent;
			}*/
		    
		    if (status==200) {  
		        if (page.isHtmlPage()) {  
		             responseContent = ((HtmlPage) page).asXml(); 
		        } else {  
		            responseContent = webResponse.getContentAsString();  
		        }  
		    }  
		    // 关闭响应流  
		    webResponse.cleanUp();  
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} 
		return responseContent;
	}
	
	public static List<com.gargoylesoftware.htmlunit.util.NameValuePair> translateParams(
			Map<String, String> params) {
		List<com.gargoylesoftware.htmlunit.util.NameValuePair> nvps = new ArrayList<com.gargoylesoftware.htmlunit.util.NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new com.gargoylesoftware.htmlunit.util.NameValuePair(key, params.get(key)));
		}
	
		return nvps;
	}
	/**
	 * webClient
	 * @return
	 *//*
	public  static WebClient WebClientInit(){
		//WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
		WebClient wc = new WebClient(BrowserVersion.getDefault());
		wc.getCookieManager().setCookiesEnabled(true);
		wc.getOptions().setJavaScriptEnabled(true);
		wc.getOptions().setActiveXNative(false);
		wc.getOptions().setCssEnabled(false);
		wc.getOptions().setThrowExceptionOnScriptError(false);
		wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
		wc.getOptions().setDoNotTrackEnabled(false);
		wc.getOptions().setTimeout(20000);
		wc.setJavaScriptTimeout(20000);
		return wc;
	}*/
	
	/**
	 * webClient
	 * @return
	 */
	public  static WebClient WebClientInit(){
		/*//WebClient wc = new WebClient(BrowserVersion.FIREFOX_24);
		WebClient wc = new WebClient(BrowserVersion.getDefault());
		wc.getCookieManager().setCookiesEnabled(true);
		wc.getOptions().setJavaScriptEnabled(true);
		wc.getOptions().setActiveXNative(false);
		wc.getOptions().setCssEnabled(false);
		wc.getOptions().setThrowExceptionOnScriptError(false);
		wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
		wc.getOptions().setDoNotTrackEnabled(false);
		wc.getOptions().setTimeout(20000);
		wc.setJavaScriptTimeout(20000);*/
		if(wc==null){
			wc = new WebClient(BrowserVersion.getDefault());
			wc.getCookieManager().setCookiesEnabled(true);
			wc.getOptions().setJavaScriptEnabled(true);
			wc.getOptions().setActiveXNative(false);
			wc.getOptions().setCssEnabled(false);
			wc.getOptions().setThrowExceptionOnScriptError(false);
			wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
			wc.getOptions().setDoNotTrackEnabled(false);
			wc.getOptions().setTimeout(20000);
			wc.setJavaScriptTimeout(20000);
		} 
		return wc;
	}
	

}

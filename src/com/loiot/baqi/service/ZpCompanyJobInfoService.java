package com.loiot.baqi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.ZpCompanyJobDemandKeysDao;
import com.loiot.baqi.dao.ZpCompanyJobInfoDao;
import com.loiot.baqi.service.ZpCompanyJobInfoService;
import com.loiot.baqi.utils.JLBUtils;
import com.loiot.baqi.pojo.ZpCompanyJobDemandKeys;
import com.loiot.baqi.pojo.ZpCompanyJobInfo;

/**
 * 公司职位 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-09-30
 */
@Service("zpCompanyJobInfoService")
@Transactional
public class ZpCompanyJobInfoService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpCompanyJobInfoDao zpCompanyJobInfoDao;
	
    @Resource
   	private ZpCompanyJobDemandKeysDao zpCompanyJobDemandKeysDao;
	 /**
     * 查询 公司职位列表分页
     * 
     * @param name 公司职位名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpCompanyJobInfo> queryZpCompanyJobInfoListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询公司职位列表总条数
        int totalResults = zpCompanyJobInfoDao.getZpCompanyJobInfoListCount(pMap);

        // 构造一个分页器
        Pager<ZpCompanyJobInfo> pager = new Pager<ZpCompanyJobInfo>(totalResults, pageIndex);

        // 查询公司职位列表
        List<ZpCompanyJobInfo> zpCompanyJobInfoList = zpCompanyJobInfoDao.queryZpCompanyJobInfoList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpCompanyJobInfoList);
        return pager;
    }
    
    /**
     * 查询 用户补充信息（假）分页
     * 
     * @param name 用户补充信息名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpCompanyJobInfo> queryFlasePageList(HashMap<String,Object> pMap, int pageIndex)throws Exception {
    	//假分页
    	Pager<ZpCompanyJobInfo> pager = this.setPkList(pMap,pageIndex);
    	List<ZpCompanyJobInfo> zpCompanyJobInfoList = zpCompanyJobInfoDao.queryZpCompanyJobInfoList(pMap);
        pager.setData(zpCompanyJobInfoList);
        return pager;
    }
    
    /**
     * 设置 假分页id集合到Map中
     * @param pMap
     * @param pageIndex
     * @return
     * @throws Exception
     */
    public Pager<ZpCompanyJobInfo> setPkList(HashMap<String,Object> pMap,int pageIndex) throws Exception{
    	  // 查询职位匹配信息列表总条数
        List<ZpCompanyJobInfo> list = zpCompanyJobInfoDao.queryZpCompanyJobInfoList(pMap);
        // 构造一个分页器
        Pager<ZpCompanyJobInfo> pager = new Pager<ZpCompanyJobInfo>(list.size(), pageIndex, 10,list);
        List<ZpCompanyJobInfo> idsList = pager.getCurrentPageData();
        List<Long> ids =this.getIds(idsList);
        pMap.put("jobIds", ids);
        return pager;
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<ZpCompanyJobInfo> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (ZpCompanyJobInfo b : list) {
            	idsList.add(b.getJobId());
            }
        }
        return idsList;
    }
	
	
	 /**
     * 添加 公司职位
     * 
     * @param p 参数对象
     */
    public void addZpCompanyJobInfo(ZpCompanyJobInfo p)throws Exception {
    	//关键字个数
    	if(!StringUtils.isBlank(p.getZpRequire())){
    		p.setKeywordStatus(p.getZpRequire().split(",").length);
    	}
    	JLBUtils.dealExpectedYearMoneyBig(p);
        zpCompanyJobInfoDao.addZpCompanyJobInfo(p);
        //添加职位关键字
        if(p.getZpRequire()!=null && p.getZpRequire().length()>0){
        	String requires[] = p.getZpRequire().split(",");
        	for(int i=0;i<requires.length;i++){
        		String keyword = requires[i];
        		ZpCompanyJobDemandKeys  b = new ZpCompanyJobDemandKeys();
        		b.setJobId(p.getJobId());
        		b.setKeyword(keyword);
        		this.zpCompanyJobDemandKeysDao.addZpCompanyJobDemandKeys(b);
        	}
        }
        
    }
    
    /**
     * 修改 公司职位
     * 
     * @param p 参数对象
     */
    public void updateZpCompanyJobInfo(ZpCompanyJobInfo p)throws Exception {
    	//关键字个数
    	if(!StringUtils.isBlank(p.getZpRequire())){
    		p.setKeywordStatus(p.getZpRequire().split(",").length);
    	}
    	JLBUtils.dealExpectedYearMoneyBig(p);
        zpCompanyJobInfoDao.updateZpCompanyJobInfo(p);
        //删除后添加
        ZpCompanyJobDemandKeys delBean = new ZpCompanyJobDemandKeys();
        delBean.setJobId(p.getJobId());
        zpCompanyJobDemandKeysDao.deleteZpCompanyJobDemandKeys(delBean);
        //添加职位关键字
        if(p.getZpRequire()!=null && p.getZpRequire().length()>0){
        	String requires[] = p.getZpRequire().split(",");
        	for(int i=0;i<requires.length;i++){
        		String keyword = requires[i];
        		ZpCompanyJobDemandKeys  b = new ZpCompanyJobDemandKeys();
        		b.setJobId(p.getJobId());
        		b.setKeyword(keyword);
        		this.zpCompanyJobDemandKeysDao.addZpCompanyJobDemandKeys(b);
        	}
        }
    }
    
    /**
     * 删除  公司职位
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobInfo(java.lang.Long id)throws Exception {
        zpCompanyJobInfoDao.deleteZpCompanyJobInfo(id);
    }
    
    /**
     * 删除  公司职位
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobInfo(ZpCompanyJobInfo p)throws Exception {
        zpCompanyJobInfoDao.deleteZpCompanyJobInfo(p);
    }
    
    /**
     * 获得  公司职位
     * 
     * @param id 公司职位Id
     * 
     * @return 返回与ID匹配的公司职位
     */
    public ZpCompanyJobInfo getZpCompanyJobInfoById(java.lang.Long id)throws Exception {
        return  zpCompanyJobInfoDao.getZpCompanyJobInfoById(id);
    }
    
    /**
     * 获得  公司职位
     * 
     * @param name 公司职位名称
     * 
     * @return 返回与NAME匹配的公司职位
     */
    public ZpCompanyJobInfo getZpCompanyJobInfoByName(String name)throws Exception {
        return  zpCompanyJobInfoDao.getZpCompanyJobInfoByName(name);
    }
    
    /**
     * 查询 公司职位列表
     * @return 公司职位列表
     */
    public List<ZpCompanyJobInfo> queryZpCompanyJobInfoList(HashMap<String,Object> pMap)throws Exception {
        return  zpCompanyJobInfoDao.queryZpCompanyJobInfoList(pMap);
    }
    
    /**
     * 查询 公司职位列表
     * @return 公司职位列表
     */
    public List<ZpCompanyJobInfo> queryZpCompanyJobInfoList(ZpCompanyJobInfo p)throws Exception {
        return  zpCompanyJobInfoDao.queryZpCompanyJobInfoList(p);
    }
    
    /**
     * 查询  公司职位列表条数
     * 
     * @param name 公司职位名称
     * @return 公司职位列表条数
     */
    
    public int getZpCompanyJobInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpCompanyJobInfoDao.getZpCompanyJobInfoListCount(pMap);
    }
	
}

package com.loiot.baqi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.ZpJlExpandInfoDao;
import com.loiot.baqi.service.ZpJlExpandInfoService;
import com.loiot.baqi.vo.JlAuditPersonList;
import com.loiot.baqi.pojo.ZpJlExpandInfo;
import com.loiot.baqi.pojo.ZpJlJobLevels;
import com.timeloit.pojo.Account;


/**
 * 简历扩展信息 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-10-23
 */
@Service("zpJlExpandInfoService")
@Transactional
public class ZpJlExpandInfoService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpJlExpandInfoDao zpJlExpandInfoDao;
	
	
	 /**
     * 查询 简历扩展信息列表分页
     * 
     * @param name 简历扩展信息名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpJlExpandInfo> queryZpJlExpandInfoListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询简历扩展信息列表总条数
        int totalResults = zpJlExpandInfoDao.getZpJlExpandInfoListCount(pMap);

        // 构造一个分页器
        Pager<ZpJlExpandInfo> pager = new Pager<ZpJlExpandInfo>(totalResults, pageIndex);

        // 查询简历扩展信息列表
        List<ZpJlExpandInfo> zpJlExpandInfoList = zpJlExpandInfoDao.queryZpJlExpandInfoList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpJlExpandInfoList);
        return pager;
    }
	
	 /**
     * 添加 简历扩展信息
     * 
     * @param p 参数对象
     */
    public ZpJlExpandInfo addZpJlExpandInfo(ZpJlExpandInfo p)throws Exception {
       return  zpJlExpandInfoDao.addZpJlExpandInfo(p);
    }
    
    /**
     * 修改 简历扩展信息
     * 
     * @param p 参数对象
     */
    public void updateZpJlExpandInfo(ZpJlExpandInfo p)throws Exception {
        zpJlExpandInfoDao.updateZpJlExpandInfo(p);
    }
    
    /**
     * 审核人信息统计
     * 
     * @param pMap 参数列表
     */
    public List<JlAuditPersonList> auditPersonStatistics(List<Account> accoutList)throws Exception {
    	if(accoutList==null || accoutList.size()==0){
    		return null;
    	}
    	HashMap<String,Object> pmap = new HashMap<String,Object>();
    	List<Long> ids = this.getIds(accoutList);
    	pmap.put("ids", ids);
    	return this.zpJlExpandInfoDao.auditPersonStatistics(pmap);
    }
    
    /**
     * 修改 简历扩展信息
     * 
     * @param p 参数对象
     */
    public void updateZpJlExpandInfo(HashMap<String,Object> pMap)throws Exception {
    	this.zpJlExpandInfoDao.updateZpJlExpandInfo(pMap);
    }
    
    /**
     * 删除  简历扩展信息
     * 
     * @param id 主键
     */
    public void deleteZpJlExpandInfo(java.lang.Long id)throws Exception {
        zpJlExpandInfoDao.deleteZpJlExpandInfo(id);
    }
    
    /**
     * 删除  简历扩展信息
     * 
     * @param id 主键
     */
    public void deleteZpJlExpandInfo(ZpJlExpandInfo p)throws Exception {
        zpJlExpandInfoDao.deleteZpJlExpandInfo(p);
    }
    
    /**
     * 获得  简历扩展信息
     * 
     * @param id 简历扩展信息Id
     * 
     * @return 返回与ID匹配的简历扩展信息
     */
    public ZpJlExpandInfo getZpJlExpandInfoById(java.lang.Long id)throws Exception {
        return  zpJlExpandInfoDao.getZpJlExpandInfoById(id);
    }
    
    /**
     * 获得  简历扩展信息
     * 
     * @param id 简历扩展信息Id
     * 
     * @return 返回与ID匹配的简历扩展信息
     */
    public ZpJlExpandInfo getZpJlExpandInfoById(java.lang.Long id,Long accountId)throws Exception {
        return  zpJlExpandInfoDao.getZpJlExpandInfoById(id,accountId);
    }
    
    
    /**
     * 获得  简历扩展信息
     * 
     * @param id 简历扩展信息Id
     * 
     */
    public ZpJlExpandInfo getZpJlExpandInfo(HashMap<String,Object> pMap)throws Exception {
    	return (ZpJlExpandInfo) zpJlExpandInfoDao.getZpJlExpandInfo(pMap);
    }
    /**
     * 获得  简历扩展信息
     * 
     * @param name 简历扩展信息名称
     * 
     * @return 返回与NAME匹配的简历扩展信息
     */
    public ZpJlExpandInfo getZpJlExpandInfoByName(String name)throws Exception {
        return  zpJlExpandInfoDao.getZpJlExpandInfoByName(name);
    }
    
    /**
     * 查询 简历扩展信息列表
     * @return 简历扩展信息列表
     */
    public List<ZpJlExpandInfo> queryZpJlExpandInfoList(HashMap<String,Object> pMap)throws Exception {
        return  zpJlExpandInfoDao.queryZpJlExpandInfoList(pMap);
    }
    
    /**
     * 查询 简历扩展信息列表
     * @return 简历扩展信息列表
     */
    public List<ZpJlExpandInfo> queryZpJlExpandInfoList(ZpJlExpandInfo p)throws Exception {
        return  zpJlExpandInfoDao.queryZpJlExpandInfoList(p);
    }
    
    /**
     * 查询  简历扩展信息列表条数
     * 
     * @param name 简历扩展信息名称
     * @return 简历扩展信息列表条数
     */
    
    public int getZpJlExpandInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpJlExpandInfoDao.getZpJlExpandInfoListCount(pMap);
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<Account> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (Account b : list) {
            	idsList.add(b.getAccountId());
            }
        }
        return idsList;
    }
}

package com.loiot.baqi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.ZpHrInfoDao;
import com.loiot.baqi.service.ZpHrInfoService;
import com.loiot.baqi.pojo.ZpHrInfo;

/**
 * hr(人力资源hr) 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-09-03
 */
@Service("zpHrInfoService")
@Transactional
public class ZpHrInfoService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpHrInfoDao zpHrInfoDao;
	
	
	 /**
     * 查询 hr(人力资源hr)列表分页
     * 
     * @param name hr(人力资源hr)名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpHrInfo> queryZpHrInfoListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {
        // 查询hr(人力资源hr)列表总条数
        int totalResults = zpHrInfoDao.getZpHrInfoListCount(pMap);

        // 构造一个分页器
        Pager<ZpHrInfo> pager = new Pager<ZpHrInfo>(totalResults, pageIndex);

        // 查询hr(人力资源hr)列表
        List<ZpHrInfo> zpHrInfoList = zpHrInfoDao.queryZpHrInfoList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpHrInfoList);
        return pager;
    }
	
	 /**
     * 添加 hr(人力资源hr)
     * 
     * @param p 参数对象
     */
    public void addZpHrInfo(ZpHrInfo p)throws Exception {
        zpHrInfoDao.addZpHrInfo(p);
    }
    
    /**
     * 修改 hr(人力资源hr)
     * 
     * @param p 参数对象
     */
    public void updateZpHrInfo(ZpHrInfo p)throws Exception {
        zpHrInfoDao.updateZpHrInfo(p);
    }
    
    /**
     * 删除  hr(人力资源hr)
     * 
     * @param id 主键
     */
    public void deleteZpHrInfo(java.lang.Long id)throws Exception {
        zpHrInfoDao.deleteZpHrInfo(id);
    }
    
    /**
     * 删除  hr(人力资源hr)
     * 
     * @param id 主键
     */
    public void deleteZpHrInfo(ZpHrInfo p)throws Exception {
        zpHrInfoDao.deleteZpHrInfo(p);
    }
    
    /**
     * 获得  hr(人力资源hr)
     * 
     * @param id hr(人力资源hr)Id
     * 
     * @return 返回与ID匹配的hr(人力资源hr)
     */
    public ZpHrInfo getZpHrInfoById(java.lang.Long id)throws Exception {
        return  zpHrInfoDao.getZpHrInfoById(id);
    }
    
    /**
     * 获得  hr(人力资源hr)
     * 
     * @param name hr(人力资源hr)名称
     * 
     * @return 返回与NAME匹配的hr(人力资源hr)
     */
    public ZpHrInfo getZpHrInfoByName(String name)throws Exception {
        return  zpHrInfoDao.getZpHrInfoByName(name);
    }
    
    /**
     * 查询 hr(人力资源hr)列表
     * @return hr(人力资源hr)列表
     */
    public List<ZpHrInfo> queryZpHrInfoList()throws Exception {
        return  zpHrInfoDao.queryZpHrInfoList();
    }
    
    /**
     * 查询 hr(人力资源hr)列表
     * @return hr(人力资源hr)列表
     */
    public List<ZpHrInfo> queryZpHrInfoList(ZpHrInfo p)throws Exception {
        return  zpHrInfoDao.queryZpHrInfoList(p);
    }
    
    /**
     * 查询  hr(人力资源hr)列表条数
     * 
     * @param name hr(人力资源hr)名称
     * @return hr(人力资源hr)列表条数
     */
    
    public int getZpHrInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return zpHrInfoDao.getZpHrInfoListCount(pMap);
    }
	
}

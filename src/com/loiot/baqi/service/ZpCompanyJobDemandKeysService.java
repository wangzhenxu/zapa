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
import com.loiot.baqi.dao.ZpCompanyJobDemandKeysDao;
import com.loiot.baqi.service.ZpCompanyJobDemandKeysService;
import com.loiot.baqi.pojo.ZpCompanyJobDemandKeys;
import com.loiot.baqi.pojo.ZpJlJobLevels;


/**
 * 公司职位要求关键字 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-10-06
 */
@Service("zpCompanyJobDemandKeysService")
@Transactional
public class ZpCompanyJobDemandKeysService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpCompanyJobDemandKeysDao zpCompanyJobDemandKeysDao;
	
	
	 /**
     * 查询 公司职位要求关键字列表分页
     * 
     * @param name 公司职位要求关键字名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询公司职位要求关键字列表总条数
        int totalResults = zpCompanyJobDemandKeysDao.getZpCompanyJobDemandKeysListCount(pMap);

        // 构造一个分页器
        Pager<ZpCompanyJobDemandKeys> pager = new Pager<ZpCompanyJobDemandKeys>(totalResults, pageIndex);

        // 查询公司职位要求关键字列表
        List<ZpCompanyJobDemandKeys> zpCompanyJobDemandKeysList = zpCompanyJobDemandKeysDao.queryZpCompanyJobDemandKeysList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpCompanyJobDemandKeysList);
        return pager;
    }
	
	 /**
     * 添加 公司职位要求关键字
     * 
     * @param p 参数对象
     */
    public ZpCompanyJobDemandKeys addZpCompanyJobDemandKeys(ZpCompanyJobDemandKeys p)throws Exception {
       return  zpCompanyJobDemandKeysDao.addZpCompanyJobDemandKeys(p);
    }
    
    /**
     * 修改 公司职位要求关键字
     * 
     * @param p 参数对象
     */
    public void updateZpCompanyJobDemandKeys(ZpCompanyJobDemandKeys p)throws Exception {
        zpCompanyJobDemandKeysDao.updateZpCompanyJobDemandKeys(p);
    }
    
    /**
     * 删除  公司职位要求关键字
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobDemandKeys(java.lang.Long id)throws Exception {
        zpCompanyJobDemandKeysDao.deleteZpCompanyJobDemandKeys(id);
    }
    
    /**
     * 删除  公司职位要求关键字
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobDemandKeys(ZpCompanyJobDemandKeys p)throws Exception {
        zpCompanyJobDemandKeysDao.deleteZpCompanyJobDemandKeys(p);
    }
    
    /**
     * 获得  公司职位要求关键字
     * 
     * @param id 公司职位要求关键字Id
     * 
     * @return 返回与ID匹配的公司职位要求关键字
     */
    public ZpCompanyJobDemandKeys getZpCompanyJobDemandKeysById(java.lang.Long id)throws Exception {
        return  zpCompanyJobDemandKeysDao.getZpCompanyJobDemandKeysById(id);
    }
    
    /**
     * 获得  公司职位要求关键字
     * 
     * @param name 公司职位要求关键字名称
     * 
     * @return 返回与NAME匹配的公司职位要求关键字
     */
    public ZpCompanyJobDemandKeys getZpCompanyJobDemandKeysByName(String name)throws Exception {
        return  zpCompanyJobDemandKeysDao.getZpCompanyJobDemandKeysByName(name);
    }
    
    /**
     * 查询 公司职位要求关键字列表
     * @return 公司职位要求关键字列表
     */
    public List<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysList(HashMap<String,Object> pMap)throws Exception {
        return  zpCompanyJobDemandKeysDao.queryZpCompanyJobDemandKeysList(pMap);
    }
    
    /**
     * 查询 公司职位要求关键字列表
     * @return 公司职位要求关键字列表
     */
    public List<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysList(ZpCompanyJobDemandKeys p)throws Exception {
        return  zpCompanyJobDemandKeysDao.queryZpCompanyJobDemandKeysList(p);
    }
    
    /**
     * 查询  公司职位要求关键字列表条数
     * 
     * @param name 公司职位要求关键字名称
     * @return 公司职位要求关键字列表条数
     */
    
    public int getZpCompanyJobDemandKeysListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpCompanyJobDemandKeysDao.getZpCompanyJobDemandKeysListCount(pMap);
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<ZpCompanyJobDemandKeys> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (ZpCompanyJobDemandKeys b : list) {
            	idsList.add(null);
            }
        }
        return idsList;
    }
}

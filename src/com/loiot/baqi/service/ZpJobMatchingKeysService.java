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
import com.loiot.baqi.dao.ZpJobMatchingKeysDao;
import com.loiot.baqi.service.ZpJobMatchingKeysService;
import com.loiot.baqi.pojo.ZpJobMatchingKeys;
import com.loiot.baqi.pojo.ZpJlJobLevels;


/**
 * 职位匹配关键字 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-10-06
 */
@Service("zpJobMatchingKeysService")
@Transactional
public class ZpJobMatchingKeysService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpJobMatchingKeysDao zpJobMatchingKeysDao;
	
	
	 /**
     * 查询 职位匹配关键字列表分页
     * 
     * @param name 职位匹配关键字名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpJobMatchingKeys> queryZpJobMatchingKeysListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询职位匹配关键字列表总条数
        int totalResults = zpJobMatchingKeysDao.getZpJobMatchingKeysListCount(pMap);

        // 构造一个分页器
        Pager<ZpJobMatchingKeys> pager = new Pager<ZpJobMatchingKeys>(totalResults, pageIndex);

        // 查询职位匹配关键字列表
        List<ZpJobMatchingKeys> zpJobMatchingKeysList = zpJobMatchingKeysDao.queryZpJobMatchingKeysList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpJobMatchingKeysList);
        return pager;
    }
	
	 /**
     * 添加 职位匹配关键字
     * 
     * @param p 参数对象
     */
    public ZpJobMatchingKeys addZpJobMatchingKeys(ZpJobMatchingKeys p)throws Exception {
       return  zpJobMatchingKeysDao.addZpJobMatchingKeys(p);
    }
    
    /**
     * 修改 职位匹配关键字
     * 
     * @param p 参数对象
     */
    public void updateZpJobMatchingKeys(ZpJobMatchingKeys p)throws Exception {
        zpJobMatchingKeysDao.updateZpJobMatchingKeys(p);
    }
    
    /**
     * 删除  职位匹配关键字
     * 
     * @param id 主键
     */
    public void deleteZpJobMatchingKeys(java.lang.Long id)throws Exception {
        zpJobMatchingKeysDao.deleteZpJobMatchingKeys(id);
    }
    
    /**
     * 删除  职位匹配关键字
     * 
     * @param id 主键
     */
    public void deleteZpJobMatchingKeys(ZpJobMatchingKeys p)throws Exception {
        zpJobMatchingKeysDao.deleteZpJobMatchingKeys(p);
    }
    
    /**
     * 获得  职位匹配关键字
     * 
     * @param id 职位匹配关键字Id
     * 
     * @return 返回与ID匹配的职位匹配关键字
     */
    public ZpJobMatchingKeys getZpJobMatchingKeysById(java.lang.Long id)throws Exception {
        return  zpJobMatchingKeysDao.getZpJobMatchingKeysById(id);
    }
    
    /**
     * 获得  职位匹配关键字
     * 
     * @param name 职位匹配关键字名称
     * 
     * @return 返回与NAME匹配的职位匹配关键字
     */
    public ZpJobMatchingKeys getZpJobMatchingKeysByName(String name)throws Exception {
        return  zpJobMatchingKeysDao.getZpJobMatchingKeysByName(name);
    }
    
    /**
     * 查询 职位匹配关键字列表
     * @return 职位匹配关键字列表
     */
    public List<ZpJobMatchingKeys> queryZpJobMatchingKeysList(HashMap<String,Object> pMap)throws Exception {
        return  zpJobMatchingKeysDao.queryZpJobMatchingKeysList(pMap);
    }
    
    /**
     * 查询 职位匹配关键字列表
     * @return 职位匹配关键字列表
     */
    public List<ZpJobMatchingKeys> queryZpJobMatchingKeysList(ZpJobMatchingKeys p)throws Exception {
        return  zpJobMatchingKeysDao.queryZpJobMatchingKeysList(p);
    }
    
    /**
     * 查询  职位匹配关键字列表条数
     * 
     * @param name 职位匹配关键字名称
     * @return 职位匹配关键字列表条数
     */
    
    public int getZpJobMatchingKeysListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpJobMatchingKeysDao.getZpJobMatchingKeysListCount(pMap);
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<ZpJobMatchingKeys> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (ZpJobMatchingKeys b : list) {
            	idsList.add(null);
            }
        }
        return idsList;
    }
}

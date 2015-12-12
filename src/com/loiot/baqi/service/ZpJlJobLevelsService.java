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
import com.loiot.baqi.dao.ZpJlJobLevelsDao;
import com.loiot.baqi.service.ZpJlJobLevelsService;
import com.loiot.baqi.pojo.ZpJlJobLevels;

/**
 * 简历职位级别列表 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-10-05
 */
@Service("zpJlJobLevelsService")
@Transactional
public class ZpJlJobLevelsService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpJlJobLevelsDao zpJlJobLevelsDao;
	
	
	 /**
     * 查询 简历职位级别列表列表分页
     * 
     * @param name 简历职位级别列表名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpJlJobLevels> queryZpJlJobLevelsListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询简历职位级别列表列表总条数
        int totalResults = zpJlJobLevelsDao.getZpJlJobLevelsListCount(pMap);

        // 构造一个分页器
        Pager<ZpJlJobLevels> pager = new Pager<ZpJlJobLevels>(totalResults, pageIndex);

        // 查询简历职位级别列表列表
        List<ZpJlJobLevels> zpJlJobLevelsList = zpJlJobLevelsDao.queryZpJlJobLevelsList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpJlJobLevelsList);
        return pager;
    }
	
	 /**
     * 添加 简历职位级别列表
     * 
     * @param p 参数对象
     */
    public ZpJlJobLevels addZpJlJobLevels(ZpJlJobLevels p)throws Exception {
       return  zpJlJobLevelsDao.addZpJlJobLevels(p);
    }
    
    /**
     * 修改 简历职位级别列表
     * 
     * @param p 参数对象
     */
    public void updateZpJlJobLevels(ZpJlJobLevels p)throws Exception {
        zpJlJobLevelsDao.updateZpJlJobLevels(p);
    }
    
    /**
     * 删除  简历职位级别列表
     * 
     * @param id 主键
     */
    public void deleteZpJlJobLevels(java.lang.Long id)throws Exception {
        zpJlJobLevelsDao.deleteZpJlJobLevels(id);
    }
    
    /**
     * 删除  简历职位级别列表
     * 
     * @param id 主键
     */
    public void deleteZpJlJobLevels(ZpJlJobLevels p)throws Exception {
        zpJlJobLevelsDao.deleteZpJlJobLevels(p);
    }
    
    /**
     * 获得  简历职位级别列表
     * 
     * @param id 简历职位级别列表Id
     * 
     * @return 返回与ID匹配的简历职位级别列表
     */
    public ZpJlJobLevels getZpJlJobLevelsById(java.lang.Long id)throws Exception {
        return  zpJlJobLevelsDao.getZpJlJobLevelsById(id);
    }
    
    /**
     * 获得  简历职位级别列表
     * 
     * @param name 简历职位级别列表名称
     * 
     * @return 返回与NAME匹配的简历职位级别列表
     */
    public ZpJlJobLevels getZpJlJobLevelsByName(String name)throws Exception {
        return  zpJlJobLevelsDao.getZpJlJobLevelsByName(name);
    }
    
    /**
     * 查询 简历职位级别列表列表
     * @return 简历职位级别列表列表
     */
    public List<ZpJlJobLevels> queryZpJlJobLevelsList(HashMap<String,Object> pMap)throws Exception {
        return  zpJlJobLevelsDao.queryZpJlJobLevelsList(pMap);
    }
    
    /**
     * 查询 简历职位级别列表列表
     * @return 简历职位级别列表列表
     */
    public List<ZpJlJobLevels> queryZpJlJobLevelsList(ZpJlJobLevels p)throws Exception {
        return  zpJlJobLevelsDao.queryZpJlJobLevelsList(p);
    }
    
    /**
     * 查询  简历职位级别列表列表条数
     * 
     * @param name 简历职位级别列表名称
     * @return 简历职位级别列表列表条数
     */
    
    public int getZpJlJobLevelsListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpJlJobLevelsDao.getZpJlJobLevelsListCount(pMap);
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<ZpJlJobLevels> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (ZpJlJobLevels b : list) {
                //slIds.add(sl.getSceneId());
            	idsList.add(null);
            }
        }
        
        return idsList;
    }
    
    
	
}

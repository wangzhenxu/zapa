package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpJlJobLevels;

/**
 * 简历职位级别列表 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-10-05
 */
@Repository("zpJlJobLevelsDao")
public class ZpJlJobLevelsDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 简历职位级别列表
     * 
     * @param p 参数对象
     */
    public ZpJlJobLevels addZpJlJobLevels(ZpJlJobLevels p)throws Exception {
        this.getSqlSession().insert("ZpJlJobLevels.addZpJlJobLevels", p);
        return p;
    }
    
    /**
     * 修改 简历职位级别列表
     * 
     * @param p 参数对象
     */
    public void updateZpJlJobLevels(ZpJlJobLevels p)throws Exception {
        this.getSqlSession().update("ZpJlJobLevels.updateZpJlJobLevels", p);
    }
    
    /**
     * 删除  简历职位级别列表
     * 
     * @param id 主键
     */
    public void deleteZpJlJobLevels(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpJlJobLevels.deleteZpJlJobLevels", id);
    }
    
    /**
     * 删除  简历职位级别列表
     * 
     * @param id 主键
     */
    public void deleteZpJlJobLevels(ZpJlJobLevels p)throws Exception {
        getSqlSession().delete("ZpJlJobLevels.deleteZpJlJobLevels", p);
    }
    
    /**
     * 获得  简历职位级别列表
     * 
     * @param id 简历职位级别列表Id
     * 
     * @return 返回与ID匹配的简历职位级别列表
     */
    public ZpJlJobLevels getZpJlJobLevelsById(java.lang.Long id)throws Exception {
        return (ZpJlJobLevels) getSqlSession().selectOne("ZpJlJobLevels.getZpJlJobLevelsById", id);
    }
    
    /**
     * 获得  简历职位级别列表
     * 
     * @param name 简历职位级别列表名称
     * 
     * @return 返回与NAME匹配的简历职位级别列表
     */
    public ZpJlJobLevels getZpJlJobLevelsByName(String name)throws Exception {
        return null;
        //return (ZpJlJobLevels) getSqlSession().selectOne("ZpJlJobLevels.getZpJlJobLevelsByName", name);
    }
    
    
    
    /**
     * 查询  简历职位级别列表列表条数
     * 
     * @param name 简历职位级别列表名称
     * @return 简历职位级别列表列表条数
     */
    
    public int getZpJlJobLevelsListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpJlJobLevels.getZpJlJobLevelsListCount", pMap);
    }

    /**
     * 查询 简历职位级别列表列表
     * 
     * @param name 简历职位级别列表名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 简历职位级别列表列表
     */
    public List<ZpJlJobLevels> queryZpJlJobLevelsList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpJlJobLevels.queryZpJlJobLevelsList", pMap);
    }
    
    /**
     * 查询 简历职位级别列表列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpJlJobLevels> queryZpJlJobLevelsList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpJlJobLevels.queryZpJlJobLevelsList", pMap);
    }
    
    /**
     * 查询 简历职位级别列表列表
     * 
     * @return 简历职位级别列表列表
     */
    public List<ZpJlJobLevels> queryZpJlJobLevelsList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpJlJobLevels.queryZpJlJobLevelsList",params);
    }
    
    /**
     * 查询 简历职位级别列表列表
     * 
     * @return 简历职位级别列表列表
     */
    public List<ZpJlJobLevels> queryZpJlJobLevelsList(ZpJlJobLevels p )throws Exception {
        return getSqlSession().selectList("ZpJlJobLevels.queryZpJlJobLevelsList",p);
    }
    
    

}

package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpJobMatchingKeys;

/**
 * 职位匹配关键字 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-10-06
 */
@Repository("zpJobMatchingKeysDao")
public class ZpJobMatchingKeysDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 职位匹配关键字
     * 
     * @param p 参数对象
     */
    public ZpJobMatchingKeys addZpJobMatchingKeys(ZpJobMatchingKeys p)throws Exception {
        this.getSqlSession().insert("ZpJobMatchingKeys.addZpJobMatchingKeys", p);
        return p;
    }
    
    /**
     * 修改 职位匹配关键字
     * 
     * @param p 参数对象
     */
    public void updateZpJobMatchingKeys(ZpJobMatchingKeys p)throws Exception {
        this.getSqlSession().update("ZpJobMatchingKeys.updateZpJobMatchingKeys", p);
    }
    
    /**
     * 删除  职位匹配关键字
     * 
     * @param id 主键
     */
    public void deleteZpJobMatchingKeys(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpJobMatchingKeys.deleteZpJobMatchingKeys", id);
    }
    
    /**
     * 删除  职位匹配关键字
     * 
     * @param id 主键
     */
    public void deleteZpJobMatchingKeys(ZpJobMatchingKeys p)throws Exception {
        getSqlSession().delete("ZpJobMatchingKeys.deleteZpJobMatchingKeys", p);
    }
    
    /**
     * 获得  职位匹配关键字
     * 
     * @param id 职位匹配关键字Id
     * 
     * @return 返回与ID匹配的职位匹配关键字
     */
    public ZpJobMatchingKeys getZpJobMatchingKeysById(java.lang.Long id)throws Exception {
        return (ZpJobMatchingKeys) getSqlSession().selectOne("ZpJobMatchingKeys.getZpJobMatchingKeysById", id);
    }
    
    /**
     * 获得  职位匹配关键字
     * 
     * @param name 职位匹配关键字名称
     * 
     * @return 返回与NAME匹配的职位匹配关键字
     */
    public ZpJobMatchingKeys getZpJobMatchingKeysByName(String name)throws Exception {
        return null;
        //return (ZpJobMatchingKeys) getSqlSession().selectOne("ZpJobMatchingKeys.getZpJobMatchingKeysByName", name);
    }
    
    
    
    /**
     * 查询  职位匹配关键字列表条数
     * 
     * @param name 职位匹配关键字名称
     * @return 职位匹配关键字列表条数
     */
    
    public int getZpJobMatchingKeysListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpJobMatchingKeys.getZpJobMatchingKeysListCount", pMap);
    }

    /**
     * 查询 职位匹配关键字列表
     * 
     * @param name 职位匹配关键字名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 职位匹配关键字列表
     */
    public List<ZpJobMatchingKeys> queryZpJobMatchingKeysList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpJobMatchingKeys.queryZpJobMatchingKeysList", pMap);
    }
    
    /**
     * 查询 职位匹配关键字列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpJobMatchingKeys> queryZpJobMatchingKeysList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpJobMatchingKeys.queryZpJobMatchingKeysList", pMap);
    }
    
    /**
     * 查询 职位匹配关键字列表
     * 
     * @return 职位匹配关键字列表
     */
    public List<ZpJobMatchingKeys> queryZpJobMatchingKeysList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpJobMatchingKeys.queryZpJobMatchingKeysList",params);
    }
    
    /**
     * 查询 职位匹配关键字列表
     * 
     * @return 职位匹配关键字列表
     */
    public List<ZpJobMatchingKeys> queryZpJobMatchingKeysList(ZpJobMatchingKeys p )throws Exception {
        return getSqlSession().selectList("ZpJobMatchingKeys.queryZpJobMatchingKeysList",p);
    }
    
    

}

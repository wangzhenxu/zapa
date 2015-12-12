package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpCompanyJobDemandKeys;

/**
 * 公司职位要求关键字 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-10-06
 */
@Repository("zpCompanyJobDemandKeysDao")
public class ZpCompanyJobDemandKeysDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 公司职位要求关键字
     * 
     * @param p 参数对象
     */
    public ZpCompanyJobDemandKeys addZpCompanyJobDemandKeys(ZpCompanyJobDemandKeys p)throws Exception {
        this.getSqlSession().insert("ZpCompanyJobDemandKeys.addZpCompanyJobDemandKeys", p);
        return p;
    }
    
    /**
     * 修改 公司职位要求关键字
     * 
     * @param p 参数对象
     */
    public void updateZpCompanyJobDemandKeys(ZpCompanyJobDemandKeys p)throws Exception {
        this.getSqlSession().update("ZpCompanyJobDemandKeys.updateZpCompanyJobDemandKeys", p);
    }
    
    /**
     * 删除  公司职位要求关键字
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobDemandKeys(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpCompanyJobDemandKeys.deleteZpCompanyJobDemandKeys", id);
    }
    
    /**
     * 删除  公司职位要求关键字
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobDemandKeys(ZpCompanyJobDemandKeys p)throws Exception {
        getSqlSession().delete("ZpCompanyJobDemandKeys.deleteZpCompanyJobDemandKeys", p);
    }
    
    /**
     * 获得  公司职位要求关键字
     * 
     * @param id 公司职位要求关键字Id
     * 
     * @return 返回与ID匹配的公司职位要求关键字
     */
    public ZpCompanyJobDemandKeys getZpCompanyJobDemandKeysById(java.lang.Long id)throws Exception {
        return (ZpCompanyJobDemandKeys) getSqlSession().selectOne("ZpCompanyJobDemandKeys.getZpCompanyJobDemandKeysById", id);
    }
    
    /**
     * 获得  公司职位要求关键字
     * 
     * @param name 公司职位要求关键字名称
     * 
     * @return 返回与NAME匹配的公司职位要求关键字
     */
    public ZpCompanyJobDemandKeys getZpCompanyJobDemandKeysByName(String name)throws Exception {
        return null;
        //return (ZpCompanyJobDemandKeys) getSqlSession().selectOne("ZpCompanyJobDemandKeys.getZpCompanyJobDemandKeysByName", name);
    }
    
    
    
    /**
     * 查询  公司职位要求关键字列表条数
     * 
     * @param name 公司职位要求关键字名称
     * @return 公司职位要求关键字列表条数
     */
    
    public int getZpCompanyJobDemandKeysListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpCompanyJobDemandKeys.getZpCompanyJobDemandKeysListCount", pMap);
    }

    /**
     * 查询 公司职位要求关键字列表
     * 
     * @param name 公司职位要求关键字名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 公司职位要求关键字列表
     */
    public List<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpCompanyJobDemandKeys.queryZpCompanyJobDemandKeysList", pMap);
    }
    
    /**
     * 查询 公司职位要求关键字列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpCompanyJobDemandKeys.queryZpCompanyJobDemandKeysList", pMap);
    }
    
    /**
     * 查询 公司职位要求关键字列表
     * 
     * @return 公司职位要求关键字列表
     */
    public List<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpCompanyJobDemandKeys.queryZpCompanyJobDemandKeysList",params);
    }
    
    /**
     * 查询 公司职位要求关键字列表
     * 
     * @return 公司职位要求关键字列表
     */
    public List<ZpCompanyJobDemandKeys> queryZpCompanyJobDemandKeysList(ZpCompanyJobDemandKeys p )throws Exception {
        return getSqlSession().selectList("ZpCompanyJobDemandKeys.queryZpCompanyJobDemandKeysList",p);
    }
    
    

}

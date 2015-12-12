package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpJlInfo;

/**
 * 简历信息 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-09-19
 */
@Repository("zpJlInfoDao")
public class ZpJlInfoDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 简历信息
     * 
     * @param p 参数对象
     */
    public ZpJlInfo addZpJlInfo(ZpJlInfo p)throws Exception {
    	 this.getSqlSession().insert("ZpJlInfo.addZpJlInfo", p);
    	 return p;
    }
    
    /**
     * 修改 简历信息
     * 
     * @param p 参数对象
     */
    public void updateZpJlInfo(ZpJlInfo p)throws Exception {
        this.getSqlSession().update("ZpJlInfo.updateZpJlInfo", p);
    }
    
    /**
     * 删除  简历信息
     * 
     * @param id 主键
     */
    public void deleteZpJlInfo(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpJlInfo.deleteZpJlInfo", id);
    }
    
    /**
     * 删除  简历信息
     * 
     * @param id 主键
     */
    public void deleteZpJlInfo(ZpJlInfo p)throws Exception {
        getSqlSession().delete("ZpJlInfo.deleteZpJlInfo", p);
    }
    
    /**
     * 获得  简历信息
     * 
     * @param id 简历信息Id
     * 
     * @return 返回与ID匹配的简历信息
     */
    public ZpJlInfo getZpJlInfoById(java.lang.Long id)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("jlId", id);
        return (ZpJlInfo) getSqlSession().selectOne("ZpJlInfo.getZpJlInfoById", pMap);
    }
    
    /**
     * 获得  简历信息
     * 
     * @param id 简历信息Id
     * 
     * @return 返回与ID匹配的简历信息
     */
    public ZpJlInfo getZpJlInfoById(java.lang.Long id,Long accountId)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("jlId", id);
    	pMap.put("inPerson", accountId);
    	return (ZpJlInfo) getSqlSession().selectOne("ZpJlInfo.getZpJlInfoById", pMap);
    }
    
    /**
     * 获得  简历信息
     * 
     * @param name 简历信息名称
     * 
     * @return 返回与NAME匹配的简历信息
     */
    public ZpJlInfo getZpJlInfoByName(String name)throws Exception {
        return null;
        //return (ZpJlInfo) getSqlSession().selectOne("ZpJlInfo.getZpJlInfoByName", name);
    }
    
    
    
    /**
     * 查询  简历信息列表条数
     * 
     * @param name 简历信息名称
     * @return 简历信息列表条数
     */
    
    public int getZpJlInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpJlInfo.getZpJlInfoListCount", pMap);
    }

    /**
     * 查询 简历信息列表
     * 
     * @param name 简历信息名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 简历信息列表
     */
    public List<ZpJlInfo> queryZpJlInfoList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpJlInfo.queryZpJlInfoList", pMap);
    }
    
    /**
     * 查询 简历信息列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpJlInfo> queryZpJlInfoList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpJlInfo.queryZpJlInfoList", pMap);
    }
    
    /**
     * 查询 简历信息列表
     * 
     * @return 简历信息列表
     */
    public List<ZpJlInfo> queryZpJlInfoList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpJlInfo.queryZpJlInfoList",params);
    }
    
    /**
     * 查询 简历信息列表
     * 
     * @return 简历信息列表
     */
    public List<ZpJlInfo> queryZpJlInfoList(ZpJlInfo p )throws Exception {
        return getSqlSession().selectList("ZpJlInfo.queryZpJlInfoList",p);
    }
    
    

}

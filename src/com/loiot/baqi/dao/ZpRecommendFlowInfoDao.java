package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpRecommendFlowInfo;

/**
 * 推荐流程 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-11-20
 */
@Repository("zpRecommendFlowInfoDao")
public class ZpRecommendFlowInfoDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 推荐流程
     * 
     * @param p 参数对象
     */
    public ZpRecommendFlowInfo addZpRecommendFlowInfo(ZpRecommendFlowInfo p)throws Exception {
        this.getSqlSession().insert("ZpRecommendFlowInfo.addZpRecommendFlowInfo", p);
        return p;
    }
    
    /**
     * 修改 推荐流程
     * 
     * @param p 参数对象
     */
    public void updateZpRecommendFlowInfo(ZpRecommendFlowInfo p)throws Exception {
        this.getSqlSession().update("ZpRecommendFlowInfo.updateZpRecommendFlowInfo", p);
    }
    
    /**
     * 修改 推荐流程
     * 
     * @param p 参数对象
     */
    public void updateZpRecommendFlowInfo(HashMap<String,Object> pMap)throws Exception {
        this.getSqlSession().update("ZpRecommendFlowInfo.updateZpRecommendFlowInfoByMap", pMap);
    }
    
    
    
    /**
     * 删除  推荐流程
     * 
     * @param id 主键
     */
    public void deleteZpRecommendFlowInfo(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpRecommendFlowInfo.deleteZpRecommendFlowInfo", id);
    }
    
    /**
     * 删除  推荐流程
     * 
     * @param id 主键
     */
    public void deleteZpRecommendFlowInfo(ZpRecommendFlowInfo p)throws Exception {
        getSqlSession().delete("ZpRecommendFlowInfo.deleteZpRecommendFlowInfo", p);
    }
    
    /**
     * 获得  推荐流程
     * 
     * @param id 推荐流程Id
     * 
     * @return 返回与ID匹配的推荐流程
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfoById(java.lang.Long id)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("auditId", id);
    	return (ZpRecommendFlowInfo) getSqlSession().selectOne("ZpRecommendFlowInfo.getZpRecommendFlowInfoById", pMap);
    }
    
    /**
     * 获得  推荐流程
     * 
     * @param id 推荐流程Id
     * 
     * @return 返回与ID匹配的推荐流程
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfoById(java.lang.Long id,Long accountId)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("auditId", id);
    	pMap.put("inPerson", accountId);
    	return (ZpRecommendFlowInfo) getSqlSession().selectOne("ZpRecommendFlowInfo.getZpRecommendFlowInfoById", pMap);
    }
    
    /**
     * 获得  推荐流程
     * 
     * @param id 推荐流程Id
     * 
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfo(HashMap<String,Object> pMap)throws Exception {
    	return (ZpRecommendFlowInfo) getSqlSession().selectOne("ZpRecommendFlowInfo.queryZpRecommendFlowInfoList", pMap);
    }
    
    /**
     * 获得  推荐流程
     * 
     * @param name 推荐流程名称
     * 
     * @return 返回与NAME匹配的推荐流程
     */
    public ZpRecommendFlowInfo getZpRecommendFlowInfoByName(String name)throws Exception {
        return null;
        //return (ZpRecommendFlowInfo) getSqlSession().selectOne("ZpRecommendFlowInfo.getZpRecommendFlowInfoByName", name);
    }
    
    
    
    /**
     * 查询  推荐流程列表条数
     * 
     * @param name 推荐流程名称
     * @return 推荐流程列表条数
     */
    
    public int getZpRecommendFlowInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpRecommendFlowInfo.getZpRecommendFlowInfoListCount", pMap);
    }

    /**
     * 查询 推荐流程列表
     * 
     * @param name 推荐流程名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 推荐流程列表
     */
    public List<ZpRecommendFlowInfo> queryZpRecommendFlowInfoList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpRecommendFlowInfo.queryZpRecommendFlowInfoList", pMap);
    }
    
    /**
     * 查询 推荐流程列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpRecommendFlowInfo> queryZpRecommendFlowInfoList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpRecommendFlowInfo.queryZpRecommendFlowInfoList", pMap);
    }
    
    /**
     * 查询 推荐流程列表
     * 
     * @return 推荐流程列表
     */
    public List<ZpRecommendFlowInfo> queryZpRecommendFlowInfoList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpRecommendFlowInfo.queryZpRecommendFlowInfoList",params);
    }
    
    /**
     * 查询 推荐流程列表
     * 
     * @return 推荐流程列表
     */
    public List<ZpRecommendFlowInfo> queryZpRecommendFlowInfoList(ZpRecommendFlowInfo p )throws Exception {
        return getSqlSession().selectList("ZpRecommendFlowInfo.queryZpRecommendFlowInfoList",p);
    }
    
    /**
     * 统计 推荐流程列表
     * 
     * @return 推荐流程列表
     */
    public List<HashMap<String,Object>> statisticsZpRecommendFlowInfoInfo(HashMap<String, Object> pMap )throws Exception {
    	List<HashMap<String,Object>> p = null; 
    	p =(List)getSqlSession().selectList("ZpRecommendFlowInfo.statisticsZpRecommendFlowInfoInfo",p);
    	return p;
    }
    
    
    
    

}

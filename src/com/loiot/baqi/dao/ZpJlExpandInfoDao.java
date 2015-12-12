
package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpJlExpandInfo;
import com.loiot.baqi.vo.JlAuditPersonList;
import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * 简历扩展信息 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-10-23
 */
@Repository("zpJlExpandInfoDao")
public class ZpJlExpandInfoDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 简历扩展信息
     * 
     * @param p 参数对象
     */
    public ZpJlExpandInfo addZpJlExpandInfo(ZpJlExpandInfo p)throws Exception {
        this.getSqlSession().insert("ZpJlExpandInfo.addZpJlExpandInfo", p);
        return p;
    }
    
    /**
     * 修改 简历扩展信息
     * 
     * @param p 参数对象
     */
    public void updateZpJlExpandInfo(ZpJlExpandInfo p)throws Exception {
        this.getSqlSession().update("ZpJlExpandInfo.updateZpJlExpandInfo", p);
    }
    
    
    /**
     * 修改 简历扩展信息
     * 
     * @param p 参数对象
     */
    public void updateZpJlExpandInfo(HashMap<String,Object> pMap)throws Exception {
        this.getSqlSession().update("ZpJlExpandInfo.updateZpJlExpandInfoByMap", pMap);
    }
    
    /**
     * 删除  简历扩展信息
     * 
     * @param id 主键
     */
    public void deleteZpJlExpandInfo(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpJlExpandInfo.deleteZpJlExpandInfo", id);
    }
    
    /**
     * 删除  简历扩展信息
     * 
     * @param id 主键
     */
    public void deleteZpJlExpandInfo(ZpJlExpandInfo p)throws Exception {
        getSqlSession().delete("ZpJlExpandInfo.deleteZpJlExpandInfo", p);
    }
    
    /**
     * 获得  简历扩展信息
     * 
     * @param id 简历扩展信息Id
     * 
     * @return 返回与ID匹配的简历扩展信息
     */
    public ZpJlExpandInfo getZpJlExpandInfoById(java.lang.Long id)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("jlExpandId", id);
    	return (ZpJlExpandInfo) getSqlSession().selectOne("ZpJlExpandInfo.getZpJlExpandInfoById", pMap);
    }
    
    /**
     * 获得  简历扩展信息
     * 
     * @param id 简历扩展信息Id
     * 
     * @return 返回与ID匹配的简历扩展信息
     */
    public ZpJlExpandInfo getZpJlExpandInfoById(java.lang.Long id,Long accountId)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("jlExpandId", id);
    	pMap.put("inPerson", accountId);
    	return (ZpJlExpandInfo) getSqlSession().selectOne("ZpJlExpandInfo.getZpJlExpandInfoById", pMap);
    }
    
    /**
     * 获得  简历扩展信息
     * 
     * @param id 简历扩展信息Id
     * 
     */
    public ZpJlExpandInfo getZpJlExpandInfo(HashMap<String,Object> pMap)throws Exception {
    	return (ZpJlExpandInfo) getSqlSession().selectOne("ZpJlExpandInfo.queryZpJlExpandInfoList", pMap);
    }
    
    /**
     * 获得  简历扩展信息
     * 
     * @param name 简历扩展信息名称
     * 
     * @return 返回与NAME匹配的简历扩展信息
     */
    public ZpJlExpandInfo getZpJlExpandInfoByName(String name)throws Exception {
        return null;
        //return (ZpJlExpandInfo) getSqlSession().selectOne("ZpJlExpandInfo.getZpJlExpandInfoByName", name);
    }
    
    
    
    /**
     * 查询  简历扩展信息列表条数
     * 
     * @param name 简历扩展信息名称
     * @return 简历扩展信息列表条数
     */
    
    public int getZpJlExpandInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpJlExpandInfo.getZpJlExpandInfoListCount", pMap);
    }

    /**
     * 查询 简历扩展信息列表
     * 
     * @param name 简历扩展信息名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 简历扩展信息列表
     */
    public List<ZpJlExpandInfo> queryZpJlExpandInfoList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpJlExpandInfo.queryZpJlExpandInfoList", pMap);
    }
    
    /**
     * 查询 简历扩展信息列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpJlExpandInfo> queryZpJlExpandInfoList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpJlExpandInfo.queryZpJlExpandInfoList", pMap);
    }
    
    /**
     * 查询 简历扩展信息列表
     * 
     * @param pMap 参数列表
     */
    public List<HashMap<String,Object>> queryNotAuditJl(HashMap<String, Object> pMap)throws Exception {
    	List<HashMap<String,Object>> p = null; 
    	p =(List)getSqlSession().selectList("ZpJlExpandInfo.queryNotAuditJl", pMap);
        return p;
    }
    
    
    
    /**
     * 审核人信息统计
     * 
     * @param pMap 参数列表
     */
    public List<JlAuditPersonList> auditPersonStatistics(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpJlExpandInfo.auditPersonStatistics", pMap);
    }
    
    /**
     * 查询 简历扩展信息列表
     * 
     * @return 简历扩展信息列表
     */
    public List<ZpJlExpandInfo> queryZpJlExpandInfoList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpJlExpandInfo.queryZpJlExpandInfoList",params);
    }
    
    /**
     * 查询 简历扩展信息列表
     * 
     * @return 简历扩展信息列表
     */
    public List<ZpJlExpandInfo> queryZpJlExpandInfoList(ZpJlExpandInfo p )throws Exception {
        return getSqlSession().selectList("ZpJlExpandInfo.queryZpJlExpandInfoList",p);
    }
    
    

}

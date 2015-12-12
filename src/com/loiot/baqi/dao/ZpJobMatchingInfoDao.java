package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpJobMatchingInfo;

/**
 * 职位匹配信息 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-10-03
 */
@Repository("zpJobMatchingInfoDao")
public class ZpJobMatchingInfoDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 职位匹配信息
     * 
     * @param p 参数对象
     */
    public ZpJobMatchingInfo addZpJobMatchingInfo(ZpJobMatchingInfo p)throws Exception {
        this.getSqlSession().insert("ZpJobMatchingInfo.addZpJobMatchingInfo", p);
        return p;
    }
    
    /**
     * 修改 职位匹配信息
     * 
     * @param p 参数对象
     */
    public void updateZpJobMatchingInfo(ZpJobMatchingInfo p)throws Exception {
        this.getSqlSession().update("ZpJobMatchingInfo.updateZpJobMatchingInfo", p);
    }
    
    /**
     * 删除  职位匹配信息
     * 
     * @param id 主键
     */
    public void deleteZpJobMatchingInfo(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpJobMatchingInfo.deleteZpJobMatchingInfo", id);
    }
    
    /**
     * 删除  职位匹配信息
     * 
     * @param id 主键
     */
    public void deleteZpJobMatchingInfo(ZpJobMatchingInfo p)throws Exception {
        getSqlSession().delete("ZpJobMatchingInfo.deleteZpJobMatchingInfo", p);
    }
    
    /**
     * 获得  职位匹配信息
     * 
     * @param id 职位匹配信息Id
     * 
     * @return 返回与ID匹配的职位匹配信息
     */
    public ZpJobMatchingInfo getZpJobMatchingInfoById(java.lang.Long id)throws Exception {
    	HashMap map = new HashMap();
    	map.put("matchId", id);
        return (ZpJobMatchingInfo) getSqlSession().selectOne("ZpJobMatchingInfo.getZpJobMatchingInfoById", map);
    }
    
    /**
     * 获得  职位匹配信息
     * 
     * @param name 职位匹配信息名称
     * 
     * @return 返回与NAME匹配的职位匹配信息
     */
    public ZpJobMatchingInfo getZpJobMatchingInfoByName(String name)throws Exception {
        return null;
        //return (ZpJobMatchingInfo) getSqlSession().selectOne("ZpJobMatchingInfo.getZpJobMatchingInfoByName", name);
    }
    
    
    
    /**
     * 查询  职位匹配信息列表条数
     * 
     * @param name 职位匹配信息名称
     * @return 职位匹配信息列表条数
     */
    
    public int getZpJobMatchingInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpJobMatchingInfo.getZpJobMatchingInfoListCount", pMap);
    }

    /**
     * 查询 职位匹配信息列表
     * 
     * @param name 职位匹配信息名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 职位匹配信息列表
     */
    public List<ZpJobMatchingInfo> queryZpJobMatchingInfoList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpJobMatchingInfo.queryZpJobMatchingInfoList", pMap);
    }
    
    /**
     * 查询 职位匹配信息列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpJobMatchingInfo> queryZpJobMatchingInfoList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpJobMatchingInfo.queryZpJobMatchingInfoList", pMap);
    }
    
    /**
     * 查询 职位匹配信息列表
     * 
     * @return 职位匹配信息列表
     */
    public List<ZpJobMatchingInfo> queryZpJobMatchingInfoList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpJobMatchingInfo.queryZpJobMatchingInfoList",params);
    }
    
    /**
     * 查询 职位匹配信息列表
     * 
     * @return 职位匹配信息列表
     */
    public List<ZpJobMatchingInfo> queryZpJobMatchingInfoList(ZpJobMatchingInfo p )throws Exception {
        return getSqlSession().selectList("ZpJobMatchingInfo.queryZpJobMatchingInfoList",p);
    }
    
    

}

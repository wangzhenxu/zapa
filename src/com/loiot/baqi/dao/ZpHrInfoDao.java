package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpHrInfo;

/**
 * hr(人力资源hr) 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-09-03
 */
@Repository("zpHrInfoDao")
public class ZpHrInfoDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 hr(人力资源hr)
     * 
     * @param p 参数对象
     */
    public void addZpHrInfo(ZpHrInfo p)throws Exception {
        this.getSqlSession().insert("ZpHrInfo.addZpHrInfo", p);
    }
    
    /**
     * 修改 hr(人力资源hr)
     * 
     * @param p 参数对象
     */
    public void updateZpHrInfo(ZpHrInfo p)throws Exception {
        this.getSqlSession().update("ZpHrInfo.updateZpHrInfo", p);
    }
    
    /**
     * 删除  hr(人力资源hr)
     * 
     * @param id 主键
     */
    public void deleteZpHrInfo(java.lang.Long hrId)throws Exception {
        getSqlSession().delete("ZpHrInfo.deleteZpHrInfo", hrId);
    }
    
    /**
     * 删除  hr(人力资源hr)
     * 
     * @param id 主键
     */
    public void deleteZpHrInfo(ZpHrInfo p)throws Exception {
        getSqlSession().delete("ZpHrInfo.deleteZpHrInfo", p);
    }
    
    /**
     * 获得  hr(人力资源hr)
     * 
     * @param id hr(人力资源hr)Id
     * 
     * @return 返回与ID匹配的hr(人力资源hr)
     */
    public ZpHrInfo getZpHrInfoById(java.lang.Long id)throws Exception {
        return (ZpHrInfo) getSqlSession().selectOne("ZpHrInfo.getZpHrInfoById", id);
    }
    
    /**
     * 获得  hr(人力资源hr)
     * 
     * @param name hr(人力资源hr)名称
     * 
     * @return 返回与NAME匹配的hr(人力资源hr)
     */
    public ZpHrInfo getZpHrInfoByName(String name)throws Exception {
        return (ZpHrInfo) getSqlSession().selectOne("ZpHrInfo.getZpHrInfoByName", name);
    }
    
    
    
    /**
     * 查询  hr(人力资源hr)列表条数
     * 
     * @param name hr(人力资源hr)名称
     * @return hr(人力资源hr)列表条数
     */
    
    public int getZpHrInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpHrInfo.getZpHrInfoListCount", pMap);
    }

    /**
     * 查询 hr(人力资源hr)列表
     * 
     * @param name hr(人力资源hr)名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return hr(人力资源hr)列表
     */
    public List<ZpHrInfo> queryZpHrInfoList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpHrInfo.queryZpHrInfoList", pMap);
    }
    
    /**
     * 查询 hr(人力资源hr)列表
     * 
     * @return hr(人力资源hr)列表
     */
    public List<ZpHrInfo> queryZpHrInfoList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpHrInfo.queryZpHrInfoList",params);
    }
    
    /**
     * 查询 hr(人力资源hr)列表
     * 
     * @return hr(人力资源hr)列表
     */
    public List<ZpHrInfo> queryZpHrInfoList(ZpHrInfo p )throws Exception {
        return getSqlSession().selectList("ZpHrInfo.queryZpHrInfoList",p);
    }
    
    

}

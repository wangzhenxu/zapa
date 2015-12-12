package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpCompanyJobInfo;

/**
 * 公司职位 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-09-30
 */
@Repository("zpCompanyJobInfoDao")
public class ZpCompanyJobInfoDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 公司职位
     * 
     * @param p 参数对象
     */
    public void addZpCompanyJobInfo(ZpCompanyJobInfo p)throws Exception {
        this.getSqlSession().insert("ZpCompanyJobInfo.addZpCompanyJobInfo", p);
    }
    
    /**
     * 修改 公司职位
     * 
     * @param p 参数对象
     */
    public void updateZpCompanyJobInfo(ZpCompanyJobInfo p)throws Exception {
        this.getSqlSession().update("ZpCompanyJobInfo.updateZpCompanyJobInfo", p);
    }
    
    /**
     * 删除  公司职位
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobInfo(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpCompanyJobInfo.deleteZpCompanyJobInfo", id);
    }
    
    /**
     * 删除  公司职位
     * 
     * @param id 主键
     */
    public void deleteZpCompanyJobInfo(ZpCompanyJobInfo p)throws Exception {
        getSqlSession().delete("ZpCompanyJobInfo.deleteZpCompanyJobInfo", p);
    }
    
    /**
     * 获得  公司职位
     * 
     * @param id 公司职位Id
     * 
     * @return 返回与ID匹配的公司职位
     */
    public ZpCompanyJobInfo getZpCompanyJobInfoById(java.lang.Long id)throws Exception {
        return (ZpCompanyJobInfo) getSqlSession().selectOne("ZpCompanyJobInfo.getZpCompanyJobInfoById", id);
    }
    
    /**
     * 获得  公司职位
     * 
     * @param name 公司职位名称
     * 
     * @return 返回与NAME匹配的公司职位
     */
    public ZpCompanyJobInfo getZpCompanyJobInfoByName(String name)throws Exception {
        return null;
        //return (ZpCompanyJobInfo) getSqlSession().selectOne("ZpCompanyJobInfo.getZpCompanyJobInfoByName", name);
    }
    
    
    
    /**
     * 查询  公司职位列表条数
     * 
     * @param name 公司职位名称
     * @return 公司职位列表条数
     */
    
    public int getZpCompanyJobInfoListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpCompanyJobInfo.getZpCompanyJobInfoListCount", pMap);
    }

    /**
     * 查询 公司职位列表
     * 
     * @param name 公司职位名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 公司职位列表
     */
    public List<ZpCompanyJobInfo> queryZpCompanyJobInfoList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpCompanyJobInfo.queryZpCompanyJobInfoList", pMap);
    }
    
    /**
     * 查询 公司职位列表
     * 
     * @param pMap 参数列表
     */
    public List<ZpCompanyJobInfo> queryZpCompanyJobInfoList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("ZpCompanyJobInfo.queryZpCompanyJobInfoList", pMap);
    }
    
    /**
     * 查询 公司职位列表
     * 
     * @return 公司职位列表
     */
    public List<ZpCompanyJobInfo> queryZpCompanyJobInfoList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpCompanyJobInfo.queryZpCompanyJobInfoList",params);
    }
    
    /**
     * 查询 公司职位列表
     * 
     * @return 公司职位列表
     */
    public List<ZpCompanyJobInfo> queryZpCompanyJobInfoList(ZpCompanyJobInfo p )throws Exception {
        return getSqlSession().selectList("ZpCompanyJobInfo.queryZpCompanyJobInfoList",p);
    }
    
    

}

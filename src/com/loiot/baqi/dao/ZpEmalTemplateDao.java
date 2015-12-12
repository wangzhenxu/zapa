package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.ZpEmalTemplate;

/**
 * 邮件模版 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-09-04
 */
@Repository("zpEmalTemplateDao")
public class ZpEmalTemplateDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 邮件模版
     * 
     * @param p 参数对象
     */
    public void addZpEmalTemplate(ZpEmalTemplate p)throws Exception {
        this.getSqlSession().insert("ZpEmalTemplate.addZpEmalTemplate", p);
    }
    
    /**
     * 修改 邮件模版
     * 
     * @param p 参数对象
     */
    public void updateZpEmalTemplate(ZpEmalTemplate p)throws Exception {
        this.getSqlSession().update("ZpEmalTemplate.updateZpEmalTemplate", p);
    }
    
    /**
     * 删除  邮件模版
     * 
     * @param id 主键
     */
    public void deleteZpEmalTemplate(java.lang.Long id)throws Exception {
        getSqlSession().delete("ZpEmalTemplate.deleteZpEmalTemplate", id);
    }
    
    /**
     * 删除  邮件模版
     * 
     * @param id 主键
     */
    public void deleteZpEmalTemplate(ZpEmalTemplate p)throws Exception {
        getSqlSession().delete("ZpEmalTemplate.deleteZpEmalTemplate", p);
    }
    
    /**
     * 获得  邮件模版
     * 
     * @param id 邮件模版Id
     * 
     * @return 返回与ID匹配的邮件模版
     */
    public ZpEmalTemplate getZpEmalTemplateById(java.lang.Long id)throws Exception {
        return (ZpEmalTemplate) getSqlSession().selectOne("ZpEmalTemplate.getZpEmalTemplateById", id);
    }
    
    /**
     * 获得  邮件模版
     * 
     * @param name 邮件模版名称
     * 
     * @return 返回与NAME匹配的邮件模版
     */
    public ZpEmalTemplate getZpEmalTemplateByName(String name)throws Exception {
        return null;
        //return (ZpEmalTemplate) getSqlSession().selectOne("ZpEmalTemplate.getZpEmalTemplateByName", name);
    }
    
    
    
    /**
     * 查询  邮件模版列表条数
     * 
     * @param name 邮件模版名称
     * @return 邮件模版列表条数
     */
    
    public int getZpEmalTemplateListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("ZpEmalTemplate.getZpEmalTemplateListCount", pMap);
    }

    /**
     * 查询 邮件模版列表
     * 
     * @param name 邮件模版名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 邮件模版列表
     */
    public List<ZpEmalTemplate> queryZpEmalTemplateList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("ZpEmalTemplate.queryZpEmalTemplateList", pMap);
    }
    
    /**
     * 查询 邮件模版列表
     * 
     * @return 邮件模版列表
     */
    public List<ZpEmalTemplate> queryZpEmalTemplateList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("ZpEmalTemplate.queryZpEmalTemplateList",params);
    }
    
    /**
     * 查询 邮件模版列表
     * 
     * @return 邮件模版列表
     */
    public List<ZpEmalTemplate> queryZpEmalTemplateList(ZpEmalTemplate p )throws Exception {
        return getSqlSession().selectList("ZpEmalTemplate.queryZpEmalTemplateList",p);
    }
    
    

}

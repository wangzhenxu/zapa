package com.loiot.baqi.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.ZpEmalTemplateDao;
import com.loiot.baqi.service.ZpEmalTemplateService;
import com.loiot.baqi.pojo.ZpEmalTemplate;

/**
 * 邮件模版 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-09-04
 */
@Service("zpEmalTemplateService")
@Transactional
public class ZpEmalTemplateService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private ZpEmalTemplateDao zpEmalTemplateDao;
	
	
	 /**
     * 查询 邮件模版列表分页
     * 
     * @param name 邮件模版名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<ZpEmalTemplate> queryZpEmalTemplateListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询邮件模版列表总条数
        int totalResults = zpEmalTemplateDao.getZpEmalTemplateListCount(pMap);

        // 构造一个分页器
        Pager<ZpEmalTemplate> pager = new Pager<ZpEmalTemplate>(totalResults, pageIndex);

        // 查询邮件模版列表
        List<ZpEmalTemplate> zpEmalTemplateList = zpEmalTemplateDao.queryZpEmalTemplateList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(zpEmalTemplateList);
        return pager;
    }
	
	 /**
     * 添加 邮件模版
     * 
     * @param p 参数对象
     */
    public void addZpEmalTemplate(ZpEmalTemplate p)throws Exception {
        zpEmalTemplateDao.addZpEmalTemplate(p);
    }
    
    /**
     * 修改 邮件模版
     * 
     * @param p 参数对象
     */
    public void updateZpEmalTemplate(ZpEmalTemplate p)throws Exception {
        zpEmalTemplateDao.updateZpEmalTemplate(p);
    }
    
    /**
     * 删除  邮件模版
     * 
     * @param id 主键
     */
    public void deleteZpEmalTemplate(java.lang.Long id)throws Exception {
        zpEmalTemplateDao.deleteZpEmalTemplate(id);
    }
    
    /**
     * 删除  邮件模版
     * 
     * @param id 主键
     */
    public void deleteZpEmalTemplate(ZpEmalTemplate p)throws Exception {
        zpEmalTemplateDao.deleteZpEmalTemplate(p);
    }
    
    /**
     * 获得  邮件模版
     * 
     * @param id 邮件模版Id
     * 
     * @return 返回与ID匹配的邮件模版
     */
    public ZpEmalTemplate getZpEmalTemplateById(java.lang.Long id)throws Exception {
        return  zpEmalTemplateDao.getZpEmalTemplateById(id);
    }
    
    /**
     * 获得  邮件模版
     * 
     * @param name 邮件模版名称
     * 
     * @return 返回与NAME匹配的邮件模版
     */
    public ZpEmalTemplate getZpEmalTemplateByName(String name)throws Exception {
        return  zpEmalTemplateDao.getZpEmalTemplateByName(name);
    }
    
    /**
     * 查询 邮件模版列表
     * @return 邮件模版列表
     */
    public List<ZpEmalTemplate> queryZpEmalTemplateList()throws Exception {
        return  zpEmalTemplateDao.queryZpEmalTemplateList();
    }
    
    /**
     * 查询 邮件模版列表
     * @return 邮件模版列表
     */
    public List<ZpEmalTemplate> queryZpEmalTemplateList(ZpEmalTemplate p)throws Exception {
        return  zpEmalTemplateDao.queryZpEmalTemplateList(p);
    }
    
    /**
     * 查询  邮件模版列表条数
     * 
     * @param name 邮件模版名称
     * @return 邮件模版列表条数
     */
    
    public int getZpEmalTemplateListCount(HashMap<String,Object> pMap)throws Exception {
        return  zpEmalTemplateDao.getZpEmalTemplateListCount(pMap);
    }
    
    
	
}

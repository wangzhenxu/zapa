package com.loiot.baqi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loiot.baqi.controller.response.Pager;
import com.loiot.baqi.dao.TaskScheduleJobDao;
import com.loiot.baqi.service.TaskScheduleJobService;
import com.loiot.baqi.pojo.TaskScheduleJob;
import com.loiot.baqi.pojo.ZpJlJobLevels;


/**
 * 任务 逻辑类。
 * 
 * @author  wangzx 
 * @creation 2015-11-14
 */
@Service("taskScheduleJobService")
@Transactional
public class TaskScheduleJobService{
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
	private TaskScheduleJobDao taskScheduleJobDao;
	
	
	 /**
     * 查询 任务列表分页
     * 
     * @param name 任务名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<TaskScheduleJob> queryTaskScheduleJobListPage(HashMap<String,Object> pMap, int pageIndex)throws Exception {

        // 查询任务列表总条数
        int totalResults = taskScheduleJobDao.getTaskScheduleJobListCount(pMap);

        // 构造一个分页器
        Pager<TaskScheduleJob> pager = new Pager<TaskScheduleJob>(totalResults, pageIndex);

        // 查询任务列表
        List<TaskScheduleJob> taskScheduleJobList = taskScheduleJobDao.queryTaskScheduleJobList(pMap, pager.getSkipResults(),
                pager.getMaxResults());
        pager.setData(taskScheduleJobList);
        return pager;
    }
    
    
    
    
    /**
     * 查询 任务（假）分页
     * 
     * @param name 任务名称
     * @param pageIndex 页索引
     * @return
     */
    public Pager<TaskScheduleJob> queryFlasePageList(HashMap<String,Object> pMap, int pageIndex)throws Exception {
    	//假分页
    	Pager<TaskScheduleJob> pager = this.setPkList(pMap,pageIndex);
    	List<TaskScheduleJob> taskScheduleJobList = taskScheduleJobDao.queryTaskScheduleJobList(pMap);
        pager.setData(taskScheduleJobList);
        return pager;
    }
    
    /**
     * 设置 假分页id集合到Map中
     * @param pMap
     * @param pageIndex
     * @return
     * @throws Exception
     */
    public Pager<TaskScheduleJob> setPkList(HashMap<String,Object> pMap,int pageIndex) throws Exception{
    	  // 查询职位匹配信息列表总条数
        List<TaskScheduleJob> list = taskScheduleJobDao.queryTaskScheduleJobList(pMap);
        // 构造一个分页器
        Pager<TaskScheduleJob> pager = new Pager<TaskScheduleJob>(list.size(), pageIndex, 5,list);
        List<TaskScheduleJob> idsList = pager.getCurrentPageData();
        List<Long> ids =this.getIds(idsList);
        pMap.put("ids", ids);
        return pager;
    }
	
	 /**
     * 添加 任务
     * 
     * @param p 参数对象
     */
    public TaskScheduleJob addTaskScheduleJob(TaskScheduleJob p)throws Exception {
       return  taskScheduleJobDao.addTaskScheduleJob(p);
    }
    
    /**
     * 修改 任务
     * 
     * @param p 参数对象
     */
    public void updateTaskScheduleJob(TaskScheduleJob p)throws Exception {
        taskScheduleJobDao.updateTaskScheduleJob(p);
    }
    
    /**
     * 修改 任务
     * 
     * @param p 参数对象
     */
    public void updateTaskScheduleJob(HashMap<String,Object> pMap)throws Exception {
        taskScheduleJobDao.updateTaskScheduleJob(pMap);
    }
    
    /**
     * 删除  任务
     * 
     * @param id 主键
     */
    public void deleteTaskScheduleJob(java.lang.Long id)throws Exception {
        taskScheduleJobDao.deleteTaskScheduleJob(id);
    }
    
    /**
     * 删除  任务
     * 
     * @param id 主键
     */
    public void deleteTaskScheduleJob(TaskScheduleJob p)throws Exception {
        taskScheduleJobDao.deleteTaskScheduleJob(p);
    }
    
    /**
     * 获得  任务
     * 
     * @param id 任务Id
     * 
     * @return 返回与ID匹配的任务
     */
    public TaskScheduleJob getTaskScheduleJobById(java.lang.Long id)throws Exception {
        return  taskScheduleJobDao.getTaskScheduleJobById(id);
    }
    
    /**
     * 获得  任务
     * 
     * @param id 任务Id
     * 
     * @return 返回与ID匹配的任务
     */
    public TaskScheduleJob getTaskScheduleJobById(java.lang.Long id,Long accountId)throws Exception {
        return  taskScheduleJobDao.getTaskScheduleJobById(id,accountId);
    }
    
    
    /**
     * 获得  任务
     * 
     * @param id 任务Id
     * 
     */
    public TaskScheduleJob getTaskScheduleJob(HashMap<String,Object> pMap)throws Exception {
    	return (TaskScheduleJob) taskScheduleJobDao.getTaskScheduleJob(pMap);
    }
    /**
     * 获得  任务
     * 
     * @param name 任务名称
     * 
     * @return 返回与NAME匹配的任务
     */
    public TaskScheduleJob getTaskScheduleJobByName(String name)throws Exception {
        return  taskScheduleJobDao.getTaskScheduleJobByName(name);
    }
    
    /**
     * 查询 任务列表
     * @return 任务列表
     */
    public List<TaskScheduleJob> queryTaskScheduleJobList(HashMap<String,Object> pMap)throws Exception {
        return  taskScheduleJobDao.queryTaskScheduleJobList(pMap);
    }
    
    /**
     * 查询 任务列表
     * @return 任务列表
     */
    public List<TaskScheduleJob> queryTaskScheduleJobList(TaskScheduleJob p)throws Exception {
        return  taskScheduleJobDao.queryTaskScheduleJobList(p);
    }
    
    /**
     * 查询  任务列表条数
     * 
     * @param name 任务名称
     * @return 任务列表条数
     */
    
    public int getTaskScheduleJobListCount(HashMap<String,Object> pMap)throws Exception {
        return  taskScheduleJobDao.getTaskScheduleJobListCount(pMap);
    }
    
    /**
     * 查询id集合
     * @return
     */
    public List<Long> getIds(List<TaskScheduleJob> list) {
    	List<Long> idsList = null;
        if(list!=null && list.size()>0) {
        	idsList = new ArrayList<Long>();
        	for (TaskScheduleJob b : list) {
            	idsList.add(null);
            }
        }
        return idsList;
    }
}

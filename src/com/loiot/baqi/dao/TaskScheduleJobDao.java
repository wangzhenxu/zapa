package com.loiot.baqi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.loiot.baqi.pojo.TaskScheduleJob;

/**
 * 任务 访问层。
 * 
 * @author  wangzx 
 * @creation 2015-11-14
 */
@Repository("taskScheduleJobDao")
public class TaskScheduleJobDao extends SqlSessionDaoSupport{
    
    /**
     * 添加 任务
     * 
     * @param p 参数对象
     */
    public TaskScheduleJob addTaskScheduleJob(TaskScheduleJob p)throws Exception {
        this.getSqlSession().insert("TaskScheduleJob.addTaskScheduleJob", p);
        return p;
    }
    
    /**
     * 修改 任务
     * 
     * @param p 参数对象
     */
    public void updateTaskScheduleJob(TaskScheduleJob p)throws Exception {
        this.getSqlSession().update("TaskScheduleJob.updateTaskScheduleJob", p);
    }
    
    /**
     * 修改 任务
     * 
     * @param p 参数对象
     */
    public void updateTaskScheduleJob(HashMap<String,Object> pMap)throws Exception {
        this.getSqlSession().update("TaskScheduleJob.updateTaskScheduleJobByMap", pMap);
    }
    
    
    
    /**
     * 删除  任务
     * 
     * @param id 主键
     */
    public void deleteTaskScheduleJob(java.lang.Long id)throws Exception {
        getSqlSession().delete("TaskScheduleJob.deleteTaskScheduleJob", id);
    }
    
    /**
     * 删除  任务
     * 
     * @param id 主键
     */
    public void deleteTaskScheduleJob(TaskScheduleJob p)throws Exception {
        getSqlSession().delete("TaskScheduleJob.deleteTaskScheduleJob", p);
    }
    
    /**
     * 获得  任务
     * 
     * @param id 任务Id
     * 
     * @return 返回与ID匹配的任务
     */
    public TaskScheduleJob getTaskScheduleJobById(java.lang.Long id)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("jobId", id);
    	return (TaskScheduleJob) getSqlSession().selectOne("TaskScheduleJob.getTaskScheduleJobById", pMap);
    }
    
    /**
     * 获得  任务
     * 
     * @param id 任务Id
     * 
     * @return 返回与ID匹配的任务
     */
    public TaskScheduleJob getTaskScheduleJobById(java.lang.Long id,Long accountId)throws Exception {
    	HashMap<String, Object> pMap = new HashMap<String, Object>();
    	pMap.put("jobId", id);
    	pMap.put("inPerson", accountId);
    	return (TaskScheduleJob) getSqlSession().selectOne("TaskScheduleJob.getTaskScheduleJobById", pMap);
    }
    
    /**
     * 获得  任务
     * 
     * @param id 任务Id
     * 
     */
    public TaskScheduleJob getTaskScheduleJob(HashMap<String,Object> pMap)throws Exception {
    	return (TaskScheduleJob) getSqlSession().selectOne("TaskScheduleJob.queryTaskScheduleJobList", pMap);
    }
    
    /**
     * 获得  任务
     * 
     * @param name 任务名称
     * 
     * @return 返回与NAME匹配的任务
     */
    public TaskScheduleJob getTaskScheduleJobByName(String name)throws Exception {
        return null;
        //return (TaskScheduleJob) getSqlSession().selectOne("TaskScheduleJob.getTaskScheduleJobByName", name);
    }
    
    
    
    /**
     * 查询  任务列表条数
     * 
     * @param name 任务名称
     * @return 任务列表条数
     */
    
    public int getTaskScheduleJobListCount(HashMap<String,Object> pMap)throws Exception {
        return (Integer) getSqlSession().selectOne("TaskScheduleJob.getTaskScheduleJobListCount", pMap);
    }

    /**
     * 查询 任务列表
     * 
     * @param name 任务名称
     * @param skipResults 跳过的记录数
     * @param maxResults 最大的记录数
     * @return 任务列表
     */
    public List<TaskScheduleJob> queryTaskScheduleJobList(HashMap<String, Object> pMap, int skipResults, int maxResults)throws Exception {
    	pMap.put("skipResults", skipResults);
    	pMap.put("maxResults", maxResults);
        return getSqlSession().selectList("TaskScheduleJob.queryTaskScheduleJobList", pMap);
    }
    
    /**
     * 查询 任务列表
     * 
     * @param pMap 参数列表
     */
    public List<TaskScheduleJob> queryTaskScheduleJobList(HashMap<String, Object> pMap)throws Exception {
        return getSqlSession().selectList("TaskScheduleJob.queryTaskScheduleJobList", pMap);
    }
    
    /**
     * 查询 任务列表
     * 
     * @return 任务列表
     */
    public List<TaskScheduleJob> queryTaskScheduleJobList()throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        return getSqlSession().selectList("TaskScheduleJob.queryTaskScheduleJobList",params);
    }
    
    /**
     * 查询 任务列表
     * 
     * @return 任务列表
     */
    public List<TaskScheduleJob> queryTaskScheduleJobList(TaskScheduleJob p )throws Exception {
        return getSqlSession().selectList("TaskScheduleJob.queryTaskScheduleJobList",p);
    }
    
    

}

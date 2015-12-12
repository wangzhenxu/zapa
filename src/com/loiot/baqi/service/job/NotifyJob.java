package com.loiot.baqi.service.job;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loiot.baqi.pojo.TaskScheduleJob;
import com.loiot.commons.utils.DateUtil;

public class NotifyJob implements Job {
    private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		TaskScheduleJob task = (TaskScheduleJob)arg0.getMergedJobDataMap().get("taskObj");
        log.info("[" + task.getJobName() + "]  ["+DateUtil.toString(DateUtil.getNow(), DateUtil.DEFAULT_LONG_FORMAT)+"]");
        Object service = com.loiot.baqi.listener.JobListener.getApplicationContext().getBean(task.getSpringId());
        Method method = null; 
        try {
			method = service.getClass().getDeclaredMethod(task.getMethodName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        if (method != null) {  
            try {
				method.invoke(service);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }

	}

}

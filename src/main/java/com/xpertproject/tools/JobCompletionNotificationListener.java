package com.xpertproject.tools;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompletionNotificationListener implements JobExecutionListener{
	
	@Override
    public void beforeJob(JobExecution jobExecution) {

        // TODO Auto-generated method stub
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        System.out.println("Job has been completed");
    }

}

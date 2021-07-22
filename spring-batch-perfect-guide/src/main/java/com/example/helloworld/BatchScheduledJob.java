package com.example.helloworld;

import org.quartz.JobExecutionContext;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BatchScheduledJob extends QuartzJobBean {

    @Autowired
    private Job quartzJob;

    @Autowired
    private JobExplorer jobExplorer;

    @Autowired
    private JobLauncher jobLauncher;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobParameters jobParameters = new JobParametersBuilder(jobExplorer)
            .getNextJobParameters(quartzJob)
            .toJobParameters();

        try {
            jobLauncher.run(quartzJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

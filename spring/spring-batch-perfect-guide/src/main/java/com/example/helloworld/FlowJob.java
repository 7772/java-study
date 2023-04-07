package com.example.helloworld;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class FlowJob {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet loadStockFile() {
        return (contribution, chunkContext) -> {
            System.out.println("The stock file has been loaded");

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet loadCustomerFile() {
        return (contribution, chunkContext) -> {
            System.out.println("The customer file has been loaded");

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet updateStart() {
        return (contribution, chunkContext) -> {
            System.out.println("The start has been updated");

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet runBatchTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("The batch has been run");

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Flow preProcessingFlow() {
        // Flow 정의
        return new FlowBuilder<Flow>("preProcessingFlow")
            .start(loadFileStep())
            .next(loadCustomerStep())
            .next(updateStartStep())
            .build();
    }
    
    @Bean
    public Job conditionalStepLogicJob() {
        return jobBuilderFactory.get("conditionalStepLogicJob")
            .start(initializeBatch())
            .next(runBatch())
            .build();
    }

    @Bean
    public Step initializeBatch() {
        return stepBuilderFactory.get("initializeBatch")
            .flow(preProcessingFlow())
            .build();
    }

    @Bean
    public Step loadFileStep() {
        return stepBuilderFactory.get("loadFileStep")
            .tasklet(loadStockFile())
            .build();
    }

    @Bean
    public Step loadCustomerStep() {
        return stepBuilderFactory.get("loadCustomerStep")
            .tasklet(loadCustomerFile())
            .build();
    }

    @Bean
    public Step updateStartStep() {
        return stepBuilderFactory.get("updateStartStep")
            .tasklet(updateStart())
            .build();
    }

    @Bean
    public Step runBatch() {
        return stepBuilderFactory.get("runBatch")
            .tasklet(runBatchTasklet())
            .build();
    }
}

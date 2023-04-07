package com.example.helloworld;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory; import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ConditionalJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet passTasklet() {
        return (contribution, chunkContext) -> {
//            throw new RuntimeException("This is failure !");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet successTasklet() {
        return (contribution, context) -> {
            System.out.println("Success !");

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet failTasklet() {
        return (contribution, context) -> {
            System.out.println("Failure !");

            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public JobExecutionDecider decider() {
        return new RandomDecider();
    }

    @Bean
    public Job conditionalJob() {
        return jobBuilderFactory.get("conditionalJob")
            .start(firstStep())
            .next(decider())
            .from(decider())
            .on("FAILED").to(failureStep())
            .from(decider())
            .on("*").to(successStep())
            .end()
            .build();
    }

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("firstStep")
            .tasklet(passTasklet())
            .build();
    }

    @Bean
    public Step successStep() {
        return stepBuilderFactory.get("successStep")
            .tasklet(successTasklet())
            .build();
    }

    @Bean
    public Step failureStep() {
        return stepBuilderFactory.get("failureStep")
            .tasklet(failTasklet())
            .build();
    }
}

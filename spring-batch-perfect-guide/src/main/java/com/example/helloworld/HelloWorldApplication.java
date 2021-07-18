package com.example.helloworld;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@EnableBatchProcessing
@SpringBootApplication
public class HelloWorldApplication {

//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public CompositeJobParametersValidator validator() {
//        CompositeJobParametersValidator validator = new CompositeJobParametersValidator();
//
//        DefaultJobParametersValidator defaultJobParametersValidator = new DefaultJobParametersValidator(
//            new String[] {"fileName"},
//            new String[] {"name", "currentDate"}
//        );
//
//        defaultJobParametersValidator.afterPropertiesSet();
//
//        validator.setValidators(
//            Arrays.asList(new ParameterValidator(), defaultJobParametersValidator)
//        );
//
//        return validator;
//    }
//
//    @Bean
//    public Job job() {
//        return jobBuilderFactory.get("basicJob")
//            .start(step())
//            .validator(validator())
//            .incrementer(new DailyJobTimestamper())
//            .listener(new JobLoggerListener())
//            .listener(JobListenerFactoryBean.getListener(
//                new JobLoggerListener()))
//            .build();
//    }
//
//    @Bean
//    public Step step() {
//        return stepBuilderFactory.get("step1")
//            .tasklet(helloWorldTasklet(null, null))
//            .build();
//    }
//
//    @Bean
//    @StepScope
//    public Tasklet helloWorldTasklet(
//        @Value("#{jobParameters['name']}") String name,
//        @Value("#{jobParameters['fileName']}") String fileName
//    ) {
//        return (contribution, chunkContext) -> {
//            System.out.println("Hello, " + name);
//            System.out.println("FileName : " + fileName);
//
//            return RepeatStatus.FINISHED;
//        };
//    }
//
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

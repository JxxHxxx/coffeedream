package com.jxx.toy.batch;

import com.jxx.toy.raffle.application.RaffleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class NotificationBatchService {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final RaffleService raffleService;

    @Bean
    public Job notiJob() {
        return this.jobBuilderFactory
                .get("notiJob")
                .start(selectMembersToSendMessageStep())
                .build();
    }

    @Bean
    public Step selectMembersToSendMessageStep() {
        return this.stepBuilderFactory
                .get("selectMembersToSendMessageStep")
                .tasklet(selectMembersToSendMessageTask())
                .build();
    }

    @Bean
    public Tasklet selectMembersToSendMessageTask() {
        log.info("selectMembersToSendMessageTask");
        Tasklet tasklet = (contribution, chunkContext) -> {
            log.info("process raffle result");

            String raffleId = (String) chunkContext.getStepContext()
                    .getJobParameters().get("raffleId");

            raffleService.processRaffleOne(Long.valueOf(raffleId));

            return RepeatStatus.FINISHED;
        };
        return tasklet;
    }
}

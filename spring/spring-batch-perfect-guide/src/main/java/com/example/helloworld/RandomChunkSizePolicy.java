package com.example.helloworld;

import java.util.Random;

import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;

public class RandomChunkSizePolicy implements CompletionPolicy {
    private int chunkSize;
    private int totalProcessed;
    private final Random random = new Random();

    @Override
    public boolean isComplete(RepeatContext context, RepeatStatus result) {
        if (RepeatStatus.FINISHED == result) {
            return true;
        } else {
            return isComplete(context);
        }
    }

    @Override
    public boolean isComplete(RepeatContext context) {
        return totalProcessed >= chunkSize;
    }

    @Override
    public RepeatContext start(RepeatContext parent) {
        this.chunkSize = random.nextInt(20);
        totalProcessed = 0;

        System.out.println("The chunk size has beean set to " + chunkSize);
        return parent;
    }

    @Override
    public void update(RepeatContext context) {
        System.out.println("Update !");
        totalProcessed++;
    }
}

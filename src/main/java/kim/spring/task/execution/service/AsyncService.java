package kim.spring.task.execution.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {

    @Async
    public void doTask1(int i) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // do nothing
        }
        log.info("Task1_{} started.", i);
    }
}

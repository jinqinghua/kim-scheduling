package kim.spring.task;

import kim.spring.task.execution.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringTaskApplicationRunner implements ApplicationRunner {

    @Autowired
    AsyncService asyncService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 100; i++) {
            asyncService.doTask1(i);
        }
    }
}

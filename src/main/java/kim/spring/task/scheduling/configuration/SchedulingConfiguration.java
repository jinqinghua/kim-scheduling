package kim.spring.task.scheduling.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

@Configuration
@EnableScheduling
public class SchedulingConfiguration {

    /**
     * 如果不定义， Spring 会启动一个 poolSize = 1 ScheduledExecutorTask 去执行
     * 也可以通过配置文件来配置： spring.
     */
    //@Beans
    public ScheduledExecutorFactoryBean scheduledExecutorFactoryBean() {
        ScheduledExecutorFactoryBean factoryBean = new ScheduledExecutorFactoryBean();
        factoryBean.setPoolSize(20);
        factoryBean.setThreadNamePrefix("codeTaskScheduling-");
        factoryBean.setWaitForTasksToCompleteOnShutdown(true); // 等待 Task 执行完成再关闭
        factoryBean.setAwaitTerminationSeconds(60); // 只等60秒
        return factoryBean;
    }

}

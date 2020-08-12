package kim.spring.task.execution.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@Slf4j
public class TaskExecutionConfiguration implements AsyncConfigurer {

    /**
     * 代码方式实现的 default Executor, @Async可以指定具体的 Executor
     *
     * @see TaskExecutionAutoConfiguration
     */
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        return new TaskExecutorBuilder().corePoolSize(8)
                .maxPoolSize(64)
                .queueCapacity(256)
                .allowCoreThreadTimeOut(true)
                .keepAlive(Duration.ofSeconds(60L))
                .threadNamePrefix("codeExecutor")
                .awaitTermination(true)
                .awaitTerminationPeriod(Duration.ofSeconds(60L))
                .build();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (Throwable throwable, Method method, Object... args) -> {
            log.error("\n");
            log.error("Error when execute method:{} with args:{}", method.getName(), args, throwable);
        };
    }
}

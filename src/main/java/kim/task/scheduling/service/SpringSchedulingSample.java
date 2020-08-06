package kim.task.scheduling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Duration 的配置方式有些丑陋，但如果是分钟，小时，天的话，优势就出来了
 *
 * @see java.time.Duration#parse(CharSequence)
 */
@Service
@Slf4j
public class SpringSchedulingSample {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate：固定频率执行，如果上个 task 没有执行完，到了时间点，还是会执行
     */
    // @Scheduled(fixedRate = 5000)
    @Scheduled(fixedRateString = "PT5S")
    public void fixedRateScheduling() {
        log.info("Thread name:={}, {} fixedRateScheduling {}", Thread.currentThread().getName(), dateFormat.format(new Date()), "5s");
    }

    /**
     * fixedDelay：上个 task 执行完后，延迟指定的时间再执行此 task
     */
    // @Scheduled(fixedDelay = 5000)
    @Scheduled(fixedDelayString = "PT5S")
    public void fixedDelayScheduling() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("", e);
        }
        log.info("Thread name:={}, {} fixedDelayScheduling {}", Thread.currentThread().getName(), dateFormat.format(new Date()), "5s");
    }

    /**
     * initialDelay：task 第一次执行前延迟指定的时间
     */
    // @Scheduled(initialDelay = 1000, fixedRate = 4000)
    @Scheduled(initialDelayString = "PT1s", fixedRateString = "PT4S")
    public void fixedDelayWithInitialDelayScheduling() {
        log.info("Thread name:={}, {} fixedDelayWithInitialDelayScheduling {},{}", Thread.currentThread().getName(), dateFormat.format(new Date()), "1s", "4s");
    }

    /**
     * 定时执行， 格式：
     * second minute hour “day of month month” "day of week"
     *
     * @see Scheduled#cron()
     */
    @Scheduled(cron = "0/3 * * * * *")
    public void cronScheduling() {
        log.info("Thread name:={}, {} cronScheduling {}", Thread.currentThread().getName(), dateFormat.format(new Date()), "3s");
    }

}

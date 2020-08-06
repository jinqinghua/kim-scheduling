# scheduling

## 多种方式实现 Scheduling
- Linux crontab
- JDK TimerTask
- ScheduledExecutorService
- Spring Scheduler
- Quartz

## 考虑
- 易用性
- 可配置性，如支持 cron 方式的灵活配置
- 多线程支持
- 错误处理：隔离/重试/报警/日志
- 可管理性：增加/修改/删除/执行/暂停 Job
- 分步式支持


参考：[定时任务系列之Quartz框架](https://www.deepstack.top/articles/2019/09/02/1567420124331.html)

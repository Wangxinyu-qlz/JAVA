package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @program: sky-take-out
 * @author: Qiaolezi
 * @create: 2024-07-23 11:15
 * @description: 自定义定时任务
 **/
//@Component
@Slf4j
public class MyTask {

	/**
	 * 定时任务
	 * <a href="https://cron.qqe2.com/">在线生成cron表达式</a>
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public void executeTask() {
		log.info("定时任务开始运行：{}", new Date());
	}
}

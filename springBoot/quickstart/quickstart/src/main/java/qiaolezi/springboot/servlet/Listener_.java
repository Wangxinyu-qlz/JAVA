package qiaolezi.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 17:18
 * @description:
 **/
@Slf4j
@WebListener
public class Listener_ implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Listener_ contextInitialized() 项目初始化OK~ ");
		ServletContextListener.super.contextInitialized(sce);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("Listener_ contextDestroyed() 项目销毁 ");
		ServletContextListener.super.contextDestroyed(sce);
	}
}

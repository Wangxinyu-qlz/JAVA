package qiaolezi.springboot.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 20:01
 * @description:
 **/
//@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(8080);
	}
}

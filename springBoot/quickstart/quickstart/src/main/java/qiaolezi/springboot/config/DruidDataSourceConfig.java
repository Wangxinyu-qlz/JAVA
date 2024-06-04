package qiaolezi.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 21:31
 * @description:
 **/
@Configuration
public class DruidDataSourceConfig {
	// 默认的自动配置是判断容器中没有才会配
	//@ConditionalOnMissingBean(DataSource.class)
	/**
	 * 1.默认的数据源配置是 @ConditionalOnMissingBean(DataSource.class)
	 * 2.也就是当容器中没有DataSource 组件时，才会注入，如果我们这里配置了DataSource, 就会使用我们配置的数据源
	 * 3."spring.datasource" 会将druid 数据源的配置绑定到application.yml, 就不需要setXxx
	 */
	@ConfigurationProperties("spring.datasource")
	@Bean
	public DataSource dataSource() throws SQLException {
		DruidDataSource druidDataSource = new DruidDataSource();
		// "spring.datasource" 会将druid 数据源的配置绑定到application.yml, 就不需setXxx
		// druidDataSource.setUrl();
		// druidDataSource.setUsername();
		// druidDataSource.setPassword();
		//加入监控功能
		druidDataSource.setFilters("stat, wall");
		return druidDataSource;
	}

	//配置druid的监控功能
	@Bean
	public ServletRegistrationBean statViewServlet() {
		StatViewServlet statViewServlet = new StatViewServlet();
		ServletRegistrationBean<StatViewServlet> registrationBean =
				new ServletRegistrationBean<>(statViewServlet, "/druid/*");
		registrationBean.addInitParameter("loginUsername", "root");
		registrationBean.addInitParameter("loginPassword", "root");

		return registrationBean;
	}

	//配置WebStatFilter，采集web-jdbc关联的监控数据
	@Bean
	public FilterRegistrationBean webStatFilter() {
		WebStatFilter webStatFilter = new WebStatFilter();
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);

		//默认对所有的url进行监控
		filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
		//排除指定的url
		filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterFilterRegistrationBean;
	}
}

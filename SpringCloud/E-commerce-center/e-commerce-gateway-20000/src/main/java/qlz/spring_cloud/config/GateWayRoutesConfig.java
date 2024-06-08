package qlz.spring_cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-08 16:40
 * @description:
 **/
//@Configuration
public class GateWayRoutesConfig {
	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		/**参考yaml配置改写
		 *   cloud:
		 *     gateway:
		 *       #配置路由, 可以有多个路由配置 List<RouteDefinition> routes
		 *       routes:
		 *         - id: member_route01   #路由的 ID，程序员自己写,要求唯一
		 *           #gateway 最终访问的 url = uri+Path 即: http://localhost:10002/memeber/get/
		 *           #匹配后提供服务的路由地址, 也可以是外网 uri,比如 http://www.qq.com 等
		 *           uri: http://localhost:10002
		 *           predicates:
		 *             - Path=/member/get/**
		 *         - id: member_route02
		 *           uri: http://localhost:10002
		 *           predicates:
		 *             - Path=/member/save
		 */
		RouteLocatorBuilder.Builder routes = builder.routes();
		return routes.route("member_routh03", r -> r.path("/member/get/**").uri("http://localhost:10002")).build();
	}

	@Bean
	public RouteLocator customRoutes2(RouteLocatorBuilder builder) {
		RouteLocatorBuilder.Builder routes = builder.routes();
		return routes.route("member_routh04", r->r.path("/member/save").uri("http://localhost:10002")).build();
	}
}

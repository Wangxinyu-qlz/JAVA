package main.spring.component_;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 11:49
 * @description:
 **/
//默认情况下，@Component @Service @Repository @Controller 是单例singleton
@Controller
@Scope(value = "prototype")//作用范围 设置为多例
public class UserAction {

}

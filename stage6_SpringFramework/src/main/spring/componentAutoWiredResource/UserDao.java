package main.spring.componentAutoWiredResource;

import org.springframework.stereotype.Repository;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 12:20
 * @description: @Repository 标识该类是一个 Repository 是一个持久化层的类/对象
 **/
//@Repository(value = "userDao")
@Repository("userDao")  //value= 可以省略
public class UserDao {

}

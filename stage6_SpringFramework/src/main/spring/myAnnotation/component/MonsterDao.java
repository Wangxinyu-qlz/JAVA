package main.spring.myAnnotation.component;

import main.spring.myAnnotation.annotation.Component;
import main.spring.myAnnotation.annotation.Scope;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 15:36
 * @description:
 **/
@Component()
@Scope(value = "singleton")
public class MonsterDao {

}

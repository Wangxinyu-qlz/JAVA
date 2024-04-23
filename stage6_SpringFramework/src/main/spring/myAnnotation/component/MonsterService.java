package main.spring.myAnnotation.component;

import main.spring.myAnnotation.annotation.Component;
import main.spring.myAnnotation.annotation.Scope;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 15:34
 * @description:
 **/
@Component(value = "monsterService")
@Scope(value = "prototype")
public class MonsterService {

}

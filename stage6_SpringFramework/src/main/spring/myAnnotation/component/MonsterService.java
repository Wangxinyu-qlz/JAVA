package main.spring.myAnnotation.component;

import main.spring.myAnnotation.annotation.Autowired;
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
	@Autowired
	private MonsterDao monsterDao;

	public void ok() {
		monsterDao.hi();
	}
}

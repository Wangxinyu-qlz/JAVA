package qiaolezi.springboot.mybatis.service;

import qiaolezi.springboot.mybatis.bean.Monster;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:24
 * @description:
 **/
public interface MonsterService {
	Monster getMonsterById(Integer id);
}

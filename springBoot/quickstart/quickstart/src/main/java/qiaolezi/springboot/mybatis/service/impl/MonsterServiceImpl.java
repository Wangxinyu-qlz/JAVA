package qiaolezi.springboot.mybatis.service.impl;

import org.springframework.stereotype.Service;
import qiaolezi.springboot.mybatis.bean.Monster;
import qiaolezi.springboot.mybatis.mapper.MonsterMapper;
import qiaolezi.springboot.mybatis.service.MonsterService;

import javax.annotation.Resource;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:25
 * @description:
 **/
@Service
public class MonsterServiceImpl implements MonsterService {
	@Resource
	MonsterMapper monsterMapper;

	@Override
	public Monster getMonsterById(Integer id) {
		return monsterMapper.getMonsterById(id);
	}
}

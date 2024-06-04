package qiaolezi.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import qiaolezi.springboot.mybatis.bean.Monster;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:20
 * @description:
 **/
@Mapper
public interface MonsterMapper {
	Monster getMonsterById(Integer id);
}

package mapper;

import entity.Monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-04-30 16:22
 * @description: 用于声明操作monster表的方法
 * 通过注解  xml 文件实现
 **/
public interface MonsterMapper {
	List<Monster> getMonsterByAge(@Param(value = "age") Integer age);

	List<Monster> getMonsterByIdAndName(Monster monster);

	List<Monster> getMonsterByIdOrName_choose(Map<String, Object> map);

	List<Monster> getMonsterById_forEach(Map<String, Object> map);
}

package mapper;

import entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 15:53
 * @description:
 **/
public interface PersonMapperAnnotation {
	//TODO 数据库表是否设置外键，对于 mybatis 级联查询没有影响
	@Select("select * from `person` where `id`= #{id}")
	@Results({
			@Result(id = true, property = "id", column = "id"),
			@Result(property="name", column = "name"),
			@Result(property = "card", column = "card_id",
					one = @One(select = "mapper.IdenCardMapperAnnotation.getIdenCardById"))
	})
	Person getPersonById(Integer id);
}

package mapper;

import entity.IdenCard;
import org.apache.ibatis.annotations.Select;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-07 15:48
 * @description: 使用注解实现一对一映射
 **/
public interface IdenCardMapperAnnotation {
	@Select("select * from `idencard` where `id`= #{id}")
	IdenCard getIdenCardById(Integer id);
}

package mapper;

import entity.Person;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-05 21:25
 * @description:
 **/
public interface PersonMapper {
	//通过Person的id获取到Person，包括这个Person关联的IdenCard对象[级联查询]
	Person getPersonById(Integer id);

	Person getPersonById2(Integer id);

}

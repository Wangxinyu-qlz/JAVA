package mapper;

import entity.IdenCard;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-05 21:15
 * @description:
 **/
public interface IdenCardMapper {
	//根据id获取身份证号
	IdenCard getIdenCardById(Integer id);
}

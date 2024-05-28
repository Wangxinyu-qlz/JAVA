package qiaolezi.furniture.service;

import qiaolezi.furniture.bean.Furn;

import java.util.List;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-10 17:12
 * @description:
 **/
public interface FurnService {
	//添加
	void save(Furn furn);
	List<Furn> findAll();

	void update(Furn furn);
	void delete(Integer id);

	Furn findById(Integer id);
}

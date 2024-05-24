package mapper;

import entity.Monster;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-24 11:44
 * @description:
 **/
public interface MonsterAnnotation {
	@Insert("insert into monster (age,birthday,email,gender,name,salary) " +
			"values (#{age},#{birthday},#{email},#{gender},#{name},#{salary})")
	public void addMonster(Monster monster);

	@Delete("delete from monster where id = #{id}")
	void delMonster(Integer id);

	@Update("update monster set age=#{age}, birthday=#{birthday},email = #{email}," +
			"gender= #{gender},name=#{name}, salary=#{salary} where id = #{id}")
	void updateMonster(Monster monster);

	@Select("select * from monster where id = #{id}")
	Monster getMonsterById(Integer id);
}

package mapper;

import entity.Monster;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-04-30 18:42
 * @description: 使用注解操作数据库
 **/
public interface MonsterAnnotation {
	/**
	 *     <insert id="addMonster" parameterType="Monster" useGeneratedKeys="true" keyProperty="id">
	 *         INSERT INTO `monster`
	 *         (age, birthday, email, gender, name, salary)
	 *         VALUES (#{age}, #{birthday}, #{email}, #{gender}, #{name}, #{salary});
	 *     </insert>
	 */
	//添加monster
	@Insert(value = "INSERT INTO `monster` " +
			"(`age`, `birthday`, `email`, `gender`, `name`, `salary`) " +
			"VALUES (#{age}, #{birthday}, #{email}, #{gender}, #{name}, #{salary})")
	//useGeneratedKeys = true 返回自增值
	//keyProperty="id" 自增值对应的对象属性
	//keyColumn = "id" 自增值对应表的字段
	//keyProperty 和 keyColumn 一致不用添加keyColumn，否则一定要添加
	//建议都写上
	@Options(useGeneratedKeys = true, keyProperty="id", keyColumn = "id")
	void addMonster(Monster monster);

	//删除
	@Delete("DELETE FROM `monster` WHERE id = #{id};")
	void deleteMonster(Integer monsterId);

	//修改
	@Update("UPDATE `monster`\n " +
			"set `age`=#{age}, birthday=#{birthday}, email=#{email}, " +
			"gender=#{gender}, name=#{name}, salary=#{salary} " +
			"where id=#{id}")
	void updateMonster(Monster monster);

	//查询-根据id
	@Select("select * from `monster` where id = #{id};")
	Monster getMonsterById(Integer monsterId);

	//查询所有的Monster
	@Select("select * from `monster`;")
	List<Monster> getAllMonsters();
}

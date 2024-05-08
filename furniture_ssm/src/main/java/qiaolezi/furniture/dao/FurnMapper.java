package qiaolezi.furniture.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qiaolezi.furniture.bean.Furn;
import qiaolezi.furniture.bean.FurnExample;

public interface FurnMapper {
    long countByExample(FurnExample example);

    int deleteByExample(FurnExample example);

    int deleteByPrimaryKey(Integer id);

    //insertSelective 和 insert 的区别：
    //如果User有三个字段：id(Primary Key) name password
    //如果只设置了一个字段: User user = new User(); user.setName("zl"); insertSelective(user);
    //1.insertSelective选择性保存数据
    //    insertSelective()执行sql语句时，只插入对应的name字段(注意主键是自动添加的，默认插入为空)
    //    insert into tb_user (id, name) value (null, "zl");
    //2.insert不论设置多少字段，全部添加一遍
    //    insert into tb_user (id, name password) value (null, "zl", null, null);
    int insert(Furn record);

    int insertSelective(Furn record);

    List<Furn> selectByExample(FurnExample example);

    Furn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Furn record, @Param("example") FurnExample example);

    int updateByExample(@Param("record") Furn record, @Param("example") FurnExample example);

    int updateByPrimaryKeySelective(Furn record);

    int updateByPrimaryKey(Furn record);
}
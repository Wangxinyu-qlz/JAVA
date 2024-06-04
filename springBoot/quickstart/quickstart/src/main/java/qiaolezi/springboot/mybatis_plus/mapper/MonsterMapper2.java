package qiaolezi.springboot.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import qiaolezi.springboot.mybatis_plus.bean.Monster2;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:20
 * @description:
 * * 1. BaseMapper 已经默认提供了很多crud 方法，可以直接用
 * * 2. 如果BaseMapper 提供的方法不满足需要，可以再开发MonsterMapper.xml
 **/
@Mapper
public interface MonsterMapper2 extends BaseMapper<Monster2> {
}

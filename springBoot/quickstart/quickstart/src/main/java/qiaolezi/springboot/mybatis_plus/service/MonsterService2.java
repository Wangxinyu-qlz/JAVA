package qiaolezi.springboot.mybatis_plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import qiaolezi.springboot.mybatis_plus.bean.Monster2;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:24
 * @description:
 * * 1. IService 提供了很多crud 方法, 底层调用的是BaseMapper 的方法
 * * 2. 如果默认提供的方法，不能满足需求，再开发需要的方法即可
 **/
public interface MonsterService2 extends IService<Monster2> {
}

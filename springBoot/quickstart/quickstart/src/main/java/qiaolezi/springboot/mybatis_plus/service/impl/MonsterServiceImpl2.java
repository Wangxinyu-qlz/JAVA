package qiaolezi.springboot.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import qiaolezi.springboot.mybatis_plus.bean.Monster2;
import qiaolezi.springboot.mybatis_plus.mapper.MonsterMapper2;
import qiaolezi.springboot.mybatis_plus.service.MonsterService2;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-06-04 22:25
 * @description:
 **/
@Service
public class MonsterServiceImpl2
		extends ServiceImpl<MonsterMapper2, Monster2>
		implements MonsterService2 {}

package qiaolezi.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import qiaolezi.springboot.bean.Furn;
import qiaolezi.springboot.mapper.FurnMapper;
import qiaolezi.springboot.service.FurnService;

/**
 * @program: springboot-furn
 * @author: Qiaolezi
 * @create: 2024-06-05 10:34
 * @description:
 **/
@Service
public class FurnServiceImpl
		extends ServiceImpl<FurnMapper, Furn>
		implements FurnService {}

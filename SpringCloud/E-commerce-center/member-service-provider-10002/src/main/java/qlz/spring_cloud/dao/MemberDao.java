package qlz.spring_cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import qlz.spring_cloud.entity.Member;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 17:45
 * @description:
 **/
@Mapper
public interface MemberDao {
	Member queryMemberById(Long id);
	int save(Member member);
}

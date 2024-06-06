package qlz.spring_cloud.service;

import org.springframework.stereotype.Service;
import qlz.spring_cloud.entity.Member;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 17:59
 * @description:
 **/
public interface MemberService {
	//id -> member
	Member queryMemberById(long id);

	//insert member
	int save(Member member);
}

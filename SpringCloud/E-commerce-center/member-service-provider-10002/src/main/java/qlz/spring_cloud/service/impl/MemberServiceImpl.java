package qlz.spring_cloud.service.impl;

import org.springframework.stereotype.Service;
import qlz.spring_cloud.dao.MemberDao;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.service.MemberService;

import javax.annotation.Resource;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 18:00
 * @description:
 **/
@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDao memberDao;

	@Override
	public Member queryMemberById(long id) {
		return memberDao.queryMemberById(id);
	}

	@Override
	public int save(Member member) {
		return memberDao.save(member);
	}
}

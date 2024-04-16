package main.spring.service;

import main.spring.dao.MemberDAOImplement;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-07 10:56
 * @description:
 **/
public class MemberService {
	private MemberDAOImplement memberDAOImplement;

	public MemberService() {
		//System.out.println("MemberService() 无参构造器被执行");
	}

	public MemberDAOImplement getMemberDAOImplement() {
		return memberDAOImplement;
	}

	public void setMemberDAOImplement(MemberDAOImplement memberDAOImplement) {
		//System.out.println("setMemberDAOImplement()......");
		this.memberDAOImplement = memberDAOImplement;
	}

	public void add() {
		memberDAOImplement.add();
		//System.out.println("MemberDAOImplement::add()方法被调用");
	}
}

package qlz.sprong_cloud;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import qlz.spring_cloud.MainApp;
import qlz.spring_cloud.dao.MemberDao;
import qlz.spring_cloud.entity.Member;
import qlz.spring_cloud.service.MemberService;

import javax.annotation.Resource;

/**
 * @program: E-commerce-center
 * @author: Qiaolezi
 * @create: 2024-06-05 17:49
 * @description:
 **/
@SpringBootTest(classes = MainApp.class)
public class AppTests {
	private static final Logger log = LoggerFactory.getLogger(AppTests.class);
	@Resource
	private MemberDao memberDao;
	@Resource
	private MemberService memberService;

	@Test
	public void queryMemberById() {
		Member member = memberDao.queryMemberById(1L);
		log.info("member={}", member);
	}

	@Test
	public void save() {
		Member member = new Member(null, "牛魔", "123", "13000000000", "qwe@ww.com", 1);
		int save = memberDao.save(member);
		log.info("save={}", save);
	}

	@Test
	public void queryMemberById_() {
		Member member = memberService.queryMemberById(1L);
		log.info("member={}", member);
	}

	@Test
	public void save_() {
		Member member = new Member(null, "牛魔", "123", "13000000000", "qwe@ww.com", 1);
		int save = memberService.save(member);
		log.info("save={}", save);
	}
}

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import top.robotman.myblog.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/spring-config.xml"})
@Transactional
public class TestUsermapper {

	@Autowired
	private UserMapper ump;
	
	@Test
	public void regist() {
		
		assertEquals(1, ump.registUser("zq3", "q"));
	}
	
	@Test
	public void qurey() {
		
		assertNotNull(ump.qureyUser("zq1"));
	}
	
	
}

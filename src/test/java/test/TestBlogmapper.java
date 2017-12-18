package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import top.robotman.myblog.mapper.BlogMapper;
import top.robotman.myblog.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/spring-config.xml"})
@Transactional
public class TestBlogmapper {
	@Autowired
	private BlogMapper bmp;
	
//	@Test
//	public void regist() {
//		System.out.println(bmp.getBlogList("zz", 0, 5));
//		assertNotNull(bmp.getBlogList("zz", 0, 5));
//	}
//	
//	@Test
//	public void getBlogNum() {
//		System.out.println(bmp.getBlogNum("zz"));
//		assertEquals((Integer)3, bmp.getBlogNum("zz"));
//	}
//	
	@Test
	public void write() {
		//System.out.println("======"+bmp.writeBlog("zz1", "zz1", "zz1", 7));
		
		assertEquals(1,bmp.writeBlog("xx", "xx", "xx", 1));
	}

}

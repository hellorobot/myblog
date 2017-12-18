package top.robotman.myblog.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import top.robotman.myblog.domain.Blog;
import top.robotman.myblog.excepetion.BizExcepetion;
import top.robotman.myblog.flippage.FlipPage;
import top.robotman.myblog.mapper.BlogMapper;
import top.robotman.myblog.service.BlogService;
@Component
public class BlogServiceimpl implements BlogService{
	@Autowired
	private BlogMapper bmp;

	@Override
	public FlipPage qureyBlog(String username,int currentPage) {
		FlipPage flippage = new FlipPage();
		List<Blog> blogList = bmp.getBlogList(username, flippage.getStartNum(currentPage), FlipPage.EVERY_PAGE_FLOW_NUM);
		Integer blogNum = bmp.getBlogNum(username);
		
		FlipPage flp = new FlipPage();
		flp.setObj(blogList);
		flp.setPagesNumxxx(blogNum);
		return flp;
	}

	@Override
	public int addBlog(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBlog(int id) {	
		return bmp.deleteBlogByid(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int writeBlog(String title, String content, String username) {

		if(!StringUtils.isNotBlank(title)) {
			throw new BizExcepetion("标题不能为空");
		}
		
		if(!StringUtils.isNotBlank(content)) {
			throw new BizExcepetion("内容不能为空");
		}
		
		int blogNum = bmp.getBlogNum(username);
		
		return bmp.writeBlog(title, content, username, blogNum+1);
	}

	@Override
	public int modifyBlog(int id, String title, String content) {
		
		if(!StringUtils.isNotBlank(title)) {
			throw new BizExcepetion("标题不能为空");
		}
		
		if(!StringUtils.isNotBlank(content)) {
			throw new BizExcepetion("内容不能为空");
		}
		
		if(id <= 0) {
			throw new BizExcepetion("id异常ERROR");
		}
			
		return bmp.modifyBlog(title, content, id);
	}

	@Override
	public Blog getBlog(int id) {
		if(id <= 0) {
			throw new BizExcepetion("id异常ERROR");
		}	
		return bmp.getBlog(id);
	}
	
	

}

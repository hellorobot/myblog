package top.robotman.myblog.service;

import java.util.List;

import top.robotman.myblog.domain.Blog;
import top.robotman.myblog.flippage.FlipPage;

public interface BlogService {
	public FlipPage qureyBlog(String username,int currentPage);
	
	public int addBlog(String username);
	
	public int deleteBlog(int id);
	
	public int writeBlog(String title,String content,String username);
	
	public int modifyBlog(int id,String title,String content);
	
	public Blog getBlog(int id);

}

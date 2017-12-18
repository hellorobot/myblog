package top.robotman.myblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.robotman.myblog.domain.Blog;

public interface BlogMapper {
	List<Blog> getBlogList(@Param("username") String username, @Param("startPoint") int startPoint,
			@Param("moveLength") int MoveLength);

	Integer getBlogNum(String username);

	int deleteBlogByid(int id);

	 int writeBlog(@Param("title")String title, @Param("content")String content,
			@Param("username")String username, @Param("blogid")int blogid);
	 
	 Blog getBlog(int id);
	 
	 int modifyBlog(@Param("title")String title, @Param("content")String content, @Param("id")int id);

}

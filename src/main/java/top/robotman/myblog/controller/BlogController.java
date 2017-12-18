package top.robotman.myblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.robotman.myblog.ajaxdto.AjaxDto;
import top.robotman.myblog.domain.Blog;
import top.robotman.myblog.domain.User;
import top.robotman.myblog.excepetion.BizExcepetion;
import top.robotman.myblog.service.impl.BlogServiceimpl;

@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController{
	@Autowired
	private BlogServiceimpl blogService;
	
	@RequestMapping("/delete")
	public String deleteBlog(int id) {
		int rows = blogService.deleteBlog(id);
		
		return "userCenter";
	}
	
	@RequestMapping("/toWrite")
	public String toWrite() {		
		return "writeBlog";
	}
	
	@RequestMapping("/commitBlog")
	@ResponseBody
	public AjaxDto commitBlog(String title,String content,HttpSession session)throws BizExcepetion{

		User user =  (User)session.getAttribute("user");
		int rows = blogService.writeBlog(title,content,user.getUsername());
		
		return AjaxDto.success("提交成功");
	}
	
	@RequestMapping("/toModify")
	public String toModify(int id,HttpServletRequest req) {
		System.out.println("xxxxxxx"+id);
		
		Blog blog = blogService.getBlog(id);
		req.setAttribute("blog", blog);
		
		return "modifyBlog";
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public AjaxDto modify(String title,String content,int id) {

		int rows = blogService.modifyBlog(id, title, content);
		
		return AjaxDto.success("修改成功");
	}
	
	


}

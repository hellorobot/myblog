package top.robotman.myblog.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.robotman.myblog.ajaxdto.AjaxDto;
import top.robotman.myblog.domain.Blog;
import top.robotman.myblog.domain.User;
import top.robotman.myblog.flippage.FlipPage;
import top.robotman.myblog.service.impl.BlogServiceimpl;
import top.robotman.myblog.service.impl.UserServiceimpl;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserServiceimpl userService;
	@Autowired
	private BlogServiceimpl blogService;
	
	@RequestMapping("/toRegist")
	public void toRegist(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/regist.jsp").forward(req, resp);
	}
	
	@RequestMapping("/toLogin")
	public void toLogin(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public AjaxDto regist(String username,String password) throws ServletException, IOException {
		
		int rows = userService.regist(username, password);
		
		return AjaxDto.success(""+rows);
	}
	
	@RequestMapping("/toUserCenter")
	public void toUserCenter(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/userCenter.jsp").forward(req, resp);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxDto login(String username,String password,HttpSession session) {
		User user = userService.login(username, password);
		session.setAttribute("user", user);
		return AjaxDto.success("");
	}
	
	@RequestMapping("/loadBlogList")
	@ResponseBody
	public AjaxDto loadBlogList(String username,int currentPage,HttpSession session) {
		User user = (User)session.getAttribute("user");
		FlipPage flp =  blogService.qureyBlog(user.getUsername(), currentPage);
		//System.out.println("=======num"+flp.getPagesNum());

		return AjaxDto.success(flp);
	}

	

}

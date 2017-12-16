package top.robotman.myblog.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.robotman.myblog.ajaxdto.AjaxDto;
import top.robotman.myblog.service.impl.UserServiceimpl;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserServiceimpl userService;
	
	@RequestMapping("/toRegist")
	public void toRegist(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/regist.jsp").forward(req, resp);
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public AjaxDto regist(String username,String password) throws ServletException, IOException {
		
		int rows = userService.regist(username, password);
		
		return AjaxDto.success(""+rows);
	}
	

}

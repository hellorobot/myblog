package top.robotman.myblog.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import top.robotman.myblog.domain.User;
@Controller
@RequestMapping("/userinf")
public class UserInform extends BaseController{
	
	
	@RequestMapping("/toUpload")
	public String toUpload1() {
		return "upload";
	}
	
	@RequestMapping("/uploadImg")
	public String uploadImg(MultipartFile upfile, HttpServletRequest req, HttpSession session) {	
		try {
			if (!upfile.isEmpty()) {
	
				User user = (User)session.getAttribute("user");
				
				String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload/"+user.getUsername()+".png");
				
				File file = new File(path);
				System.out.println(file.getPath());
	            upfile.transferTo(file);
	        }
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "userCenter";
	}

}

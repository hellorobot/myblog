package top.robotman.myblog.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.robotman.myblog.ajaxdto.AjaxDto;
import top.robotman.myblog.excepetion.BizExcepetion;

public class BaseController {
	
	@ExceptionHandler(BizExcepetion.class)
	@ResponseBody
	public AjaxDto handlerBizException(BizExcepetion be) {
		return AjaxDto.faild(be.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public AjaxDto handlerException(Exception e) {	
		System.out.println("【【ERROE！！！】】" + e.getStackTrace());
		System.out.println("【【ERROE！！！】】" + e.getMessage());
		return AjaxDto.faild("操作失败，请联系客服");
	}

}

package top.robotman.myblog.ajaxdto;

public class AjaxDto {
	private boolean flag;
	private String message;
	private Object data;
	private int statusCode;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public static AjaxDto faild(String msg) {
		AjaxDto dto = new AjaxDto();
		dto.setFlag(false);
		dto.setMessage(msg);
		return dto;
	}
	
	public static AjaxDto success(String msg) {
		AjaxDto dto = new AjaxDto();
		dto.setFlag(true);
		dto.setMessage(msg);
		return dto;
	}
	
	public static AjaxDto success(Object obj) {
		AjaxDto dto = new AjaxDto();
		dto.setFlag(true);
		dto.setData(obj);
		return dto;
	}
	

}

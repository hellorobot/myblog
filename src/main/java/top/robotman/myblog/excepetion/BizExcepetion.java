package top.robotman.myblog.excepetion;

public class BizExcepetion extends RuntimeException{
	private static final long serialVersionUID = -4998348346486897664L;

	public BizExcepetion() {
		
	}
	
	public BizExcepetion(String errorMsg) {
		super(errorMsg);
	}

}

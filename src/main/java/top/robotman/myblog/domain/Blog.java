package top.robotman.myblog.domain;

import java.util.Date;

public class Blog {
	private Integer id;
	private String title;
	private String content;	
	private String username;
	private Date createtime;
	private Date modifytime;
	private Integer blogid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	public Integer getBlogid() {
		return blogid;
	}
	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return blogid+"---"+title+"---"+username+"---"+modifytime;
	}

}

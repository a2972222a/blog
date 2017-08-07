package entity;

import java.util.Date;

/**
 * @author 秦晓阳
 * 文章表
 */
public class Article {
	//id,int
	private int id;
	//题目,varchar(50)
	private String title;
	//内容,longtext
	private String content;
	//发布时间,Date
	private Date time;
	//标签,varchar(20)
	private String tag;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Article(){}
}

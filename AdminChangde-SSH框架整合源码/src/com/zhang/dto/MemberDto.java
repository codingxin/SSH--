package com.zhang.dto;
import java.util.Date;


//时间前端传到后端为字符串 ，MemberDto提供接收前端传回来的各项参数。
public class MemberDto {
	private Integer id;
	private String place;
	private String title;
	private String extra;
    private String  updatetime;
    
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
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
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", title=" + title + ", extra=" + extra + ", updatetime=" + updatetime + "]";
	}
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

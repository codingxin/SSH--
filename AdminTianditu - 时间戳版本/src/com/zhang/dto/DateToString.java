package com.zhang.dto;
import java.util.Date;

public class DateToString {
	private int id;
	private String title;
	private String extra;
    private Date timestamp;
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
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", title=" + title + ", extra=" + extra + ", timestamp=" + timestamp + "]";
	}
    
    
}

package com.zhang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "changsha")
public class Changsha implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String place;
	private String title;
	private String extra;
    private Date updatetime;
  

	public Changsha() {
	}

	public Changsha(String place,String title, String extra,Date updatetime) {
		super();
		this.title = title;
		this.extra = extra;
		this.updatetime=updatetime;
	}

	public Changsha(int id,String place,String title, String extra,Date updatetime) {
		super();
		this.id=id;
		this.place=place;
		this.title = title;
		this.extra = extra;
		this.updatetime=updatetime;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	@Column(name = "title", nullable = true, length = 30)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "extra", nullable = true, length = 30)
	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	@Column(name = "timestamp", nullable = true, length = 100)
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}

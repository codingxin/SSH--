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
@Table(name = "admin_changde")
public class Changde implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String extra;
    private Date updatetime;

	public Changde() {
	}

	public Changde(String title, String extra,Date update_time) {
		super();
		this.title = title;
		this.extra = extra;
		this.updatetime=update_time;
	}

	public Changde(Integer id, String title, String extra,Date update_time) {
		super();
		this.id = id;
		this.title = title;
		this.extra = extra;
		this.updatetime=update_time;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	@Column(name = "update_time", nullable = true, length = 100)
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Changde [id=" + id + ", title=" + title + ", extra=" + extra + ", updatetime=" + updatetime + "]";
	}
	
	
	
}

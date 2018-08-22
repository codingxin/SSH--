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
@Table(name = "admin")
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String password;
	private String mobile;
	private String email;
	//角色信息
	private String extra;

	public Admin() {
		super();
	}

	public Admin(int id, String userName, String password, String mobile, String email, String extra) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.extra = extra;
	}

	public Admin(String userName, String password, String mobile, String email, String extra) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.extra = extra;
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

	/**
	 * name name属性定义了被标注字段在数据库表中所对应字段的名称；
	 * 
	 * unique
	 * unique属性表示该字段是否为唯一标识，默认为false。如果表中有一个字段需要唯一标识，则既可以使用该标记，也可以使用@Table标记中的@UniqueConstraint。
	 * 
	 * nullable nullable属性表示该字段是否可以为null值，默认为true。
	 * 
	 * insertable insertable属性表示在使用“INSERT”脚本插入数据时，是否需要插入该字段的值。
	 * 
	 * updatable
	 * updatable属性表示在使用“UPDATE”脚本插入数据时，是否需要更新该字段的值。insertable和updatable属性一般多用于只读的属性，例如主键和外键等。这些字段的值通常是自动生成的。
	 * 
	 * columnDefinition
	 * columnDefinition属性表示创建表时，该字段创建的SQL语句，一般用于通过Entity生成表定义时使用。（也就是说，如果DB中表已经建好，该属性没有必要使用。）
	 * 
	 * table table属性定义了包含当前字段的表名。
	 * 
	 * length length属性表示字段的长度，当字段的类型为varchar时，该属性才有效，默认为255个字符。
	 * 
	 * precision和scale
	 * 
	 * @return
	 */
	@Column(name = "username", nullable = false, length = 64)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mobile", nullable = false, length = 11)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", nullable = false, length = 64)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "extra", nullable = false, length = 256)
	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	
}

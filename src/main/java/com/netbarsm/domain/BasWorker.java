package com.netbarsm.domain;


import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @author liutong
 * @date 2022-03-02
 * @version 1.0.0
 * @Copyright
 */
@Data
@Table(name = "bas_worker")
public class BasWorker implements Serializable {

	/**
	 * id
	 */
	@Id
	@Column( name = "worker_id")
	private Integer workerId;

	/**
	 * 名字
	 */
	@Column( name = "name")
	private String name;

	/**
	 * 密码
	 */
	@Column( name = "password")
	private String password;

	/**
	 * 电话
	 */
	@Column( name = "telephone")
	private String telephone;

	/**
	 * 邮箱
	 */
	@Column( name = "email")
	private String email;

	/**
	 * 是否有效  0无效 1有效
	 */
	@Column( name = "is_valid")
	private Integer isValid;

	/**
	 * 用户类别
	 */
	@Column( name = "user_type")
	private Integer userType;

	/**
	 * 注册时间
	 */
	@Column( name = "register_time")
	private Date registerTime;

	/**
	 * 修改时间
	 */
	@Column( name = "update_time")
	private Date updateTime;


}

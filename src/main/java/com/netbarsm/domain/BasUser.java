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
@Table(name = "bas_user")
public class BasUser implements Serializable {

	/**
	 * 用户id(身份证号)  
	 */
	@Id
	@Column( name = "user_id")
	private String userId;

	/**
	 * 用户名
	 */
	@Column( name = "name")
	private String name;

	/**
	 * 用户密码(登录密码，上级密码)
	 */
	@Column( name = "password")
	private String password;

	/**
	 * 手机号
	 */
	@Column( name = "telephone")
	private String telephone;

	/**
	 * 邮箱
	 */
	@Column( name = "email")
	private String email;

	/**
	 * 是否有效用户  0无效 1有效
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

	/**
	 * 是否是会员用户  0不是 1是
	 */
	@Column( name = "is_member")
	private String isMember;

	/**
	 * 会员卡余额
	 */
	@Column( name = "balance")
	private Long balance;


}

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
@Table(name = "equipment")
public class Equipment implements Serializable {

	/**
	 * 设备id
	 */
	@Id
	@Column( name = "equipment_id")
	private Integer equipmentId;

	/**
	 * 设备名
	 */
	@Column( name = "equipment_name")
	private String equipmentName;

	/**
	 * 设备类型 0:主机 1:显示屏 2:键盘 2:鼠标 3:耳机 4:电竞椅
	 */
	@Column( name = "equipment_type")
	private Integer equipmentType;

	/**
	 * 设备原价
	 */
	@Column( name = "equipment_price")
	private Long equipmentPrice;

	/**
	 * 设备套组ID
	 */
	@Column( name = "set_id")
	private Integer setId;

	/**
	 * 开始使用日期
	 */
	@Column( name = "start_date")
	private Date startDate;


}

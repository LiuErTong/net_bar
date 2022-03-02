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
@Table(name = "equipment_set")
public class EquipmentSet implements Serializable {

	/**
	 * 套组ID
	 */
	@Id
	@Column( name = "equipment_set_id")
	private Integer equipmentSetId;

	/**
	 * 摆放位置
	 */
	@Column( name = "equipment_set_position")
	private String equipmentSetPosition;


}

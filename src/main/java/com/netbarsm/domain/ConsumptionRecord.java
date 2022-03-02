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
@Table(name = "consumption_record")
public class ConsumptionRecord implements Serializable {

	/**
	 * id
	 */
	@Id
	@Column( name = "record_id")
	private Integer recordId;

	/**
	 * 身份证号
	 */
	@Column( name = "user_id")
	private Integer userId;

	/**
	 * 消费类型 0:临时卡 1:会员卡
	 */
	@Column( name = "card_type")
	private Integer cardType;

	/**
	 * 金额
	 */
	@Column( name = "amount")
	private Long amount;

	/**
	 * 操作人员id
	 */
	@Column( name = "operator_id")
	private Integer operatorId;


}

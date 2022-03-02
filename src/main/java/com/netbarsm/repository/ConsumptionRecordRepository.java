package com.netbarsm.repository;


import com.netbarsm.domain.ConsumptionRecord;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
import org.apache.ibatis.annotations.Insert;
import java.util.List;

/**
 * @Description
 * @author liutong
 * @date 2022-03-02
 * @version 1.0.0
 * @Copyright
 */
@Mapper
public interface ConsumptionRecordRepository extends BaseMapper<ConsumptionRecord>,InsertListMapper<ConsumptionRecord>{
	/**
	* @Description     重写insertList方法，原方法需要主键自增且主键名是"id"
	*/
	@Override
	@Insert({
		"<script>",
		"INSERT INTO consumption_record (record_id,user_id,card_type,amount,operator_id) VALUES",
		"<foreach collection='list' item='item' separator=','>",
		"(#{item.recordId},#{item.userId},#{item.cardType},#{item.amount},#{item.operatorId})",
		"</foreach>",
		"</script>"
	})
	int insertList(List<? extends ConsumptionRecord> list);

}

package com.netbarsm.repository;


import com.netbarsm.domain.Equipment;
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
public interface EquipmentRepository extends BaseMapper<Equipment>,InsertListMapper<Equipment>{
	/**
	* @Description     重写insertList方法，原方法需要主键自增且主键名是"id"
	*/
	@Override
	@Insert({
		"<script>",
		"INSERT INTO equipment (equipment_id,equipment_name,equipment_type,equipment_price,set_id,start_date) VALUES",
		"<foreach collection='list' item='item' separator=','>",
		"(#{item.equipmentId},#{item.equipmentName},#{item.equipmentType},#{item.equipmentPrice},#{item.setId},#{item.startDate})",
		"</foreach>",
		"</script>"
	})
	int insertList(List<? extends Equipment> list);

}

package com.netbarsm.repository;


import com.netbarsm.domain.EquipmentSet;
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
public interface EquipmentSetRepository extends BaseMapper<EquipmentSet>,InsertListMapper<EquipmentSet>{
	/**
	* @Description     重写insertList方法，原方法需要主键自增且主键名是"id"
	*/
	@Override
	@Insert({
		"<script>",
		"INSERT INTO equipment_set (equipment_set_id,equipment_set_position) VALUES",
		"<foreach collection='list' item='item' separator=','>",
		"(#{item.equipmentSetId},#{item.equipmentSetPosition})",
		"</foreach>",
		"</script>"
	})
	int insertList(List<? extends EquipmentSet> list);

}

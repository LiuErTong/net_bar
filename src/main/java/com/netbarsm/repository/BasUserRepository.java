package com.netbarsm.repository;


import com.netbarsm.domain.BasUser;
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
public interface BasUserRepository extends BaseMapper<BasUser>,InsertListMapper<BasUser>{
	/**
	* @Description     重写insertList方法，原方法需要主键自增且主键名是"id"
	*/
	@Override
	@Insert({
		"<script>",
		"INSERT INTO bas_user (user_id,name,password,telephone,email,is_valid,user_type,register_time,update_time,is_member,balance) VALUES",
		"<foreach collection='list' item='item' separator=','>",
		"(#{item.userId},#{item.name},#{item.password},#{item.telephone},#{item.email},#{item.isValid},#{item.userType},#{item.registerTime},#{item.updateTime},#{item.isMember},#{item.balance})",
		"</foreach>",
		"</script>"
	})
	int insertList(List<? extends BasUser> list);

}

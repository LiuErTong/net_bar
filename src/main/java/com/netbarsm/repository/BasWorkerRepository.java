package com.netbarsm.repository;


import com.netbarsm.domain.BasWorker;
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
public interface BasWorkerRepository extends BaseMapper<BasWorker>,InsertListMapper<BasWorker>{
	/**
	* @Description     重写insertList方法，原方法需要主键自增且主键名是"id"
	*/
	@Override
	@Insert({
		"<script>",
		"INSERT INTO bas_worker (worker_id,name,password,telephone,email,is_valid,user_type,register_time,update_time) VALUES",
		"<foreach collection='list' item='item' separator=','>",
		"(#{item.workerId},#{item.name},#{item.password},#{item.telephone},#{item.email},#{item.isValid},#{item.userType},#{item.registerTime},#{item.updateTime})",
		"</foreach>",
		"</script>"
	})
	int insertList(List<? extends BasWorker> list);

}

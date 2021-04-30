package com.pomzwj.trans.dao;

import com.pomzwj.trans.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
public interface UserInfoMapper {

	/**
	 * 插入
	 * @param record
	 * @return
	 */
	@Insert("insert into user_info(id, `name`) values (#{id}, #{name})")
	int insert(UserInfo record);
}

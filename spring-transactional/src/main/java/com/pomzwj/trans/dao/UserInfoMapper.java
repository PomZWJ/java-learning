package com.pomzwj.trans.dao;

import com.pomzwj.trans.entity.UserInfo;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
public interface UserInfoMapper {
	/**
	 * 根据主键删除
	 * @param userId
	 * @return
	 */
	int deleteByPrimaryKey(String userId);

	/**
	 * 插入
	 * @param record
	 * @return
	 */
	int insert(UserInfo record);

	/**
	 * 选择性插入
	 * @param record
	 * @return
	 */
	int insertSelective(UserInfo record);

	/**
	 * 根据主键查询
	 * @param userId
	 * @return
	 */
	UserInfo selectByPrimaryKey(String userId);

	/**
	 * 选择性更新
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(UserInfo record);

	/**
	 * 根据主键更新
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(UserInfo record);
}

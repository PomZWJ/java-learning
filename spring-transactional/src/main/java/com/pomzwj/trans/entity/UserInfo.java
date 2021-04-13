package com.pomzwj.trans.entity;

import java.io.Serializable;

/**
 * @author zhaowj
 * @date 2021-04-13
 */
public class UserInfo implements Serializable {

	private String userId;

	private String userName;

	private String createDate;

	private String createTime;

	private String iconUrl;
	/**
	 * 账户状态
	 * 0--正常
	 * 1--注销
	 * 2--冻结
	 */
	private String accountStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}

package com.tea.user.common;

public class UIConstants {
	public static final String PCWEBSESSIONUIDKEY = "pc_session_uid";
	
	public static final String PCWEBSESSIONTOKENKEY = "pc_session_token";
	
	public static final String TOKEN = "pc_token";
	
	/**
	 * 用户id作为唯一标识，在缓存中保存用户对象信息
	 */
	public static final String XSESSION_USER_USERID_KEY = "user_session_userid_";
	
	/**
	 * 手机号码作为唯一标识，在缓存中保存用户对象信息
	 */
	public static final String XSESSION_USER_MOBILE_KEY = "user_session_mobile_";
	
	/**
	 * 用户名作为唯一标识，在缓存中保存用户对象信息
	 */
	public static final String XSESSION_USER_USERNAME_KEY = "user_session_username_";
	
	/**
	 * @category 查id列表信息Key
	 */
	public static final String XSESSION_USER_IDS_KEY = "user_session_ids_";
	
	/**
	 * @category 平台用户数
	 */
	public static final String XSESSION_USER_USERDATA_KEY = "platform_user_data";
	
	
	public static final String XSESSION_SAFEDATA_KEY = "platform_safedate";
	
	
	public static final String XSESSION_USERS_EARN_KEY = "platform_usersearn";
	
	public static final String XSESSION_CUMTURNOVER_KEY = "platform_cumturnover";
	
	/**
	 * @category 用户总数zk节点
	 */
	public static final String USER_ZK_USERDATA_KEY = com.tea.common.base.constant.Constants.YunWei + "/platform/initdata/totalUsers";
	
	public static final String USER_ZK_SAFEDATA_KEY = com.tea.common.base.constant.Constants.YunWei + "/platform/initdata/safedate";
	
	
	public static final String USER_ZK_USERS_EARN_KEY = com.tea.common.base.constant.Constants.YunWei + "/platform/initdata/platformUsersearn";
	
	public static final String USER_ZK_CUMTURNOVER_KEY = com.tea.common.base.constant.Constants.YunWei + "/platform/initdata/cumturnover";
	
	public static final int SESSION_TIMEOUT = 30 * 60;
	
	//emptyContract.html
	public static final int CONTRACT_TYPE = 1;
	
	//emptyContractNoGrarantee.html
	public static final int CONTACT_NO_GUARANTEE_TYPE = 2;
	
	//emptyFinancePlanContract.html
	public static final int FINANCEPLAN_CONTACT_TYPE = 3;
	
	//emptyTransferContract.html
	public static final int TRANSFER_CONTACT_TYPE = 4;
	
	//finanicalPlanProductLabeling.html
	public static final int FINANCIALPLAN_PRODUCT_CONTACT_TYPE = 5;
	
	//zyxr_webserivce.html
	public static final int ZYXR_WEBSERVICE_TYPE = 6;

}

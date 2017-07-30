package com.tea.user.common;

public class ErrorCode {

	/**
	 * @category 操作成功
	 */
	public static final int SUCCESS = 0;
	
	/**
	 * @category 验证身份证超过限制次数
	 */
	public static final int IDCARD_USER_VERIFY_TOO_MUCH = 10000001;
	
	/**
	 * @category 服务没找到
	 */
	public static final int IDCARD_SERVICE_NOT_FOUND = 10000002;
	
	/**
	 * 缺少参数
	 */
	public static final int MISSING_PARAM = 10000003;
	
	/**
	 * 用户未找到
	 */
	public static final int USER_NOT_FOUND = 10000004;
	
	/**
	 *系统异常 
	 */
	public static final int USER_SYSTEM_EXCEPTION = 10000005;
	
	/**
	 *系统查询异常 
	 */
	public static final int USER_SYSTEM_QUERY_EXCEPTION = 10000006;

	/**
	 * 原密码不一致
	 */
	public static final int PWD_NOT_MATCH = 10000007;
	
	/**
	 * 修改失败，请稍后重试
	 */
	public static final int UPDATE_FAILURE = 10000008;
	
	/**
	 * 修改密码失败，请稍后重试
	 */
	public static final int UPDATE_PWD_FAILURE = 10000009;
	
	/**
	 * 重置密码失败，请稍后重试
	 */
	public static final int RESET_PWD_FAILURE = 10000010;
	
	/**
	 * 用户名或密码错误
	 */
	public static final int USERNAME_PWD_ERROR = 10000011;

	/**
	 * 用户名不能为空
	 */
	public static final int USERNAME_NOT_NULL = 10000012;

	/**
	 * 密码不能为空
	 */
	public static final int PWD_NOT_NULL = 10000013;
	
	/**
	 * 手机号码不能为空
	 */
	public static final int MOBILE_NOT_NULL = 10000014;
	
	/**
	 * 手机号码格式不正确
	 */
	public static final int MOBILE_FORMAT_ERROR = 10000015;

	/**
	 * 未找到该邀请人
	 */
	public static final int INVITOR_NOT_FOUND = 10000016;

	/**
	 * 该手机号码已被注册
	 */
	public static final int MOBILE_ALLREADY_EXIST = 10000017;

	/**
	 * 注册失败，请稍后重试
	 */
	public static final int REGISTER_FAILURE = 10000018;
	
	/**
	 * 实名认证失败
	 */
	public static final int IDCARD_VERIFY_FAILURE = 10000019;

	/**
	 * 该账户已被锁定
	 */
	public static final int USER_LOCK = 10000020;
	
	/**
	 * 原密码不能为空
	 */
	public static final int OLD_PWD_NOT_NULL = 10000021;
	
	/**
	 * 新密码不能为空
	 */
	public static final int NEW_PWD_NOT_NULL = 10000022;

	/**
	 * 密码格式不正确
	 */
	public static int PWD_FORMAT_ERROR = 10000023;

	/**
	 * 此用户已实名，请重新输入实名信息
	 */
	public static final int IDCARD_ALLREADY_VERIFY = 10000024;

	/**
	 * 证件号不能为空
	 */
	public static final int IDCARD_NOT_NULL = 10000025;

	/**
	 * 姓名不能为空
	 */
	public static final int IDCARD_REALNAME_NOT_NULL = 10000026;
	
	/**
	 * 证件类型不能为空
	 */
	public static final int IDCARDTYPE_NOT_NULL = 10000027;
	
	/**
	 * 该用户已实名认证，无法再次认证
	 */
	public static final int THE_USER_ALLREADY_IDCARD_VERIFY = 10000028;
	
	/**
	 * 添加失败，请稍后重试
	 */
	public static final int ADD_FAILURE = 10000029;
	
	/**
	 * 未找到对应记录
	 */
	public static final int NOT_FOUND_RECORD = 10000030;
	
	/**
	 * 名称不能为空
	 */
	public static final int  NAME_NOT_NULL = 10000031;

	/**
	 * 请您填写完整的地区信息
	 */
	public static final int FUALL_ADDRESS_NOT_NULL = 10000032;

	/**
	 * 请您填写收货人详细地址
	 */
	public static final int ADDRESS_NOT_NULL = 10000033;

	/**
	 * 请您填写收货人联系方式
	 */
	public static final int CONTACT_WAY_NOT_NULL = 10000034;
	
	
	/**
	 * 账户被锁定
	 */
	public static final int UPDATE_USER_LOCK = 10000036;

	
	//------------------------需要新添加
	/**
	 * 原密码错误
	 */
	public static final int OLD_PWD_ERROR = 10000037;

	/**
	 * 该用户已被注销
	 */
	public static final int BLACK_STATUS = 10000038;
	
	/**
	 * 该账户已被锁定
	 */
	public static final int DEL_STATUS = 10000039;
	
	/**
	 * 用户账户处于非正常状态，无法进行开户
	 */
	public static final int USER_ACCOUNT_INVAILD = 10000040;

	/**
	 * 请选择开户行
	 */
	public static final int CHOOSE_BANK = 10000041;

	/**
	 * 银行卡号不能为空
	 */
	public static final int BANKCARDNO_NOT_NULL = 10000042;

	/**
	 * 请填写开户行所在地
	 */
	public static final int OPEN_BANK_ADD_NOT_NULL = 10000043;

	/**
	 * 交易密码不能为空
	 */
	public static final int TRADE_PWD_NOT_NULL = 10000044;

	/**
	 * 证件号码格式错误
	 */
	public static final int IDCARD_FORMAT_ERROR = 10000045;

	/**
	 * 开户失败
	 */
	public static final int OPEN_ACCOUNT_FAILURE = 10000046;
	
	/**
	 * 请登录
	 */
	public static final int USER_NOT_LOGIN = 10000047;
	
	/**
	 * 请求非法
	 */
	public static final int ILLEGAL_REQ = 10000048;

	/**
	 * 新密码与原密码不能一致
	 */
	public static final int OLDPWD_EQ_NEWPWD = 10000049;
	
	/**
	 * 新密码与上次密码不能一样
	 */
	public static final int OLD_PWD_EQ_NEWPWD = 10000050;
	
	/**
	 * 该用户已开通托管账户
	 */
	public static final int THE_USER_OPEN_FY = 10000051;

	/**
	 * 该用户不允许登录
	 */
	public static final int THE_USER_NOT_LOGIN = 10000052;
	
	public static final int LOGIN_ON_OTHER_DEVICE = 10000053;
	
	/**查询用户好友列表异常*/
	public static final int FIND_USER_FRIENDLIST_EXCEPTION = 10000054;

	public static void main(String[] args) {
		for(int i = 10000001; i < 10000049; i++){
			System.out.println(i+"=");
		}
	}
	
	
	/**
	 * 用户操作流水添加异常
	 */
	public static final int USER_OPERATEFLOW_ADD_EXCEPTION = 10000054;
	
	/**
	 * 同步用户开户调单异常
	 */
	public static final int SYNC_USER_OPENACCOUNT_TIMEOUT_EXCEPTION = 10000055;
	
	/**
	 * 同步用户开户历史调单异常
	 */
	public static final int SYNC_USER_OPENACCOUNT_HISTORY_TIMEOUT_EXCEPTION = 10000056; 
	
	
	/**
	 * 获取账户信息异常
	 */
	public static final int GET_ACCOUNTINFO_BY_USERID_EXCEPTION = 10000057;
	
	
	/**
	 * 获取账户信息异常
	 */
	public static final int QUERY_LAST_REQUEST_ORDER_EXCEPTION = 10000058;
}

package com.andios.tourism.enu;


/**
 * 返回状态枚举
 */
public enum ResponseEnum {
	SUCCESS("SUCCESS","成功"),
	FAIL("FAIL","失败"),
	YJLR("YJLR","已经录入"),
	LRCG("LRCG","录入成功"),
	GXCG("GXCG","更新成功"),
	SQCG("SQCG","删除成功"),
	check("check","验证码错误"),
	ZWSJ("ZWSJ","暂无数据"),
	MYSXTJ("MYSXTJ","请输入筛选条件"),
	LOGINFAIL("LOGINFAIL","登录失败,请输入正确的账号！"),
	;
	private String code;
	private String msg;


	ResponseEnum(String code, String msg) {
		this.setCode(code);
		this.setMsg(msg);
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
}

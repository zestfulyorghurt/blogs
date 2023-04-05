package com.zestfulYoghurt.zy.common;
import java.io.Serializable;

public class Message implements Serializable {

	public static final String Success = "处理成功";
	public static final String AuthenticationError = "用户认证失败";
	public static final String ModelCheckError = "非法的数据";
	public static final String NoPermissionError = "没有权限";
	public static final String RegistError = "注册失败";
}

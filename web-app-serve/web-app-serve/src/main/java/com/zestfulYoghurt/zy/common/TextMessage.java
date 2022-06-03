package com.zestfulYoghurt.zy.common;

import java.io.Serializable;

/**
 * @author 860120017
 * @title: MessageBean
 * @projectName zy
 * @description: TODO 系统信息实体BEAN
 * @date 2021/11/0916:30
 */

public class TextMessage implements Serializable {

    private static final long serializableUID = 6L;

    public static String SYS_ERROR = "系统异常";

    public static String LOGIN_FAIL = "用户名或密码不正确";

    public static String LOGIN_FAIL_USER = "登录失败，用户名不正确";

    public static String LOGIN_FAIL_PASSWORD = "登录失败，密码不正确";

    public static String LOGIN_SUCCESS = "登陆成功";

    public static String NO_PERMISSION = "没有权限";

    public static String PARAM_ERROR = "参数传递异常！";

    public static String REGISTER_ERROR = "用户注册失败！";

    public static String USERNAME_REPETITION = "用户名已经存在，请更换用户名";

    public static String DATA_FORMAT_ERROR = "数据格式异常";

}

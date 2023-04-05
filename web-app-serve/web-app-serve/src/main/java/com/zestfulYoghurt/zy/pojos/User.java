package com.zestfulYoghurt.zy.pojos;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import com.zestfulYoghurt.zy.tool.JsonConvert;

import lombok.Data;

@Data
public class User implements Serializable, BasePojo {

    //user的id(主键)
    private int userId;

    //用户名,用户的真实姓名，可以为空
    private String userName;

    //用户昵称，在网站中的名称，不能为空，且是不可重复的
    private String nickName;

    //用户邮箱，可以为空，但是要进行邮箱格式验证
    private String email;

    //用户手机号，可以为空，但是得进行手机号码验证
    private String phoneNumber;

    //用户性别 可以为空
    private String sex;

    //用户头像地址 可以为空
    private String avatar;

    //定义用户密码 不能为空
    private String password;

    //定义用户加密的盐 不能为空
    private String salt;

    //账号状态 不能为空
    private String status;

    //定义删除标志 不能为空，0代表逻辑删除，1代表逻辑存在
    private String deleteFlag;

    //最后登录ip
    private String loginIp;

    //最后登录时间
    private String loginDate;

    //创建时间
    private String createTime;

    //更新时间
    private String updateTime;

    //定义用户拥有的角色
    private Set<Role> Roles;

    //存到数据库字符串格式的roles
    private String roles;

    //用户信息check
    private boolean isValued = true;

    //用户数据初始化
	@SuppressWarnings("unchecked")
	public void dataConvert() throws IOException {
        if (Roles != null)
        {
        	roles = JsonConvert.ObjectToJson(Roles);
        }
        if(roles != null)
        {
        	Roles = (Set<Role>)JsonConvert.JsonToObject(roles);
        }
    }

    @Override
    public Boolean validate() {

    	//将对象类型转换为字符串存到数据库
    	//从数据库查出字符串转换为对象
    	try {
			dataConvert();
		} catch (IOException e) {
			isValued = false;
			return isValued;
		}

        if(userName == null || "".equals(userName)){
            isValued = false;
        }

        if(password == null || "".equals(password)){
            isValued = false;
        }

        return isValued;
    }
}

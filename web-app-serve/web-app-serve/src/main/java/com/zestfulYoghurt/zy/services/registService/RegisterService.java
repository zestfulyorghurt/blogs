package com.zestfulYoghurt.zy.services.registService;

import com.zestfulYoghurt.zy.pojos.Result;
import com.zestfulYoghurt.zy.pojos.User;

public interface RegisterService {

    Result<Object> register(User user);

}

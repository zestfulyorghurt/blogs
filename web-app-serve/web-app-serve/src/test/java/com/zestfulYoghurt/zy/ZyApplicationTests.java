package com.zestfulYoghurt.zy;

import com.zestfulYoghurt.zy.mappers.UserMapper;
import com.zestfulYoghurt.zy.pojos.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ZyApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        log.info("zhangyi");
        User user = new User();
        user.setUserName("zhangyi");
        log.debug("zhang");
    }

}

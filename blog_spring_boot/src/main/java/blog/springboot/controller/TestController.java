package blog.springboot.controller;

import blog.springboot.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    public TestMapper pppp;

    @RequestMapping("/test")
    public String test()
    {
        log.debug("zhangyi");
        log.error("zhangyi");
        pppp.select();
        return "zhangyi";


    }
}

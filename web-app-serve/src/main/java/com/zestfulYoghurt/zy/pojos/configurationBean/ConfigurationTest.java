package com.zestfulYoghurt.zy.pojos.configurationBean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nnn")
@Data
public class ConfigurationTest {

    private String name;

}

package com.buildup.bu.Config.PropertiesConf;

import com.buildup.bu.Config.ConstructorProperties.RedisConstructorProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value={RedisConstructorProperties.class})
public class RedisPropertiesConf {
}

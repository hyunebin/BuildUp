package com.buildup.bu.Config.PropertiesConf;

import com.buildup.bu.Config.ConstructorProperties.SecretKeyConstructorProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value={SecretKeyConstructorProperties.class})
public class SecretKeyPropertiesConf {

}

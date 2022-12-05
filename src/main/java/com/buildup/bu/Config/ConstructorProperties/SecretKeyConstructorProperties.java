package com.buildup.bu.Config.ConstructorProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties("external")
public class SecretKeyConstructorProperties {
    private final String secretKey;
}

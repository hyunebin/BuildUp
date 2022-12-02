package com.buildup.bu.Component;

import com.buildup.bu.Model.Oauth.UserDto;
import com.buildup.bu.Persist.Entity.Users;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper {
    public Users of(OAuth2User oAuth2User) {
        var attributes = oAuth2User.getAttributes();
        return Users.builder()
                .email((String)attributes.get("email"))
                .name((String)attributes.get("name"))
                .type("Kakao")
                .build();
    }
}
package com.example.club.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Getter
@Setter
@ToString
public class ClubAuthMemberDto extends User implements OAuth2User {

    private String email;

    private String password;

    private String name;

    private boolean formSocial;

    private Map<String,Object> attr;

    public ClubAuthMemberDto(
            String username,
            String password,
            boolean formSocial,
            Collection<? extends GrantedAuthority> authorities,
            Map<String,Object> attr) {
        this(username, password ,formSocial,authorities);
        this.attr = attr;
    }


    public ClubAuthMemberDto(
            String username,
            String password,
            boolean formSocial,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.password = password;
        this.formSocial = formSocial;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }
}

package com.uni.authority.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songning
 * @date 2020/4/30
 * description
 */
public class UserDetailHandler implements UserDetailsService {

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SoUserEntity entity = securityUserRepository.findByName(username);
        if (entity == null) {
            throw new UsernameNotFoundException(username + "用户不存在!");
        }

        String[] roles = entity.getRoles().split(",");
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (int i = 0; i < roles.length; i++) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roles[i]));
        }
        return new User(username, entity.getPassword(), authorities);
    }
}

package com.yhh.springsecurity.jettydbbasicauthentication.auth;

import com.yhh.springsecurity.jettydbbasicauthentication.dao.AuthoritiesMapper;
import com.yhh.springsecurity.jettydbbasicauthentication.dao.Users;
import com.yhh.springsecurity.jettydbbasicauthentication.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    AuthoritiesMapper authoritiesMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersMapper.selectByPrimaryKey(username);

        if (users == null) {
            throw new UsernameNotFoundException("the username is not exist");
        }

        List<String> authorities = authoritiesMapper.selectByUsername(username);
        String authstr = authorities.toString();
        authstr = authstr.substring(1, authstr.length()-1);

        System.out.println(username);

        return User.builder()
                .username(username)
                .password(users.getPassword())
                .disabled(!users.getEnabled())
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(authstr))
                .build();
    }
}

package com.kendo.security.service;

import com.kendo.security.bean.Principal;
import com.kendo.security.mapper.PrincipalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Service
@Transactional
public class KendoUserDetailsService implements UserDetailsService {

    @Autowired
    private PrincipalMapper principalMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Principal principal = principalMapper.selectByUsername(username);
        principal = Objects.requireNonNull(principal, () -> username + " not found!");

        return new User(
                principal.getUsername(),
                principal.getPassword(),
                getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
    }
}

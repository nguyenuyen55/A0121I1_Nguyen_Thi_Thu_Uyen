package com.codegym.casestudy.service.Implement;

import com.codegym.casestudy.entity.Role;
import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.repository.RepositoryRole;
import com.codegym.casestudy.repository.RepositoryUser_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    RepositoryUser_Role repositoryUser_role;

    @Autowired
    RepositoryRole repositoryRole;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repositoryUser_role.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found");
        }
// Lấy các quyền của user trong database
        List<Role> roles = repositoryUser_role.getRolesName(username);
        List<String> roleName = new ArrayList<>();
        for (Role role : roles) {
            roleName.add(role.getRole_name());
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roleName != null) {
            for (String role : roleName) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                grantedAuthorities.add(grantedAuthority);
            }
        }
        // tạo user theo cacsh của spring security
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}

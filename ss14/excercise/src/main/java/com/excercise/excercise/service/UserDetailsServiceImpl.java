package com.excercise.excercise.service;


import com.excercise.excercise.entity.AppUser;
import com.excercise.excercise.entity.UserRole;
import com.excercise.excercise.repository.AppUserRepository;
import com.excercise.excercise.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired

    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> roleRoles = this.userRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleRoles != null) {
            for (UserRole userRole : roleRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }

}
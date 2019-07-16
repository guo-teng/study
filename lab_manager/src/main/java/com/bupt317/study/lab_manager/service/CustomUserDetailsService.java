package com.bupt317.study.lab_manager.service;

import com.bupt317.study.lab_manager.mapper.UserMapper;
import com.bupt317.study.lab_manager.pojo.CustomUserDetails;
import com.bupt317.study.lab_manager.pojo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user=userMapper.selectbyusername(username);
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        if (user==null)
        {
            throw new UsernameNotFoundException("no account");
        }
        else
        {
            if(user.getAuthority().equals("M"))
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            else
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            CustomUserDetails userDetails=new CustomUserDetails(user.getUsername(),user.getPassword(),authorities);
            return userDetails;
        }


    }
}

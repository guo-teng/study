package com.bupt317.study.lab_manager.config;

import com.bupt317.study.lab_manager.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*这是一个配置类,用来配置web的安全细节,是权限控制的主要文件之一*/
@Configuration

/* 控制权限到请求方法级别*/
@EnableGlobalMethodSecurity(securedEnabled = true)

/*禁用spring boot默认的配置，配合@configuration默认配置*/
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    //@Autowired
    //public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.inMemoryAuthentication()
    //            .passwordEncoder(new BCryptPasswordEncoder()).withUser("name").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    //}
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    /*方法重写*/
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //请求配置权限
        http.authorizeRequests()
                //指定了不需要认证就可以访问的页面
                .antMatchers("/index","/","/register","/register_user").permitAll()
                //任何访问都要验证
                .anyRequest().authenticated().and()
                //异常处理403页面
                .exceptionHandling().accessDeniedPage("/deny").and()
                //定义登陆页，登陆成功后跳转页，及权限
                .formLogin().loginPage("/index").failureUrl("/index").defaultSuccessUrl("/home").permitAll().and()
                //定义用户退出
                .logout().logoutUrl("/login_out").logoutSuccessUrl("/index").invalidateHttpSession(true).and()
                //关闭跨站防护
                .csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        //解决静态资源拦截问题
        web.ignoring().antMatchers("/js/**","/css/**","/picture/**");
    }

}

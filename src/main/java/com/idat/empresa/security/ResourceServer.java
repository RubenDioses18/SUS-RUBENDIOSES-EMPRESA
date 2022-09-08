package com.idat.empresa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // TODO Auto-generated method stub
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/empresa/**")
			.hasAnyRole("USER","ADM")
            .antMatchers("/empresa/**")
            .hasAnyRole("ADM")
			.and()
			.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
            ;
    }
}

package com.idat.empresa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter{

    @Autowired
	private TokenStore store;
	
	@Autowired
	private AuthenticationManager manager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // TODO Auto-generated method stub
        endpoints.tokenStore(store).authenticationManager(manager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // TODO Auto-generated method stub
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // TODO Auto-generated method stub
        clients.inMemory().withClient("ruben")
			.secret(new BCryptPasswordEncoder().encode("dioses"))
			.authorizedGrantTypes("password","refresh_token","implicit","authorization_code")
			.scopes("read","write","trust")
			.accessTokenValiditySeconds(1*60*60)
			.refreshTokenValiditySeconds(5*60*60);
    }
}

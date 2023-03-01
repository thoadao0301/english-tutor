package com.thoa.englishTutor.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

@KeycloakConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,
        jsr250Enabled = true)
@ComponentScan(basePackageClasses = KeycloakSecurityConfig.class)
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    private static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
    };

    private static final String[] USER_LOGIN = {
            "/api/v1/user/checkEmailIfExist",
            "/api/v1/user/studentRegister",
            "/api/v1/user/tutorRegister",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(SWAGGER_WHITELIST)
                .permitAll()
                .antMatchers(USER_LOGIN)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(new SimpleCORSFilter(), WebAsyncManagerIntegrationFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .logout()
                .addLogoutHandler(keycloakLogoutHandler())
                .logoutUrl("/user/logout").permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
    }

    /**
     * Registers the KeycloakAuthenticationProvider with the authentication manager
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider  = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper()); // prefix = "ROLE_
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    protected AuthenticationEntryPoint authenticationEntryPoint() throws Exception {
        return new RestAuthenticationEntryPoint(adapterDeploymentContext());
    }

}

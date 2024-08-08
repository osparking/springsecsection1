package com.bumsoap.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BumsoapUserPassAuthenProvider implements AuthenticationProvider {

    private final BumsoapUserDetailsService bumsoapUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * @param authentication the authentication request object.
     * @return
     * @throws BadCredentialsException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String plainPwd =  authentication.getCredentials().toString();
        UserDetails userDetails = bumsoapUserDetailsService.loadUserByUsername(username);
        if (passwordEncoder.matches(plainPwd, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, plainPwd, userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("자격정보 오류");
        }
    }

    /**
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

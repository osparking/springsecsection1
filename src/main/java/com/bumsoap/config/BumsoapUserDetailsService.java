package com.bumsoap.config;

import com.bumsoap.model.Customer;
import com.bumsoap.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BumsoapUserDetailsService  implements UserDetailsService {

    private final CustomerRepository customerRepository;

    /**
     * @param username 자료를 읽어올 유저 식별 필드
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String msg = username + "은 존재하지 않습니다.";
        Customer customer = customerRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(msg));
        List<GrantedAuthority> roles = List.of(new SimpleGrantedAuthority(customer.getRole()));

        return new User(customer.getEmail(), customer.getPwd(), roles);
    }
}

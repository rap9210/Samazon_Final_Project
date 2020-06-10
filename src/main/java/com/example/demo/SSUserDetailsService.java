package com.example.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

    public SSUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Customer appUser = customerRepository.findByUserName(username);

            if(appUser == null){
                System.out.println("User not found with the provided username" + appUser.toString());
                return null;
            }

            System.out.println(" User from username " + appUser.toString());
            return new CustomUserDetails(appUser, getAuthorities(appUser));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(Customer appUser) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getRoles());
        authorities.add(grantedAuthority);

        System.out.println("User authorities are" + authorities.toString());
        return authorities;
    }


}

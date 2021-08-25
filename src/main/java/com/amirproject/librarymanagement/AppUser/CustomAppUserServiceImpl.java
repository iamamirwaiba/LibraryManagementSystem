package com.amirproject.librarymanagement.AppUser;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@ToString
public class CustomAppUserServiceImpl implements UserDetailsService {
    private final AppUserRepo appUserRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            AppUser appUser=appUserRepo.findByEmail(email).get();
            return new User(appUser.getEmail(),appUser.getPassword(),new ArrayList<>());
    }
}

package com.amirproject.librarymanagement.SignIn;

import com.amirproject.librarymanagement.AppUser.AppUserRepo;
import com.amirproject.librarymanagement.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInServiceImpl implements SignInService {

    private final JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final AppUserRepo appUserRepo;
    @Override
    public String SignIn(SignInRequest request) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        }
        catch (Exception e){
            throw new Exception("Email/password not correct");
        }
        return jwtUtil.generateToken(request.getEmail());

    }
}

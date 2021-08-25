package com.amirproject.librarymanagement.SignUp;

import com.amirproject.librarymanagement.AppUser.AppUser;
import com.amirproject.librarymanagement.AppUser.AppUserRepo;
import com.amirproject.librarymanagement.Validator.CredentialValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AppUserRepo appUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CredentialValidator credentialValidator;


    @Override
    public String signUp(SignUpRequest request) {
        AppUser appUser = new AppUser(request.getName(), request.getEmail(), request.getPhoneNumber(), request.getPassword(), request.getBatch(), request.getFaculty(), request.getClassNo(), request.getRollNo(),request.getDOB());
        Optional<AppUser> appUser1 = appUserRepo.findByEmail(request.getEmail());
        if(!credentialValidator.emailValidatio(request.getEmail())){
            return "Email not Valid";
        }
        else if(!credentialValidator.phoneNumberValidation(request.getPhoneNumber())){
            return "PhoneNumber not Valid";
        }

        if (appUser1.isPresent()) {
            return "Already Registered";
        } else {
            String encodedPassword= bCryptPasswordEncoder.encode(appUser.getPassword());
            appUser.setPassword(encodedPassword);
            appUserRepo.save(appUser);
            return "registration successful";
        }
    }
}

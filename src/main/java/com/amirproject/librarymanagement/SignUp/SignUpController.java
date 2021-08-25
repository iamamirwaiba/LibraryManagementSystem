package com.amirproject.librarymanagement.SignUp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/public")

public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/Register")
    public Map<String,String> signUp(@RequestBody SignUpRequest request){
        String message=signUpService.signUp(request);
        Map<String,String> frs=new HashMap<>();
        frs.put("message",message);
        return frs;

    }
}

package com.amirproject.librarymanagement.SignIn;

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
public class SignInController {
    private final SignInService signInService;

    @PostMapping("/SignIn")
    public Map<String,String> signin(@RequestBody SignInRequest request) throws Exception {
       String message= signInService.SignIn(request);
       Map<String,String> lms=new HashMap<>();
       lms.put("token",message);
       return lms;
    }

}

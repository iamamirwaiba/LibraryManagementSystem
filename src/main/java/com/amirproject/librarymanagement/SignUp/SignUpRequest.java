package com.amirproject.librarymanagement.SignUp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SignUpRequest {
    private final String name;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String batch;
    private final String faculty;
    private final String classNo;
    private final String rollNo;
    private final String DOB;
}

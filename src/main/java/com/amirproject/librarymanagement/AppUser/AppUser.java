package com.amirproject.librarymanagement.AppUser;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name="app_user")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    private String email;
    @Column(name="phone_numeber")
    private String phoneNumber;
    private String password;
    private String batch;
    private String faculty;
    @Column(name = "class_no")
    private String classNo;
    @Column(name="roll_no")
    private String rollNo;
    private String DOB;


    public AppUser(String name, String email, String phoneNumber, String password, String batch, String faculty, String classNo, String rollNo,String DOB) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.batch = batch;
        this.faculty = faculty;
        this.classNo = classNo;
        this.rollNo = rollNo;
        this.DOB=DOB;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

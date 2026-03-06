package org.demo.foreel.service;

import org.demo.foreel.model.Role;
import org.demo.foreel.model.User;
import org.demo.foreel.repository.RoleRepo;
import org.demo.foreel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String Register(User user){
        if(userRepo.existsByEmail(user.getEmail())){
            return "Email Already Exists";
        }
        if(userRepo.existsByPhoneNo(user.getPhoneNo())){
            return "Phone Already Exists";
        }
        user.setPassword(encoder.encode(user.getPassword()));

        userRepo.save(user);
        return "Register Success";
    }
}

package org.demo.doctorappointment.service;

import org.demo.doctorappointment.dto.UserSyncDTO;
import org.demo.doctorappointment.model.User;
import org.demo.doctorappointment.repository.UserRepo;
import org.springframework.stereotype.Service;

// ✅ FIX #3: This service handles saving a user coming from the auth microservice.
//            Auth service must call POST /api/users/sync after every successful signup.
@Service
public class UserSyncService {

    private final UserRepo userRepo;

    public UserSyncService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void syncUser(UserSyncDTO dto) {
        // Avoid duplicate inserts if user already exists
        if (userRepo.findByEmail(dto.getEmail()).isPresent()) return;

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();

        userRepo.save(user);
    }
}
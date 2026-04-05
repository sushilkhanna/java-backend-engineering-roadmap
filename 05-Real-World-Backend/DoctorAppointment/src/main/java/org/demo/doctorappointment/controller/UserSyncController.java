package org.demo.doctorappointment.controller;

import org.demo.doctorappointment.dto.UserSyncDTO;
import org.demo.doctorappointment.service.UserSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// ✅ FIX #3: Auth service calls this endpoint after every successful signup
//            so user data is available in the appointment service's own DB.
//            Without this, bookAppointment() always fails with 404.
@RestController
@RequestMapping("/api/users")
public class UserSyncController {

    private final UserSyncService userSyncService;

    public UserSyncController(UserSyncService userSyncService) {
        this.userSyncService = userSyncService;
    }

    @PostMapping("/sync")
    public ResponseEntity<Map<String, String>> syncUser(@RequestBody UserSyncDTO dto) {
        userSyncService.syncUser(dto);
        return ResponseEntity.ok(Map.of("message", "User synced successfully"));
    }
}
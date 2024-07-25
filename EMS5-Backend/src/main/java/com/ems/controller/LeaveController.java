package com.ems.controller;

import com.ems.dto.LeaveDto;
import com.ems.entity.LeaveEntity;
import com.ems.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/post")
    public ResponseEntity<LeaveEntity> createRequest(@RequestBody LeaveDto leaveDto) {
        LeaveEntity newRequest = leaveService.createRequest(leaveDto);
        return ResponseEntity.ok(newRequest);
    }

    
    
    @GetMapping("/get")
    public ResponseEntity<List<LeaveEntity>> getAllRequests() {
        List<LeaveEntity> requests = leaveService.getAllRequests();
        return ResponseEntity.ok(requests);
    }
    
    

    @GetMapping("/{id}")
    public ResponseEntity<LeaveEntity> getRequestById(@PathVariable Long id) {
        LeaveEntity request = leaveService.getRequestById(id);
        return ResponseEntity.ok(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveEntity> updateRequest(@PathVariable Long id, @RequestBody LeaveDto leaveDto) {
        LeaveEntity updatedRequest = leaveService.updateRequest(id, leaveDto);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        leaveService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}

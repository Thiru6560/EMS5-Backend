//
//package com.ems.serviceImpl;
//
//import com.ems.dto.LeaveDto;
//import com.ems.entity.LeaveEntity;
//import com.ems.repository.LeaveRepo;
//import com.ems.service.LeaveService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class LeaveServiceImpl implements LeaveService {
//
//    @Autowired
//    private LeaveRepo leaveRepo;
//
//    private String generateRequestId() {
//        return "REQ" + UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
//    }
//
//    private String getCurrentDateTime() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        return LocalDateTime.now().format(formatter);
//    }
//
//    @Override
//    public LeaveEntity createRequest(LeaveDto leaveDto) {
//        LeaveEntity request = new LeaveEntity();
//        request.setRequestId(generateRequestId());  // Generate unique requestId
//        request.setEmployeeId(leaveDto.getEmployeeId());
//        request.setRequestType(leaveDto.getRequestType());
//        request.setReason(leaveDto.getReason());
//        request.setRequestedDateTime(getCurrentDateTime());  // Set current date and time in 24-hour format
//        request.setApprovalStatus(leaveDto.getApprovalStatus());
//        request.setApproverId(leaveDto.getApproverId());
//        request.setComments(leaveDto.getComments());
//        return leaveRepo.save(request);
//    }
//
//    @Override
//    public List<LeaveEntity> getAllRequests() {
//        return leaveRepo.findAll();
//    }
//
//    @Override
//    public LeaveEntity getRequestById(Long id) {
//        return leaveRepo.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
//    }
//
//    @Override
//    public LeaveEntity updateRequest(Long id, LeaveDto leaveDto) {
//        LeaveEntity existingRequest = getRequestById(id);
//        existingRequest.setRequestId(existingRequest.getRequestId());  // Preserve the original requestId
//        existingRequest.setEmployeeId(leaveDto.getEmployeeId());
//        existingRequest.setRequestType(leaveDto.getRequestType());
//        existingRequest.setReason(leaveDto.getReason());
//        existingRequest.setRequestedDateTime(existingRequest.getRequestedDateTime());  // Preserve the original date and time
//        existingRequest.setApprovalStatus(leaveDto.getApprovalStatus());
//        existingRequest.setApproverId(leaveDto.getApproverId());
//        existingRequest.setComments(leaveDto.getComments());
//        return leaveRepo.save(existingRequest);
//    }
//
//    @Override
//    public void deleteRequest(Long id) {
//        leaveRepo.deleteById(id);
//    }
//}





















package com.ems.serviceImpl;

import com.ems.dto.LeaveDto;
import com.ems.entity.LeaveEntity;
import com.ems.repository.LeaveRepo;
import com.ems.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepo leaveRepo;

    private String generateRequestId() {
        return "REQ" + UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
    }

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    @Override
    public LeaveEntity createRequest(LeaveDto leaveDto) {
        LeaveEntity request = new LeaveEntity();
        request.setRequestId(generateRequestId());
        request.setEmployeeId(leaveDto.getEmployeeId());
        request.setRequestType(leaveDto.getRequestType());
        request.setReason(leaveDto.getReason());
        request.setRequestedDateTime(getCurrentDateTime());
        request.setApprovalStatus(leaveDto.getApprovalStatus());
        request.setApproverId(leaveDto.getApproverId());
        request.setComments(leaveDto.getComments());
        return leaveRepo.save(request);
    }

    @Override
    public List<LeaveEntity> getAllRequests() {
        return leaveRepo.findAll();
    }

    @Override
    public LeaveEntity getRequestById(Long id) {
        return leaveRepo.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @Override
    public LeaveEntity updateRequest(Long id, LeaveDto leaveDto) {
        LeaveEntity existingRequest = getRequestById(id);

        // Preserve original values for fields that should not be changed
        existingRequest.setRequestId(existingRequest.getRequestId());
        existingRequest.setRequestedDateTime(existingRequest.getRequestedDateTime());

        // Update fields with new values
        existingRequest.setEmployeeId(leaveDto.getEmployeeId());
        existingRequest.setRequestType(leaveDto.getRequestType());
        existingRequest.setReason(leaveDto.getReason());
        
        // Update the updated date and time when approval status is changed
        if (!existingRequest.getApprovalStatus().equals(leaveDto.getApprovalStatus())) {
            existingRequest.setApprovalStatus(leaveDto.getApprovalStatus());
            existingRequest.setUpdatedDateTime(getCurrentDateTime());
        } else {
            existingRequest.setApprovalStatus(leaveDto.getApprovalStatus());
        }

        existingRequest.setApproverId(leaveDto.getApproverId());
        existingRequest.setComments(leaveDto.getComments());
        
        return leaveRepo.save(existingRequest);
    }

    @Override
    public void deleteRequest(Long id) {
        leaveRepo.deleteById(id);
    }
}

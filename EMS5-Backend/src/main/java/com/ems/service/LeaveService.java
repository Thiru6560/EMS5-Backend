package com.ems.service;

import com.ems.dto.LeaveDto;
import com.ems.entity.LeaveEntity;

import java.util.List;

public interface LeaveService {
    LeaveEntity createRequest(LeaveDto leaveDto);
    List<LeaveEntity> getAllRequests();
    LeaveEntity getRequestById(Long id);
    LeaveEntity updateRequest(Long id, LeaveDto leaveDto);
    void deleteRequest(Long id);
}

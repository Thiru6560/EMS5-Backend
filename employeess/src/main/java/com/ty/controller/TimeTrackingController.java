package com.ty.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ty.repository.TimeTrackingRepository;
import com.ty.timetracking.TimeTracking;

import java.time.LocalDateTime;
import java.util.Comparator;

@RestController
@RequestMapping("/time-tracking")
public class TimeTrackingController {

    @Autowired
    private TimeTrackingRepository repository;

    @PostMapping("/clock-in")
    public TimeTracking clockIn(@RequestParam Long employeeId) {
        TimeTracking timeTracking = new TimeTracking();
        timeTracking.setEmployeeId(employeeId);
        timeTracking.setClockIn(LocalDateTime.now());
        return repository.save(timeTracking);
    }

    @PostMapping("/clock-out")
    public TimeTracking clockOut(@RequestParam Long employeeId) {
      TimeTracking timeTracking = repository.findById(employeeId).orElseThrow();
        timeTracking.setClockOut(LocalDateTime.now());
        return repository.save(timeTracking);
    }
    
//     @PostMapping("/clock-out")
//    public TimeTracking clockOut(@RequestParam Long employeeId) {
//        TimeTracking timeTracking = repository.findById(employeeId)
//            .orElseThrow(() -> new RuntimeException("No clock-in record found for employee id: " + employeeId));
//        timeTracking.setClockOut(LocalDateTime.now());
//        return repository.save(timeTracking);
//    }

    
    

    @PostMapping("/start-break")
    public TimeTracking startBreak(@RequestParam Long employeeId) {
        TimeTracking timeTracking = repository.findById(employeeId).orElseThrow();
        timeTracking.setBreakStart(LocalDateTime.now());
        return repository.save(timeTracking);
    }

    @PostMapping("/end-break")
    public TimeTracking endBreak(@RequestParam Long employeeId) {
        TimeTracking timeTracking = repository.findById(employeeId).orElseThrow();
        timeTracking.setBreakEnd(LocalDateTime.now());
        return repository.save(timeTracking);
    }


@GetMapping("/employee/latest")
public TimeTracking getLatestRecordByEmployeeId(@RequestParam Long employeeId) {
    return repository.findAll().stream()
                     .filter(record -> record.getEmployeeId().equals(employeeId))
                     .max(Comparator.comparing(TimeTracking::getClockIn))
                     .orElseThrow(() -> new RuntimeException("No records found for employee id: " + employeeId));
}
}


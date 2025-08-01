package com.campusconnect.campusconnect.controller;

import com.campusconnect.campusconnect.model.Leave;
import com.campusconnect.campusconnect.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepo;

    @GetMapping
    public String viewAllLeaves(Model model) {
        model.addAttribute("leaves", leaveRepo.findAll());
        return "leave/list";
    }

    @GetMapping("/add")
    public String showApplyForm(Model model) {
        model.addAttribute("leave", new Leave());
        return "leave/form";
    }

    @PostMapping("/save")
    public String applyLeave(@ModelAttribute Leave leave) {
        leave.setStatus(Leave.LeaveStatus.PENDING);
        leaveRepo.save(leave);
        return "redirect:/leaves";
    }

    @GetMapping("/approve/{id}")
    public String approveLeave(@PathVariable Long id) {
        Leave leave = leaveRepo.findById(id).orElseThrow();
        leave.setStatus(Leave.LeaveStatus.APPROVED);
        leaveRepo.save(leave);
        return "redirect:/leaves";
    }

    @GetMapping("/reject/{id}")
    public String rejectLeave(@PathVariable Long id) {
        Leave leave = leaveRepo.findById(id).orElseThrow();
        leave.setStatus(Leave.LeaveStatus.REJECTED);
        leaveRepo.save(leave);
        return "redirect:/leaves";
    }

    @GetMapping("/delete/{id}")
    public String deleteLeave(@PathVariable Long id) {
        leaveRepo.deleteById(id);
        return "redirect:/leaves";
    }
}

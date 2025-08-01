package com.campusconnect.campusconnect.controller;

import com.campusconnect.campusconnect.model.Schedule;
import com.campusconnect.campusconnect.model.Faculty;
import com.campusconnect.campusconnect.repository.FacultyRepository;
import com.campusconnect.campusconnect.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @GetMapping
    public String viewAll(Model model) {
        model.addAttribute("schedules", scheduleRepo.findAll());
        return "schedule/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("faculties", facultyRepo.findAll());
        model.addAttribute("mode", "add");
        return "schedule/form";
    }

    @PostMapping("/add")
    public String addSchedule(@ModelAttribute Schedule schedule) {
        scheduleRepo.save(schedule);
        return "redirect:/schedule";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Schedule schedule = scheduleRepo.findById(id).orElseThrow();
        model.addAttribute("schedule", schedule);
        model.addAttribute("faculties", facultyRepo.findAll());
        model.addAttribute("mode", "edit");
        return "schedule/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Schedule schedule) {
        schedule.setId(id);
        scheduleRepo.save(schedule);
        return "redirect:/schedule";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        scheduleRepo.deleteById(id);
        return "redirect:/schedule";
    }
}


package com.campusconnect.campusconnect.controller;

import com.campusconnect.campusconnect.model.Faculty;
import com.campusconnect.campusconnect.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepo;

    @GetMapping
    public String listFaculty(Model model) {
        model.addAttribute("faculties", facultyRepo.findAll());
        return "faculty/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "faculty/add";
    }

    @PostMapping("/add")
    public String addFaculty(@ModelAttribute Faculty faculty) {
        facultyRepo.save(faculty);
        return "redirect:/faculty";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Faculty faculty = facultyRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid faculty ID"));
        model.addAttribute("faculty", faculty);
        return "faculty/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateFaculty(@PathVariable Long id, @ModelAttribute Faculty faculty) {
        faculty.setId(id);
        facultyRepo.save(faculty);
        return "redirect:/faculty";
    }

    @GetMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyRepo.deleteById(id);
        return "redirect:/faculty";
    }
}


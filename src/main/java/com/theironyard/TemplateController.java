package com.theironyard;

import com.theironyard.entities.Assignment;
import com.theironyard.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TemplateController {

    @Autowired
    AssignmentRepository assignmentRepository;

    @RequestMapping(path = "/clear")
    public String clear(Model model){
        assignmentRepository.deleteAll();
        return "home";
    }

    @RequestMapping(path = "/")
    public String home(Model model){

        if(assignmentRepository.count() == 0) {
            ArrayList<Assignment> assignments = new ArrayList<>();

            assignments.add(new Assignment("Arrays and Classes", "Create 5 of your own class examples", true));
            assignments.add(new Assignment("Methods", "write constructors, setters, and getters", true));
            assignments.add(new Assignment("Control Flow", "Create a program that mimics an ATM.", true));
            assignments.add(new Assignment("Dynamic Data Structures", "Extend your ATM project to manage bank accounts.", true));
            assignments.add(new Assignment("Review", "Inventory tracking system", true));
            assignments.add(new Assignment("Object Oriented Programming", "Continue enhancing your inventory project", true));
            assignments.add(new Assignment("File I/O", "FileIO - save your work!", true));
            assignments.add(new Assignment("Testing and Debugging", "(File I/O ..Continued)", true));
            assignments.add(new Assignment("Review week 2", "Review of the last 2 weeks", true));
            assignments.add(new Assignment("JavaFX", "JavaFX app", false));
            assignments.add(new Assignment("Android", "Android app", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));
            assignments.add(new Assignment("ASSIGNMENT", "DESCRIPTION", false));

            assignmentRepository.save(assignments);
        }

        model.addAttribute("assignments", assignmentRepository.findAll());

        return "home";
    }
}

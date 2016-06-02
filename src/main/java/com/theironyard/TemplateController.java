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
            assignments.add(new Assignment("Agile User Stories & TDD", "Test First. Agile Test Driven Development.", false));
            assignments.add(new Assignment("HTTP Routes and HTML Templates", "create Microblog app \"Messages\" with Spark and Mustache", true));
            assignments.add(new Assignment("HTTP Sessions", "Add to microblog new project \"MoreMessages\"", true));
            assignments.add(new Assignment("Advanced HTTP Routes", "Fork 'PeopleWeb' read CSV file with Pagination", true));
            assignments.add(new Assignment("Review HTTP", "CRUD app using Spark", true));
            assignments.add(new Assignment("SQL Basics", "Clone GameTracker create new 'GameTrackerDb' using H2 database", true));
            assignments.add(new Assignment("API Joins", "Clone ToDoDatabase create new 'ToDoDb_Joins' and TDD", true));
            assignments.add(new Assignment("SQL API", "Clone People Web create new 'PeopleWebDb', SQL Paging", true));
            assignments.add(new Assignment("Spring Basics", "create MicroblogSpring", true));
            assignments.add(new Assignment("Hibernate Basics", "add database to MicroblogSpring", true));
            assignments.add(new Assignment("Hibernate Query Methods and Joins", "create 'Purchases' to show customer sales from CSV file", false));
            assignments.add(new Assignment("Scala Basics", "create 'HelloScala' to practice Scala fundamentals", false));
            assignments.add(new Assignment("Functional Scala", "Create 'ScalaPurchases' with purchases.csv", false));
            assignments.add(new Assignment("More Scala and Security", "Add to GameTrackerSpring to provide a secure login by Encrypting password", false));
            assignments.add(new Assignment("Playframework ...", "Create 'PlayGames' using Activator \"PlayScalaSeed\" Template", false));

            assignmentRepository.save(assignments);
        }

        model.addAttribute("assignments", assignmentRepository.findAll());

        return "home";
    }
}

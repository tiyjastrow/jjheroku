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

            assignments.add(new Assignment("Arrays and Classes", "HelloWorld", true));
            assignments.add(new Assignment("Methods", "Methods", true));
            assignments.add(new Assignment("Control Flow", "ATM", true));
            assignments.add(new Assignment("Dynamic Data Structures", "Banking", true));
            assignments.add(new Assignment("Review 1", "InventoryTracker", true));
            assignments.add(new Assignment("Object Oriented Programming", "OOinventory", true));
            assignments.add(new Assignment("File I/O", "FileIO", true));
            assignments.add(new Assignment("Testing and Debugging", "Countries", true));
            assignments.add(new Assignment("Review week 2", "People", true));
            assignments.add(new Assignment("JavaFX", "ContactsDesktop", true));
            assignments.add(new Assignment("Agile User Stories & TDD", "Trello board plus a TDD- project", false));
            assignments.add(new Assignment("Android", "AndroidContacts", false));
            assignments.add(new Assignment("HTTP Routes and HTML Templates", "Messages", true));
            assignments.add(new Assignment("Review Week 3", "HangmanGame", true));
            assignments.add(new Assignment("HTTP Sessions", "MoreMessages", true));
            assignments.add(new Assignment("Advanced HTTP Routes", "Fork of PeopleWeb", true));
            assignments.add(new Assignment("SQL Basics", "GameTrackerDb", true));
            assignments.add(new Assignment("Review HTTP", "CrudReviewHTTP", true));
            assignments.add(new Assignment("SQL Joins", "ToDoDb_Joins", true));
            assignments.add(new Assignment("JSON Routes (Spark)", "RegistrationForm", true));
            assignments.add(new Assignment("(Optional) SQL Review", "PeopleWebDb", false));
            assignments.add(new Assignment("Spring Basics", "MicroblogSpring", true));
            assignments.add(new Assignment("Hibernate Basics", "microblogDb", true));
            assignments.add(new Assignment("Hibernate Query Methods and Joins", "Purchases", false));
            assignments.add(new Assignment("Review Spring 1", "SpringCRUD", false));
            assignments.add(new Assignment("JSON Routes", "AnonUpload", true));
            assignments.add(new Assignment("JSON Routes Continued", "IronGram", true));
            assignments.add(new Assignment("More Spring Review", "HannibalLecturer", false));
            assignments.add(new Assignment("Scala Basics", "HelloScala", true));
            assignments.add(new Assignment("Functional Scala", "ScalaPurchases", true));
            assignments.add(new Assignment("More Scala and Security", "ScalaTraits", false));
            assignments.add(new Assignment("Group Project", "Game of 100", true));
            assignments.add(new Assignment("Playframework ...", "PlayGames", false));
            assignmentRepository.save(assignments);
        }

        model.addAttribute("assignments", assignmentRepository.findAll());

        return "home";
    }
}
